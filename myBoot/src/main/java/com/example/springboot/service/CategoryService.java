package com.example.springboot.service;

import com.example.springboot.entity.ProductCategory;
import jdk.nashorn.internal.objects.PrototypeObject;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/10/13 13:49
 * @Description:
 */

public interface CategoryService {

    ProductCategory findOne(Integer id);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> typeList);

    ProductCategory save(ProductCategory productCategory);
}
