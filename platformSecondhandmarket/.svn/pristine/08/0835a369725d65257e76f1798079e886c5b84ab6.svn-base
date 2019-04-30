package cn.showclear.www.controller.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author Wang Junbo
 * @description
 * @date 2019/4/10
 */
@Controller
@RequestMapping("/view/release")
public class ReleaseViewController {
    private static final Logger log = LoggerFactory.getLogger(ReleaseViewController.class);

    @RequestMapping("/toReleaseProduct")
    public String releaseProduct(HttpSession session) {
        String username = (String) session.getAttribute("user");
        if (username == null) {
            return "/jsp/login.jsp";
        }
        return "/jsp/release_product.jsp";
    }

    @RequestMapping("/toReleaseDemandInfo")
    public String releaseDemandInfo(HttpSession session) {
        String username = (String) session.getAttribute("user");
        if (username == null) {
            return "/jsp/login.jsp";
        }
        return "/jsp/release_requirement.jsp";
    }
}
