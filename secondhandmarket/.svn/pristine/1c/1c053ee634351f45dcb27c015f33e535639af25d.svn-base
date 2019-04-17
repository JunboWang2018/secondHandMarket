package cn.showclear.www.controller.data;

import cn.com.scooper.common.resp.APIRespJson;
import cn.showclear.www.common.constant.CommonConstant;
import cn.showclear.www.common.constant.Message;
import cn.showclear.www.pojo.base.UserDo;
import cn.showclear.www.service.user.UserService;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Junbo Wang
 * @description 登陆注册模块
 * @date 2019/4/5
 */
@Controller
@RequestMapping("/data/user")
public class UserDataController extends BaseDataController{
    private static final Logger log = LoggerFactory.getLogger(UserDataController.class);

    @Autowired
    private UserService userService;

    /**
     * 用户登录：
     *  1. 登录成功将用户名存入session
     *  2. 返回登录结果信息
     * @param userDo
     * @param session
     * @param response
     * @return
     */
    @RequestMapping("/login")
    public void login(UserDo userDo, HttpSession session, HttpServletResponse response) {
        log.info("username = " + userDo.getUserName() + ", password = " + userDo.getPassword());
        PrintWriter writer = null;
        Message message = null;
        //设置返回数据格式为json
        response.setContentType("application/json");
        try {
            writer = response.getWriter();
            message = userService.userLogin(userDo);
        } catch (IllegalArgumentException e) {
            writer.write(JSONObject.toJSONString(this.handleIllegalArgumentException(e)));
        } catch (IOException e) {
            log.error("获取response.write异常",e);
        }
        //若登录成功，将用户名放入session
        if (message.getCode() == 102) {
            session.setAttribute("user", userDo.getUserName());
        }
        writer.write(JSONObject.toJSONString(this.response(message.getCode(), message.getMessage())));
    }

    /**
     * 用户注册:
     *  1. 注册成功将用户名存入session
     *  2. 返回注册结果信息
     * @param userDo
     * @return
     */
    @RequestMapping("/register")
    public void register(UserDo userDo, HttpSession session, HttpServletResponse response) {
        PrintWriter writer = null;
        Message message = null;
        //设置返回数据格式为json
        response.setContentType("application/json");
        try {
            writer = response.getWriter();
            message = userService.userRegister(userDo);
        } catch (IllegalArgumentException e) {
            writer.write(JSONObject.toJSONString(this.handleIllegalArgumentException(e)));
        } catch (IOException e) {
            log.error("获取response.write异常", e);
        }
        if (message.getCode() == 103) {
            log.info("register success, put user to session");
            session.setAttribute("user", userDo.getUserName());
        }
        writer.write(JSONObject.toJSONString(this.response(message.getCode(), message.getMessage())));
    }

    /**
     * 用户退出:
     *  1. sesssion中清除用户信息
     * @return
     */
    @RequestMapping("/logout")
    public String register(HttpSession session, HttpServletResponse response) {
        PrintWriter writer = null;
        Message message = null;
        //设置返回数据格式为json
        response.setContentType("application/json");
        try {
            writer = response.getWriter();
        } catch (IllegalArgumentException e) {
            writer.write(JSONObject.toJSONString(this.handleIllegalArgumentException(e)));
        } catch (IOException e) {
            log.error("获取response.write异常", e);
        }
        session.removeAttribute("user");
        return "/jsp/index.jsp";
    }
}
