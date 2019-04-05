package cn.showclear.www.controller;

import cn.showclear.www.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Junbo Wang
 * @description
 * @date 2019/4/5
 */
@Controller
public class UserController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 用户登录，登录成功跳转到首页
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/user/login")
    public String login(String username, String password) {
        log.info("username = " + username + ", password = " + password);
        return "index";
    }

    /**
     * 用户注册，注册成功跳转到首页
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/user/register")
    public String register(String username, String password) {
        log.info("username = " + username + ", password = " + password);
        return "index";
    }

}
