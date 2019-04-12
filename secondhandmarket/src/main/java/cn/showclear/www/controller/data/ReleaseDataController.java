package cn.showclear.www.controller.data;

import cn.showclear.www.common.constant.CommonConstant;
import cn.showclear.www.common.constant.Message;
import cn.showclear.www.pojo.base.DemandInfoDo;
import cn.showclear.www.pojo.base.ProductDo;
import cn.showclear.www.service.release.ReleaseService;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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


    @RequestMapping("/product")
    public void releaseProduct(ProductDo productDo, @RequestParam("imageFile") MultipartFile imageFile, HttpSession session, HttpServletResponse response) {
        log.info(productDo.toString());
        //从session获取用户名
        String username = (String) session.getAttribute("user");
        //设置返回数据格式为json
        response.setContentType("application/json");
        try {
            /*if (StringUtils.isEmpty(username)) {
                log.info("username is null");
                response.getWriter().write(JSONObject.toJSONString(this.response(-1, "请先登录")));
            }*/
            String path = session.getServletContext().getRealPath("/");
            log.info(productDo.toString());
            Message result = releaseService.releaseProduct(productDo, username, imageFile, path);
            response.getWriter().write(JSONObject.toJSONString(this.response(result.getCode(), result.getMessage())));
        } catch (Exception e) {
            log.info("发布物品失败", e);
        }
    }

    @RequestMapping("/demandInfo")
    public void releaseDemandInfo(DemandInfoDo demandInfoDo, HttpSession session, HttpServletResponse response) {
        log.info(demandInfoDo.toString());
        //从session获取用户名
        String username = (String) session.getAttribute("user");
        //设置返回数据格式为json
        response.setContentType("application/json");
        try {
            /*if (StringUtils.isEmpty(username)) {
                log.info("username is null");
                response.getWriter().write(JSONObject.toJSONString(this.response(-1, "请先登录")));
            }*/
            Message result = releaseService.releaseDemandInfo(demandInfoDo, username);
            response.getWriter().write(JSONObject.toJSONString(this.response(result.getCode(), result.getMessage())));
        } catch (Exception e) {
            log.info("发布求购信息失败", e);
        }
    }
}
