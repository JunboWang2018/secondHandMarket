package cn.showclear.www.controller.data;

import cn.showclear.www.pojo.base.DemandInfoDo;
import cn.showclear.www.service.demandInfo.DemandInfoService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author Wang Junbo
 * @description 求购信息查询类
 * @date 2019/4/11
 */
@Controller
@RequestMapping("/data/search")
public class SearchDmdInfoDataController extends BaseDataController {
    private static final Logger log = LoggerFactory.getLogger(SearchDmdInfoDataController.class);

    @Autowired
    private DemandInfoService demandInfoService;


    @RequestMapping("/searchDemandInfo")
    public void searchDemandInfo(String demandInfoNumber, HttpServletResponse response) {
        log.info("demandInfoNumber = " + demandInfoNumber);
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            demandInfoService.searchDemandInfo(demandInfoNumber);
        } catch (IOException e) {
            log.error("获取response.writer失败", e);
        } catch (IllegalArgumentException e) {
            writer.write(JSONObject.toJSONString(this.handleIllegalArgumentException(e)));
        }
    }

    @RequestMapping("/searchDemandInfoList")
    public void searchDemandInfoList(DemandInfoDo demandInfoDo, HttpServletResponse response) {
        log.info(demandInfoDo.toString());
        PrintWriter writer = null;
        List<DemandInfoDo> demandInfoList = null;
        try {
            writer = response.getWriter();
            demandInfoList = demandInfoService.searchDemandInfoList(demandInfoDo);
        } catch (IOException e) {
            log.error("获取response.writer失败", e);
        } catch (IllegalArgumentException e) {
            writer.write(JSONObject.toJSONString(this.handleIllegalArgumentException(e)));
        }
        writer.write(JSONObject.toJSONString(this.responseList(demandInfoList)));
    }
}
