package com.xmlvhy.shop.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.xmlvhy.shop.common.utils.ResponseResult;
import com.xmlvhy.shop.service.CartService;
import com.xmlvhy.shop.service.OrderItemService;
import com.xmlvhy.shop.service.OrderService;
import com.xmlvhy.shop.service.ShippingService;
import com.xmlvhy.shop.vo.OrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Author: 小莫
 * Date: 2019-03-13 0:10
 * Description: 订单相关接口类
 */
@Slf4j
@Controller
@RequestMapping("/admin/analysis")
public class AnalysisController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ShippingService shippingService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;




    /**
     *功能描述: 客户所有订单展示列表
     * @Author 小莫
     * @Date 11:46 2019/03/26
     * @Param []
     * @return java.lang.String
     */
    @RequestMapping("/all")
    public String all(Model model){
//
        List<Map<String,Object>> saleTypeAnalysisList = orderService.getSaleTypeAnalysis();
        model.addAttribute("analysisInfo",saleTypeAnalysisList);
        log.info("所有数据分析列表:"+ JSON.toJSONString(saleTypeAnalysisList));
        return "analysisManager";
    }

    /**
     *功能描述: 确认收货
     * @Author 小莫
     * @Date 9:44 2019/03/30
     * @Param [confirmOrderId, session]
     * @return com.xmlvhy.shop.common.utils.ResponseResult
     */
    @RequestMapping("confirmSendOrder")
    @ResponseBody
    public ResponseResult confirmReceiveOrder(Integer confirmOrderId,Integer userId, HttpSession session){

        if (orderService.confirmSendOrderByCustomerIdAndOrderId(userId,confirmOrderId)) {
            return ResponseResult.success("已确认发货");
        }
        return ResponseResult.fail("确认发货失败");
    }



}
