package com.tmall.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductListVo {

    private Integer id;
    private Integer categoryId;
    private String name;
    private String subtitle;
    private String mainImage;
    private BigDecimal price;
    private Integer status;

    private String imageHost;//图片服务器的url前缀

}
