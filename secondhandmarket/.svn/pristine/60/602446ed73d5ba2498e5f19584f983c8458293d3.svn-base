package cn.showclear.www.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Wang Junbo
 * @description
 * @date 2019/4/11
 */
@Controller
public class IndexViewController {
    /**
     * 跳转首页
     * @return
     */
    @RequestMapping("/")
    public String index(String typeCode, Model model) {
        model.addAttribute("typeCode", typeCode);
        return "/jsp/index.jsp";

    }
}
