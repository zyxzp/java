package com.example.springboot.dao;

import com.example.springboot.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/10/13 15:32
 * @Description:
 */
public interface ProductInfoDao extends JpaRepository<ProductInfo,String> {

    List<ProductInfo> findByProductStatus(Integer status);
}
