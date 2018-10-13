package com.example.springboot.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/10/13 17:04
 * @Description:商品（包含类目）
 */
@Data
public class ProductVo {


    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVo> productInfoVoList;
}
