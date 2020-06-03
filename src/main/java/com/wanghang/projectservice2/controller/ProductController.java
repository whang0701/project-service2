package com.wanghang.projectservice2.controller;


import com.google.common.collect.Lists;
import com.wanghang.projectsdk.base.entity.Product;
import com.wanghang.projectsdk.base.enumeration.ProductSourceType;
import com.wanghang.projectsdk.third.controller.IProductController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author wanghang
 * @Date 2020/4/8
 **/
@RestController
@RequestMapping("/taobao")
public class ProductController implements IProductController {

    @Override
    public List<Product> getListByRandom(Integer num) {
        List<Product> list = Lists.newArrayList();
        for (int i = 0; i < num; i++) {
            Product product = new Product();
            product.setSource(ProductSourceType.TAOBAO.getKey());
            product.setSourceName(ProductSourceType.TAOBAO.getValue());
            product.setAddress("是公司管理大富科技关键是道理就怪了的结果单价格式更改时结果科技馆的高房价");
            list.add(product);
        }

        return list;
    }
}
