package com.example.springboot.controller;

import com.example.springboot.VO.ProductInfoVo;
import com.example.springboot.VO.ProductVo;
import com.example.springboot.VO.ResultVo;
import com.example.springboot.entity.ProductCategory;
import com.example.springboot.entity.ProductInfo;
import com.example.springboot.service.CategoryService;
import com.example.springboot.service.ProductService;
import com.example.springboot.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: Administrator
 * @Date: 2018/10/13 16:50
 * @Description:买家api
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVo list() {
        //1.查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //2.查询所有类目(一次性查询)

        //传统方法
//        List<Integer> categoryTypeList = new ArrayList<Integer>();
//        for (ProductInfo productInfo : productInfoList) {
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        //精简方式,java8 lamnda
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        //3.数据拼装
List<ProductVo> productVoList=new ArrayList<ProductVo>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVo productVo = new ProductVo();
            productVo.setCategoryName(productCategory.getCategoryName());
            productVo.setCategoryType(productCategory.getCategoryType());


            List<ProductInfoVo> productInfoVoList = new ArrayList<ProductInfoVo>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo, productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }
            }
            productVo.setProductInfoVoList(productInfoVoList);
            productVoList.add(productVo);
        }

        return ResultVOUtil.success(productVoList);
    }

}
