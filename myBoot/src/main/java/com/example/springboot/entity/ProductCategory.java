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

    /** 类目编号 唯一 */
    private Integer categoryType;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

}
