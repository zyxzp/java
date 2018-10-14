package com.example.springboot.service;

import com.example.springboot.dto.CartDTO;
import com.example.springboot.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/10/13 15:54
 * @Description:
 */
public interface ProductService {

    ProductInfo save(ProductInfo poductInfo);

    ProductInfo findById(String id);

    Page<ProductInfo> findAll(Pageable page);

    /**
     * 查询所有上架商品
     */
    List<ProductInfo> findUpAll();

    //加库存
    void increaseStock(List<CartDTO> carDTOList);

    //扣库存
    void decreaseStock(List<CartDTO> carDTOList);

}
