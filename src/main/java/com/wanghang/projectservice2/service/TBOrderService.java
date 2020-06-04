package com.wanghang.projectservice2.service;

import com.wanghang.projectsdk.base.entity.Order;
import com.wanghang.projectsdk.base.enumeration.OrderStatusType;
import com.wanghang.projectsdk.third.service.AbstractOrderService;
import com.wanghang.projectservice2.model.TBOrder;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author wanghang
 * 2020/5/26
 **/
@Service
public class TBOrderService extends AbstractOrderService<TBOrder> {

    @Override
    protected TBOrder convertToThird(Order order) {
        TBOrder tbOrder = new TBOrder();
        tbOrder.setTb_num(order.getNum());
        tbOrder.setTb_productNo(order.getProductNo());
        tbOrder.setTb_desc(order.getDesc());
        tbOrder.setTb_receiverAddress(order.getReceiverAddress());
        tbOrder.setTb_receiverName(order.getReceiverName());
        tbOrder.setTb_receiverPhone(order.getReceiverPhone());
        tbOrder.setTb_status(order.getStatus());
        tbOrder.setTb_totalPrice(order.getTotalPrice());
        tbOrder.setTb_userNo(order.getUserNo());
        tbOrder.setTb_no(order.getNo());

        return tbOrder;
    }

    @Override
    protected String placeThirdOrder(TBOrder tbOrder) {
        // TODO 调淘宝接口-MongoDB模拟
        return mockDoPlace(tbOrder).getTb_no();
    }

    private TBOrder mockDoPlace(TBOrder tbOrder) {
        tbOrder.setTb_id(132L);
        tbOrder.setTb_no(UUID.randomUUID().toString());
        tbOrder.setTb_status(OrderStatusType.BEFORE_DELIVERY.getKey());

        return tbOrder;
    }

    @Override
    public Integer doReceive(String no) {
        // TODO 调淘宝接口-MongoDB模拟
        TBOrder tbOrder = new TBOrder();
        tbOrder.setTb_no(no);
        tbOrder.setTb_status(OrderStatusType.RCEIVED.getKey());
        return tbOrder.getTb_status();
    }

    @Override
    public Integer doRemark(String no) {
        // TODO 调淘宝接口-MongoDB模拟
        TBOrder tbOrder = new TBOrder();
        tbOrder.setTb_no(no);
        tbOrder.setTb_status(OrderStatusType.REMARKED.getKey());
        return tbOrder.getTb_status();
    }

    @Override
    public Integer doRefund(String no, String desc) {
        // TODO 调淘宝接口-MongoDB模拟
        TBOrder tbOrder = new TBOrder();
        tbOrder.setTb_no(no);
        tbOrder.setTb_desc(desc);
        tbOrder.setTb_status(OrderStatusType.REFUNDIND.getKey());
        return tbOrder.getTb_status();
    }
}
