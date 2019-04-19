package cn.showclear.www.controller.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Wang Junbo
 * @description
 * @date 2019/4/10
 */
@Controller
@RequestMapping("/view/user")
public class UserViewController {
    private static final Logger log = LoggerFactory.getLogger(UserViewController.class);

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping("/toLogin")
    public String login() {
        return "/jsp/login.jsp";
    }

    /**
     * 跳转到注册页面
     * @return
     */
    @RequestMapping("/toRegister")
    public String register() {
        return "/jsp/register.jsp";
    }


}
