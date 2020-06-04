package com.wanghang.projectservice2.controller;


import com.wanghang.projectsdk.base.entity.Remark;
import com.wanghang.projectsdk.third.controller.IRemarkController;
import com.wanghang.projectservice2.service.TBRemarkService;
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
public class TBRemarkController implements IRemarkController {
    @Autowired
    private TBRemarkService tbRemarkService;

    @Override
    public List<Remark> getListByProductNoAndSkipAndLimit(String productNo, Integer skip, Integer limit) {
        return tbRemarkService.getListByProductNoAndSkipAndLimit(productNo, skip, limit);
    }

    @Override
    public String doRemark(Remark remark) {
        return tbRemarkService.doRemark(remark);
    }
}
