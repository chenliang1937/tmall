package com.tmall.controller.portal;

import com.tmall.common.ServerResponse;
import com.tmall.service.IProductService;
import com.tmall.vo.ProductDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("/detail")
    public ServerResponse<ProductDetailVo> detail(Integer productId){

    }

}
