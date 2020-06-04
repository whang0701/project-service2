package com.wanghang.projectservice2.service;

import com.google.common.collect.Lists;
import com.wanghang.projectsdk.base.entity.Product;
import com.wanghang.projectsdk.base.enumeration.ProductSourceType;
import com.wanghang.projectsdk.base.enumeration.ProductType;
import com.wanghang.projectsdk.third.service.AbstractProductService;
import com.wanghang.projectservice2.model.TBProduct;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/**
 * @author wanghang
 * 2020/5/26
 **/
@Service
public class TBProductService extends AbstractProductService<TBProduct> {

    @Override
    protected List<TBProduct> getThirdListByRandom(Integer num) {
        // TODO 调淘宝接口-MongoDB模拟
        List<TBProduct> list = Lists.newArrayList();
        for (int i = 0; i < num; i++) {
            list.add(mockTBProduct());
        }
        return list;
    }

    @Override
    protected TBProduct getThirdOneByNo(String no) {
        // TODO 调淘宝接口-MongoDB模拟
        TBProduct tbProduct = mockTBProduct();
        tbProduct.setTb_no(no);
        return tbProduct;
    }

    @Override
    protected Product convertThird(TBProduct tbProduct) {
        Product product = new Product();
        product.setNo(tbProduct.getTb_no());
        product.setSource(ProductSourceType.TAOBAO.getKey());
        product.setSourceName(ProductSourceType.TAOBAO.getValue());
        product.setName(tbProduct.getTb_name());
        product.setType(tbProduct.getTb_type());
        ProductType type = ProductType.getType(tbProduct.getTb_type());
        product.setTypeName(Objects.nonNull(type)? type.getValue() : "其它");
        product.setBrand(tbProduct.getTb_brand());
        product.setPrice(tbProduct.getTb_price());
        product.setImg0(tbProduct.getTb_img0());
        product.setImg1(tbProduct.getTb_img1());
        product.setImg2(tbProduct.getTb_img2());
        product.setStar(tbProduct.getTb_star());
        product.setStore(tbProduct.getTb_store());
        product.setAddress(tbProduct.getTb_address());
        product.setTags(Lists.newArrayList(tbProduct.getTb_tags().split("，")));
        product.setDesc(tbProduct.getTb_desc());
        product.setBirth(tbProduct.getTb_birth());

        return product;
    }

    private TBProduct mockTBProduct() {
        TBProduct tbProduct = new TBProduct();
        tbProduct.setTb_id(545265451654L);
        tbProduct.setTb_no("a6sg4s646g4s6af4a4af");
        tbProduct.setTb_name("联想(Lenovo)天逸510S 英特尔酷睿i5 个人商务台式机电脑主机(i5-9400 16G 1T+256G SSD WiFi Win10)23英寸");
        tbProduct.setTb_address("中国大陆");
        tbProduct.setTb_brand("联想（Lenovo）");
        try {
            tbProduct.setTb_birth(DateUtils.parseDate("2019-07-01", Locale.CHINA, "yyyy-MM-dd"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        tbProduct.setTb_createTime(new Date());
        tbProduct.setTb_desc("搭载第九代酷睿处理器，更多线程让多任务处理更轻松。16GB大容量内存，大幅度提升效率。小体积机箱搭载无线网卡，小空间轻松安放。" +
                "高速双硬盘，随享高速读写与海量存储。接口丰富。80万小时稳定测试。搭配显示器，整机更更省心。三年上门保修服务。");
        tbProduct.setTb_img0("gateway/upload/img/product/4f65as4fsa4f6sa4f65f4676a5s4fs.png");
        tbProduct.setTb_img1("gateway/upload/img/product/20200527004233.png");
        tbProduct.setTb_img2("gateway/upload/img/product/20200527004407.png");
        tbProduct.setTb_price(new BigDecimal("4499.00"));
        tbProduct.setTb_star(new BigDecimal("3.7"));
        tbProduct.setTb_store("联想淘宝自营旗舰店");
        tbProduct.setTb_tags("九代酷睿，淘宝秒杀，现货");
        tbProduct.setTb_type(ProductType.PC.getKey());
        tbProduct.setTb_updateTime(new Date());

        return tbProduct;
    }
}
