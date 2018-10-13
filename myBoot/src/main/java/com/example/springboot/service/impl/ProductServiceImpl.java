package com.example.springboot.service.impl;

import com.example.springboot.dao.ProductInfoDao;
import com.example.springboot.entity.ProductInfo;
import com.example.springboot.enums.ProductStatusEnum;
import com.example.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/10/13 16:07
 * @Description:
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoDao productInfoDao;

    @Override
    public ProductInfo save(ProductInfo poductInfo) {
        return productInfoDao.save(poductInfo);
    }

    @Override
    public ProductInfo findById(String id) {
        return productInfoDao.findById(id).get();
    }

    @Override
    public Page<ProductInfo> findAll(Pageable page) {
        return productInfoDao.findAll(page);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoDao.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
}
