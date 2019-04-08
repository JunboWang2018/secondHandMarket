package cn.showclear.www.controller;

import cn.showclear.www.common.constant.CommonConstant;
import cn.showclear.www.pojo.base.UserDo;
import cn.showclear.www.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Junbo Wang
 * @description 登陆注册模块
 * @date 2019/4/5
 */
@Controller
@Scope("prototype")
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
    @RequestMapping(value = "/login.action", method = RequestMethod.POST)
    public String login(String username, String password, HttpSession session, HttpServletRequest request) {
        log.info("Enter UserController.login");
        log.info("username = " + username + ", password = " + password);
        if (username == null || username.isEmpty()) {
             request.setAttribute("msg", "用户名为空！");
             return "login.html";
        }
        if (password == null || password.isEmpty()) {
            request.setAttribute("msg", "密码为空！");
            return "login.html";
        }
        UserDo userDo = userService.userLogin(username);
        if (userDo == null) {
            log.info("username is not exist");
            request.setAttribute("msq", "用户名不存在");
            log.info("exit UserController.login");
            return "login.html";

        }
        if (userDo.getPassword().equals(password)) {
            log.info("login success, put user to session");
            session.setAttribute("user", username);
            log.info("exit UserController.login");
            return "index.html";
        } else {
            log.info("login failed, password is not right");
            request.setAttribute("msg", "密码错误");
            return "login.html";
        }
    }

    /**
     * 用户注册，注册成功跳转到首页
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/register.action")
    public String register(String username, String password, HttpSession session, HttpServletRequest request) {
        log.info("enter UserController.register");
        log.info("username = " + username + ", password = " + password);
        if (username == null || username.isEmpty()) {
            request.setAttribute("msg", "用户名为空！");
            return "register.html";
        }
        if (password == null || password.isEmpty()) {
            request.setAttribute("msg", "密码为空！");
            return "register.html";
        }
        //查询用户是否存在
        UserDo userDo = userService.userLogin(username);
        if (userDo != null) {
            log.info("username is exist");
            request.setAttribute("msg", "用户名已存在");
            return "register.html";
        }
        String result = userService.userRegister(username,password);
        if (result.equals(CommonConstant.SUCCESS)) {
            request.setAttribute("msg", "注册成功");
        }
        log.info("exit UserController.register");
        return "index.html";
    }
}
