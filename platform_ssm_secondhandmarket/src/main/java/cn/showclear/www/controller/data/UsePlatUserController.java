package cn.showclear.www.controller.data;

import cn.com.scooper.common.resp.APIRespJson;
import cn.showclear.www.common.constant.CommonConstant;
import cn.showclear.www.common.constant.Message;
import cn.showclear.www.pojo.base.UserDo;
import cn.showclear.www.service.user.UsePlatUserService;
import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import cn.com.scooper.common.util.CookieUtils;

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

    @RequestMapping("/login")
    public APIRespJson login(UserDo userDo, HttpSession session, HttpServletResponse response) {
        Message message = null;
        try {
            message = usePlatUserService.login(userDo);
            //如果登录成功，则将用户保存到session
            if (message.getCode() == Message.LOGIN_SUCCESS.getCode()) {
                UserDo resultUser = usePlatUserService.getUserInfoByToken(userDo.getToken(), userDo.getUserName());
                session.setAttribute(CommonConstant.USERNAME_SESSION_KEY, resultUser.getUserName());
                // 将 token 值添加到 cookie 中
                addCookieToken(response, resultUser.getToken());
            }
        } catch (IllegalArgumentException e) {
            LOGGER.error("User login validate failed", e.getMessage());
            this.handleIllegalArgumentException(e);
        }
        if (message != null) {
            this.response(message.getCode(), message.getMessage());
        }
        return null;
    }

    @RequestMapping("/register")
    public  APIRespJson register(UserDo userDo, HttpSession session) {

        return null;
    }

    @RequestMapping("logout")
    public APIRespJson logout() {

        return null;
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
