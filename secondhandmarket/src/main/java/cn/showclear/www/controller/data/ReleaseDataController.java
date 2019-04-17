package cn.showclear.www.controller.data;

import cn.com.scooper.common.resp.APIRespJson;
import cn.showclear.www.common.constant.Message;
import cn.showclear.www.pojo.base.DemandInfoDo;
import cn.showclear.www.pojo.base.ProductDo;
import cn.showclear.www.service.release.ReleaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Wang Junbo
 * @date 2019/4/8
 * 发布模块，包含二手物品发布和求购信息发布
 */
@Controller
@RequestMapping("/data/release")
public class ReleaseDataController extends BaseDataController {
    private static final Logger log = LoggerFactory.getLogger(ReleaseDataController.class);

    @Autowired
    private ReleaseService releaseService;

    @ResponseBody
    @RequestMapping("/product")
    public APIRespJson releaseProduct(ProductDo productDo, @RequestParam("imageFile") MultipartFile imageFile, HttpSession session, HttpServletResponse response) {
        log.info(productDo.toString());
        //从session获取用户名
        String username = (String) session.getAttribute("user");
        String path = session.getServletContext().getRealPath("/");
        log.info(productDo.toString());
        Message result = null;
        result = releaseService.releaseProduct(productDo, username, imageFile, path);
        return this.response(result.getCode(), result.getMessage());
    }

    @ResponseBody
    @RequestMapping("/demandInfo")
    public APIRespJson releaseDemandInfo(DemandInfoDo demandInfoDo, HttpSession session) {
        log.info(demandInfoDo.toString());
        //从session获取用户名
        String username = (String) session.getAttribute("user");
        Message result = releaseService.releaseDemandInfo(demandInfoDo, username);
        return this.response(result.getCode(), result.getMessage());
    }
}
