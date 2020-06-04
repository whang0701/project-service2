package com.wanghang.projectservice2.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TBOrder {
    private Long tb_id;

    private String tb_no;

    private String tb_userNo;

    private String tb_productNo;

    private Integer tb_num;

    private BigDecimal tb_totalPrice;

    private Integer tb_status;

    private String tb_receiverName;

    private String tb_receiverPhone;

    private String tb_receiverAddress;

    private String tb_desc;
}