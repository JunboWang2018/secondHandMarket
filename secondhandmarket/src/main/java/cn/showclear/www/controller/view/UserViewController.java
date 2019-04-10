package cn.showclear.www.controller.view;

import cn.showclear.www.controller.data.BaseDataController;
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
public class UserViewController extends BaseDataController {
    private static final Logger log = LoggerFactory.getLogger(UserViewController.class);

    /**
     * 跳转首页
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "/html/index.html";
    }

    /**
     * 跳转首页
     * @return
     */
    @RequestMapping("/index")
    public String index1() {
        log.info("index1");
        return "/html/index.html";
    }

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping("/toLogin")
    public String login() {
        log.info("login view");
        return "html/login.html";
    }

    /**
     * 跳转到注册页面
     * @return
     */
    @RequestMapping("/toRegister")
    public String register() {
        log.info("to register");
        return "html/register.html";
    }


}
