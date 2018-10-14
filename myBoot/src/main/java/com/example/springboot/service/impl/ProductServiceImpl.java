package com.example.springboot.service.impl;

import com.example.springboot.dao.ProductInfoDao;
import com.example.springboot.dto.CartDTO;
import com.example.springboot.entity.ProductInfo;
import com.example.springboot.enums.ProductStatusEnum;
import com.example.springboot.enums.ResultEnum;
import com.example.springboot.exception.SellException;
import com.example.springboot.service.ProductService;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/10/13 16:07
 * @Description:
 */
@Service
@DynamicUpdate
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

    @Override
    public void increaseStock(List<CartDTO> carDTOList) {
        for (CartDTO cartDTO : carDTOList) {
            ProductInfo productInfo = productInfoDao.findById(cartDTO.getProductId()).get();
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            productInfoDao.save(productInfo);
        }

    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> carDTOList) {

        for (CartDTO cartDTO : carDTOList) {
            ProductInfo productInfo = productInfoDao.findById(cartDTO.getProductId()).get();
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoDao.save(productInfo);
        }

    }
}
