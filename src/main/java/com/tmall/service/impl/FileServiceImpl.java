package com.tmall.service.impl;

import com.google.common.collect.Lists;
import com.tmall.service.IFileService;
import com.tmall.util.FTPUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@Service("iFileService")
public class FileServiceImpl implements IFileService {

    @Override
    public String upload(MultipartFile file, String path) {
        //原始文件名
        String fileName = file.getOriginalFilename();
        //扩展名
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
        String uploadFileName = UUID.randomUUID().toString() + "." + fileExtensionName;
        log.info("开始上传文件，上传文件的文件名：{}，上传的路径：{}，新文件名：{}", fileName, path, uploadFileName);

        File fileDir = new File(path);
        if (!fileDir.exists()){
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File targetFile = new File(path, uploadFileName);

        try {
            file.transferTo(targetFile);
            // 将targetFile上传到FTP服务器上
            FTPUtil.uploadFile(Lists.newArrayList(targetFile), "img");
            // 上传完之后，删除upload下面的文件
            targetFile.delete();
        } catch (IOException e) {
            log.error("上传文件异常", e);
            return null;
        }

        return targetFile.getName();
    }
}
