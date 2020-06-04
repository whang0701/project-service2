package com.wanghang.projectservice2.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TBProduct {
    private Long tb_id;

    private String tb_no;

    private String tb_name;

    private Integer tb_type;

    private String tb_brand;

    private BigDecimal tb_price;

    private String tb_img0;

    private String tb_img1;

    private String tb_img2;

    private BigDecimal tb_star;

    private String tb_store;

    private String tb_address;

    private String tb_tags;

    private Date tb_birth;

    private Date tb_createTime;

    private Date tb_updateTime;

    private String tb_desc;


}