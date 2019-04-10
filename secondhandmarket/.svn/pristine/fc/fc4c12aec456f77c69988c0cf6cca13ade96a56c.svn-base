package cn.showclear.www.interceptor;

import cn.com.scooper.common.resp.APIRespJson;
import cn.showclear.www.controller.data.UserDataController;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

/**
 * @author Wang Junbo
 * @description
 * @date 2019/4/10
 */
public class UserInterceptor extends HandlerInterceptorAdapter {
    protected static final Logger LOGGER = LoggerFactory.getLogger(UserInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String username = (String) request.getSession().getAttribute("user");

        if (username == null || username.isEmpty()) {
            // 跳转到登陆页，并携带 redirectFrom 参数（以便跳回该页）
            String path = request.getContextPath()
                    + "/toLogin?redirectFrom="
                    + URLEncoder.encode(request.getRequestURI(), "UTF-8");
            response.sendRedirect(path);
            return false;
        }

        return true;
    }
}
