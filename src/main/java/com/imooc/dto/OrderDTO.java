package com.imooc.dto;

import com.imooc.dataobject.OrderDetail;
import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单传输对象
 */
@Data
public class OrderDTO {
    /*订单id*/
    @Id
    private String orderId;

    /*买家姓名*/
    private String buyerName;

    /*买家电话*/
    private String buyerPhone;

    /*买家微信id*/
    private String buyerOpenid;
    /*买家地址*/
    private String buyerAddress;

    /*订单总金额*/
    private BigDecimal orderAmount;

    /*订单状态，默认是新订单*/
    private Integer orderStatus=OrderStatusEnum.NEW.getCode();

    /*支付状态,默认是0未支付*/
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /*创建时间*/
    private Date createTime;

    /*更新时间*/
    private Date updateTime;

    private List<OrderDetail> orderDetails;
}
