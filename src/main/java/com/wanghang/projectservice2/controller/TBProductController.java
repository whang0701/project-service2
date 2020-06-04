package com.wanghang.projectservice2.controller;


import com.wanghang.projectsdk.base.entity.Product;
import com.wanghang.projectsdk.third.controller.IProductController;
import com.wanghang.projectservice2.service.TBProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TBProductController implements IProductController {
    @Autowired
    private TBProductService tbProductService;

    @Override
    public List<Product> getListByRandom(Integer num) {
        return tbProductService.getListByRandom(num);
    }

    @Override
    public Product getOneByNo(String no) {
        return tbProductService.getOneByNo(no);
    }
}
