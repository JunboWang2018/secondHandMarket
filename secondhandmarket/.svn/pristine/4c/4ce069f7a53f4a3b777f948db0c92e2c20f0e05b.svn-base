package cn.showclear.www.dao.base.order;

import cn.showclear.www.pojo.base.OrderDo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {
    /**
     * 根据指定属性条件查询订单
     * @param orderDo
     * @return
     */
    List<OrderDo> searchOrderListByCol(OrderDo orderDo);

    /**
     * 插入一条订单
     * @param orderDo
     * @return
     */
    Integer generateOrder(OrderDo orderDo);
}
