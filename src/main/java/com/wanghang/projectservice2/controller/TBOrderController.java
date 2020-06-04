package com.wanghang.projectservice2.controller;


import com.wanghang.projectsdk.base.entity.Order;
import com.wanghang.projectsdk.third.controller.IOrderController;
import com.wanghang.projectservice2.service.TBOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author wanghang
 * @Date 2020/4/8
 **/
@RestController
@RequestMapping("/taobao")
public class TBOrderController implements IOrderController {
    @Autowired
    private TBOrderService tbOrderService;


    @Override
    public String doPlace(Order order) {
        return tbOrderService.doPlace(order);
    }

    @Override
    public Integer doReceive(String no) {
        return tbOrderService.doReceive(no);
    }

    @Override
    public Integer doRemark(String no) {
        return tbOrderService.doRemark(no);
    }

    @Override
    public Integer doRefund(String no, String desc) {
        return tbOrderService.doRefund(no, desc);
    }
}
