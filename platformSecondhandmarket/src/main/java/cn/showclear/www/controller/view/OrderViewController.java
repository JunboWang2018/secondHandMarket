package cn.showclear.www.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Wang Junbo
 * @description
 * @date 2019/4/17
 */
@Controller
@RequestMapping("/view/order")
public class OrderViewController {

    @RequestMapping("/toMyOrder")
    public String toMyOrder() {
        return "/jsp/my_order.jsp";
    }
}
