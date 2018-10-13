package com.example.springboot.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;

/**
 * @Auther: Administrator
 * @Date: 2018/10/13 15:21
 * @Description:商品实体
 */
@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;

    /** 商品名称 */
    private String productName;

    /** 单价 */
    private BigDecimal productPrice ;

    /** 库存 */
    private  Integer productStock;

    /** 描述 */
    private String productDescription;

    /** 小图 */
    private String productIcon;

    /** 商品状态，0正常，1下架 */
    private  Integer productStatus;

    /** 类目编号 */
    private  Integer categoryType;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

}
