package com.xmlvhy.shop.params;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
public class OrderParam implements Serializable {
    /*订单号*/
    private String orderId;
    /*姓名*/
    private String name;
    /*状态*/
    private Integer status;

}
