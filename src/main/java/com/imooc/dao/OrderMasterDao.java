package com.imooc.dao;


import com.imooc.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 订单持久层
 */
public interface OrderMasterDao extends JpaRepository<OrderMaster,String> {
   /*通过微信名查出某人的订单信息*/
    Page<OrderMaster> findByBuyerOpenid(String openid,Pageable pageable);
}
