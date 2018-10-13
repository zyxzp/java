package com.example.springboot.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * @Auther: Administrator
 * @Date: 2018/10/13 12:55
 * @Description:
 */
@Entity
@DynamicUpdate
@Data
@Table(name = "product_category")
public class ProductCategory {

    /** 类目id */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer categoryId;

    /** 类目名称 */
    private  String categoryName;

    /** 类目编号 */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

}
