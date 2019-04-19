package cn.showclear.www.controller.data;

import cn.com.scooper.common.exception.BusinessException;
import cn.com.scooper.common.resp.APIRespJson;
import cn.showclear.www.common.constant.Message;
import cn.showclear.www.service.order.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author Wang Junbo
 * @description
 * @date 2019/4/16
 */
@Controller
@RequestMapping("/data/order")
public class OrderDataController extends BaseDataController {
    private static final Logger log = LoggerFactory.getLogger(OrderDataController.class);

    @Autowired
    private OrderService orderService;

    /**
     * 生成订单
     * @param productNumber
     * @param price
     * @param session
     */
    @ResponseBody
    @RequestMapping("/generateOrder")
    public APIRespJson generateOrder(String productNumber, Double price, String username,  HttpSession session) {
        Message message = null;
        String user = null;
        try {
            if (username == null) {
                user = (String) session.getAttribute("user");
            } else {
                user = username;
            }
            message = orderService.generateOrder(productNumber, price, user);
        } catch (IllegalArgumentException e) {
            return this.handleIllegalArgumentException(e);
        } catch (BusinessException e) {
            log.error("the same sale user and buy user");
            return this.response(e.getCode(), e.getMessage());
        }
        return this.response(message.getCode(), message.getMessage());
    }

    /**
     * 查询某用户的所有订单
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/myOrderList")
    public APIRespJson searchMyOrderList(HttpSession session) {
        Map<String, Object> resultMap = null;
        String username = (String) session.getAttribute("user");
        try {
            resultMap = orderService.searchBuyAndSaleOrder(username);
        } catch (IllegalArgumentException e) {
            this.handleIllegalArgumentException(e);
        } catch (BusinessException e) {
            return this.response(e.getCode(), e.getMessage());
        }
        return this.responseData(resultMap);
    }

    /**
     * 查询购买记录中，竞价物品和议价物品登录用户自身的出价记录
     * @param productId
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/searchBuyPriceRecord")
    public APIRespJson searchBuyPriceRecord(Integer productId, HttpSession session) {
        Map<String, Object> resultMap = null;
        String username = (String) session.getAttribute("user");
        try {
            resultMap = orderService.searchBuyPriceRecord(productId, username);
        } catch (BusinessException e) {
            return this.response(e.getCode(), e.getMessage());
        }
        return this.responseData(resultMap);
    }

    /**
     * 查询出售记录中，竞价物品和议价物品购买用户的出价记录
     * @param productId
     * @return
     */
    @ResponseBody
    @RequestMapping("/searchSalePriceRecord")
    public APIRespJson searchSalePriceRecord(Integer productId) {
        Map<String, Object> resultMap = null;
        try {
            resultMap = orderService.searchSalePriceRecord(productId);
        } catch (BusinessException e) {
            return this.response(e.getCode(), e.getMessage());
        }
        return this.responseData(resultMap);
    }

}
