package cn.showclear.www.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Wang Junbo
 * @description
 * @date 2019/4/10
 */
public class UserLoginInterceptor extends HandlerInterceptorAdapter {
    protected static final Logger log = LoggerFactory.getLogger(UserLoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String username = (String) request.getSession().getAttribute("user");

        if (username == null || StringUtils.isEmpty(username)) {
            log.info("User not login");
            return false;
        }
        return true;
    }
}
