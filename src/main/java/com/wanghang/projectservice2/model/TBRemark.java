package com.wanghang.projectservice2.model;



import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TBRemark {
    private Long tb_id;

    private String tb_no;

    private String tb_userNo;

    private String tb_orderNo;

    private String tb_productNo;

    private String tb_productName;

    private BigDecimal tb_star;

    private Integer tb_stateFlag;

    private Date tb_createTime;

    private Date tb_updateTime;

    private String tb_content;



}