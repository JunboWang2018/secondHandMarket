package cn.showclear.www.controller.data;

import cn.com.scooper.common.resp.APIRespJson;
import cn.com.scooper.common.util.CookieUtils;
import cn.showclear.www.common.constant.CommonConstant;
import cn.showclear.www.common.constant.Message;
import cn.showclear.www.pojo.base.UserDo;
import cn.showclear.www.service.user.UsePlatUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Wang Junbo
 * @description
 * @date 2019/4/23
 */
@Controller
@RequestMapping("/data/plat/user")
public class UsePlatUserController extends BaseDataController {
    private final static Logger LOGGER = LoggerFactory.getLogger(UsePlatUserController.class);

    @Autowired
    private UsePlatUserService usePlatUserService;

    @Autowired
    private ServletContext servletContext;

    private String contextPath;

    @PostConstruct
    private void startup() {
        contextPath = servletContext.getContextPath();
    }

    @ResponseBody
    @RequestMapping("/login")
    public APIRespJson login(UserDo userDo, HttpSession session, HttpServletResponse response) {
        Message message = null;
        try {
            message = usePlatUserService.login(userDo);
            //如果登录成功，则将用户保存到session
            if (message.getCode() == Message.LOGIN_SUCCESS.getCode()) {
                session.setAttribute(CommonConstant.USERNAME_SESSION_KEY, userDo.getUserName());
                // 将 token 值添加到 cookie 中
                addCookieToken(response, userDo.getToken());
            }
        } catch (IllegalArgumentException e) {
            LOGGER.error("User login validate failed", e.getMessage());
            this.handleIllegalArgumentException(e);
        }
        if (message != null) {
            return this.response(message.getCode(), message.getMessage());
        }
        return null;
    }

    @ResponseBody
    @RequestMapping("/register")
    public APIRespJson register(UserDo userDo, HttpSession session, HttpServletResponse response) {
        Message message = null;
        try {
            message = usePlatUserService.register(userDo);
            //如果注册成功，使用注册的账号信息进行登录，登录成功则将用户保存到session
            if (message.getCode() == Message.REGISTER_SUCCESS.getCode()) {
                Message loginMsg = usePlatUserService.login(userDo);
                if (loginMsg.getCode() == Message.LOGIN_SUCCESS.getCode()) {
                    session.setAttribute(CommonConstant.USERNAME_SESSION_KEY, userDo.getUserName());
                    // 将 token 值添加到 cookie 中
                    addCookieToken(response, userDo.getToken());
                }
            }
        } catch (IllegalArgumentException e) {
            LOGGER.error("User login validate failed", e.getMessage());
            this.handleIllegalArgumentException(e);
        }
        if (message != null) {
            return this.response(message.getCode(), message.getMessage());
        }
        return null;
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        String token = (String) request.getAttribute(CommonConstant.TOKEN_REQUEST_KEY);
        usePlatUserService.logout(token);

        //移除cookie中的token
        this.removeCookieToken(response);

        //移除session中的信息,并做无效化处理
        session.removeAttribute(CommonConstant.USERNAME_SESSION_KEY);
        session.invalidate();
        return "/jsp/index.jsp";
    }

    // 在 cookie 中添加 token
    private void addCookieToken(HttpServletResponse response, String token) {
        CookieUtils.addCookie(response, contextPath, CommonConstant.TOKEN_COOKIE_KEY, token);
    }

    // 删除 cookie 中的 token
    private void removeCookieToken(HttpServletResponse response) {
        CookieUtils.removeCookie(response, contextPath, CommonConstant.TOKEN_COOKIE_KEY);
    }
}
