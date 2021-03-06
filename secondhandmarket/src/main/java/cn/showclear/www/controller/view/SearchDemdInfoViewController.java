package cn.showclear.www.controller.view;

import cn.showclear.www.pojo.base.SearchDemdInfoListQo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Wang Junbo
 * @description
 * @date 2019/4/12
 */
@Controller
@RequestMapping("/view/search")
public class SearchDemdInfoViewController {
    private static Logger log = LoggerFactory.getLogger(SearchDemdInfoViewController.class);

    @RequestMapping("/searchDemandInfo")
    public String toDemandInfo(Model model, String demdInfoNumber) {
        if (!StringUtils.isEmpty(demdInfoNumber)) {
            model.addAttribute("demdInfoNumber", demdInfoNumber);
            return "/jsp/requirement_info.jsp";
        } else {
            return "/jsp/index.jsp";
        }

    }

    @RequestMapping("/searchDemandInfoList")
    public String toDemandInfoList(Model model, String searchKey, String type) {
        log.info("searchKey = " + searchKey + ", type = " + type);
        if (!StringUtils.isEmpty(searchKey)) {
            model.addAttribute("searchKey", searchKey);
            return "/jsp/requirement_list.jsp";
        } else if (!StringUtils.isEmpty(type)) {
            model.addAttribute("typeCode", type);
            return "/jsp/requirement_list.jsp";
        } else {
            return "/jsp/index.jsp";
        }

    }
}
