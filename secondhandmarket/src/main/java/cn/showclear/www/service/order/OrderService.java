package cn.showclear.www.service.order;

import cn.showclear.www.common.constant.Message;
import cn.showclear.www.pojo.base.OrderDo;
import cn.showclear.www.pojo.base.RecordQo;
import cn.showclear.www.pojo.base.SearchOrderQo;

import java.util.List;
import java.util.Map;

public interface OrderService {



    /**
     * 根据指定属性条件查询订单
     * @param orderDo
     * @return
     */
    List<OrderDo> searchOrderListByCol(OrderDo orderDo);

    /**
     * 插入一条订单
     * @param productNumber
     * @param username
     * @return
     * @throws IllegalArgumentException
     */
    Message generateOrder(String productNumber, String username) throws IllegalArgumentException;


    /**
     * 根据指定属性条件查询订单,并查询需要的额外属性
     * @param orderDo
     * @return
     */
    SearchOrderQo searchOrderQo(OrderDo orderDo);

    /**
     * 根据指定属性条件查询订单list,并查询需要的额外属性
     * @param orderDo
     * @return
     */
    List<SearchOrderQo> searchOrderQoList(OrderDo orderDo);

    /**
     * 查找购买记录和出售记录
     * @param username
     * @return
     */
    Map<String, Object> searchBuyAndSaleOrder(String username);

    /**
     * 查找购买记录中本人的出价记录,返回记录列表和交易类型
     * @param productId
     * @param username
     * @return
     */
    Map<String, Object> searchBuyPriceRecord(Integer productId, String username);

    /**
     * 查找出售物品中的买家出价记录,返回记录列表和交易类型
     * @param productId
     * @return
     */
    Map<String, Object> searchSalePriceRecord(Integer productId);
}
