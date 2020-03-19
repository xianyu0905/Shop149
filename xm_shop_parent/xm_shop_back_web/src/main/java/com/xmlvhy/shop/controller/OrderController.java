package com.xmlvhy.shop.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmlvhy.shop.common.constant.OrderConstant;
import com.xmlvhy.shop.common.constant.PaginationConstant;
import com.xmlvhy.shop.common.exception.OrderCartNotFoundException;
import com.xmlvhy.shop.common.utils.ResponseResult;
import com.xmlvhy.shop.common.utils.StringUtil;
import com.xmlvhy.shop.params.OrderParam;
import com.xmlvhy.shop.pojo.*;
import com.xmlvhy.shop.service.CartService;
import com.xmlvhy.shop.service.OrderItemService;
import com.xmlvhy.shop.service.OrderService;
import com.xmlvhy.shop.service.ShippingService;
import com.xmlvhy.shop.vo.CartVo;
import com.xmlvhy.shop.vo.OrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Author: 小莫
 * Date: 2019-03-13 0:10
 * Description: 订单相关接口类
 */
@Slf4j
@Controller
@RequestMapping("/admin/order")
public class OrderController {

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
    @RequestMapping("/allOrders")
    public String allOrders(Integer pageNum,Model model){
//        if (ObjectUtils.isEmpty(pageNum)) {
//            pageNum = PaginationConstant.PAGE_NUM;
//        }
//        PageHelper.startPage(pageNum,15);
        //获取所有订单列表
        List<OrderVo> orderVoList = orderService.getAllOrders();
        PageInfo<OrderVo> pageInfo = new PageInfo<>(orderVoList);
        model.addAttribute("pageInfo",pageInfo);
        log.info("所有订单列表:"+ JSON.toJSONString(orderVoList));
        return "orderManager";
    }

    /**
     *功能描述: 客户所有订单展示列表
     * @Author 小莫
     * @Date 11:46 2019/03/26
     * @Param []
     * @return java.lang.String
     */
    @RequestMapping("/getOrdersByParams")
    public String getOrdersByParams(OrderParam orderParam, Integer pageNum, Model model){
//        if (ObjectUtils.isEmpty(pageNum)) {
//            pageNum = PaginationConstant.PAGE_NUM;
//        }
//        PageHelper.startPage(pageNum,15);
        //获取所有订单列表
        List<OrderVo> orderVoList = orderService.getOrdersByParams(orderParam);
        PageInfo<OrderVo> pageInfo = new PageInfo<>(orderVoList);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("params",orderParam);
        log.info("所有订单列表:"+ JSON.toJSONString(orderVoList));
        return "orderManager";
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
