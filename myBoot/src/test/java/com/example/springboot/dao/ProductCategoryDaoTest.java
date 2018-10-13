package com.example.springboot.dao;

import com.example.springboot.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: Administrator
 * @Date: 2018/10/13 13:01
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {
    @Autowired
    private ProductCategoryDao dao;

    @Test
    public void findOneTest() {
        ProductCategory productCategory=dao.findById(1).get();
        Assert.assertNotNull(productCategory);
    }

    @Test
    public void saveTest() {
        ProductCategory category = new ProductCategory();
        category.setCategoryName("女生最爱");
        category.setCategoryType(3);
        ProductCategory result = dao.save(category);
        Assert.assertNotNull(result);

    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> typeList = Arrays.asList(2, 3, 4);
        List<ProductCategory> result = dao.findByCategoryTypeIn(typeList);
        Assert.assertNotEquals(0, result.size());

    }
}