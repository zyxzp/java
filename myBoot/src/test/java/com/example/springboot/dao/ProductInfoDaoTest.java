package com.example.springboot.dao;

import com.example.springboot.entity.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.Max;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: Administrator
 * @Date: 2018/10/13 15:33
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoDaoTest {
    @Autowired
    private ProductInfoDao productInfoDao;

    @Test
    public  void saveTest(){
        ProductInfo productInfo =new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("酸奶");
        productInfo.setProductDescription("milk");
        productInfo.setProductStatus(0);
        productInfo.setProductIcon("http://sss.png");
        productInfo.setCategoryType(1);
        productInfo.setProductPrice(new BigDecimal(2.9));
        productInfo.setProductStock(100);

        Assert.assertNotNull(productInfoDao.save(productInfo));
    }

    @Test
    public void findByProductStatus(){
        List<ProductInfo> result=productInfoDao.findByProductStatus(0);
        Assert.assertNotEquals(0, result.size());
    }
}