package com.example.springboot.dto;

import lombok.Data;

/**
 * @Auther: Administrator
 * @Date: 2018/10/14 14:41
 * @Description:
 */
@Data
public class CartDTO {

    /** 商品ID. */
    private String  productId;

    /** 商品数量 */
    private Integer  productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
