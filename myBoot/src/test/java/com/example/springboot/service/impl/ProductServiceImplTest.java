package com.example.springboot.service.impl;

import com.example.springboot.dao.ProductInfoDao;
import com.example.springboot.entity.ProductInfo;
import com.example.springboot.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: Administrator
 * @Date: 2018/10/13 16:17
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productServiceImpl;


    @Test
    public  void saveTest(){
        ProductInfo productInfo =new ProductInfo();
        productInfo.setProductId("222222");
        productInfo.setProductName("面包");
        productInfo.setProductDescription("mianbao");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setProductIcon("http://sss.png");
        productInfo.setCategoryType(1);
        productInfo.setProductPrice(new BigDecimal(39));
        productInfo.setProductStock(100);

        Assert.assertNotNull(productServiceImpl.save(productInfo));
    }
    @Test
    public void findById() {
        ProductInfo productInfo=productServiceImpl.findById("123456");
        Assert.assertNotNull(productInfo);
    }



    @Test
    public void findUpAll() {
        List<ProductInfo> result=productServiceImpl.findUpAll();
        Assert.assertNotEquals(0, result.size());
    }

    @Test
    public void findAll() {
        PageRequest request=new PageRequest(0,2);
        Page<ProductInfo> result=productServiceImpl.findAll(request);
//        System.out.println(result.getTotalElements());
        Assert.assertNotEquals(0, result.getTotalElements());
    }
}