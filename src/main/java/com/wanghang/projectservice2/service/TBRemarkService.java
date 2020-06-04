package com.wanghang.projectservice2.service;

import com.google.common.collect.Lists;
import com.wanghang.projectsdk.base.entity.Remark;
import com.wanghang.projectsdk.base.enumeration.ProductSourceType;
import com.wanghang.projectsdk.base.enumeration.StateFlagType;
import com.wanghang.projectsdk.third.service.AbstractRemarkService;
import com.wanghang.projectservice2.model.TBRemark;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author wanghang
 * 2020/5/26
 **/
@Service
public class TBRemarkService extends AbstractRemarkService<TBRemark> {

    @Override
    protected List<TBRemark> getThirdListByProductNoAndSkipAndLimit(String productNo, Integer skip, Integer limit) {
        // TODO 调淘宝接口-MongoDB模拟
        List<TBRemark> list = Lists.newArrayList();
        for (int i = 0; i < limit; i++) {
            list.add(mockTBRemark());
        }
        return list;
    }

    @Override
    protected Remark convertThird(TBRemark tbRemark) {
        Remark remark = new Remark();
        remark.setNo(tbRemark.getTb_no());
        remark.setUserNo(tbRemark.getTb_userNo());
        remark.setOrderNo(tbRemark.getTb_orderNo());
        remark.setProductNo(tbRemark.getTb_productNo());
        remark.setProductSource(ProductSourceType.TAOBAO.getKey());
        remark.setProductName(tbRemark.getTb_productName());
        remark.setStar(tbRemark.getTb_star());
        remark.setStateFlag(tbRemark.getTb_stateFlag());
        remark.setContent(tbRemark.getTb_content());
        remark.setCreateTime(tbRemark.getTb_createTime());
        remark.setUpdateTime(tbRemark.getTb_updateTime());

        return remark;
    }

    @Override
    protected TBRemark convertToThird(Remark remark) {
        TBRemark tbRemark = new TBRemark();
        tbRemark.setTb_orderNo(remark.getOrderNo());
        tbRemark.setTb_productName(remark.getProductName());
        tbRemark.setTb_productNo(remark.getProductNo());
        tbRemark.setTb_star(remark.getStar());
        tbRemark.setTb_stateFlag(remark.getStateFlag());
        tbRemark.setTb_updateTime(remark.getUpdateTime());
        tbRemark.setTb_userNo(remark.getUserNo());
        tbRemark.setTb_content(remark.getContent());
        tbRemark.setTb_createTime(remark.getCreateTime());
        return tbRemark;
    }

    @Override
    protected String remarkThird(TBRemark tbRemark) {
        // TODO 调淘宝接口-MongoDB模拟
        tbRemark.setTb_id(46546846464L);
        tbRemark.setTb_no(UUID.randomUUID().toString());
        tbRemark.setTb_createTime(new Date());
        tbRemark.setTb_updateTime(new Date());
        return tbRemark.getTb_no();
    }

    private TBRemark mockTBRemark() {
        TBRemark tbRemark = new TBRemark();
        tbRemark.setTb_id(545265451654L);
        tbRemark.setTb_no("a6sg4s646g4s6af4a4af");
        tbRemark.setTb_userNo("aljflasjfaf4a6f4f");
        tbRemark.setTb_orderNo("a6s4fda64fas4fsf4af54f");
        tbRemark.setTb_productName("联想(Lenovo)天逸510S 英特尔酷睿i5 个人商务台式机电脑主机(i5-9400 16G 1T+256G SSD WiFi Win10)23英寸");
        tbRemark.setTb_productNo("6a5g5165f5gd5565g4g");
        tbRemark.setTb_star(new BigDecimal("4.5"));
        tbRemark.setTb_content("美帝良心想还是香，就是太笨重了，性能还行吧能用几年");
        tbRemark.setTb_stateFlag(StateFlagType.VALID.getKey());
        tbRemark.setTb_createTime(new Date());
        tbRemark.setTb_updateTime(new Date());

        return tbRemark;
    }
}
