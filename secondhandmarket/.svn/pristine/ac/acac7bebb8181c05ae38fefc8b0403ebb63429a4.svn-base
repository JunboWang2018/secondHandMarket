package cn.showclear.www.controller.data;

import cn.com.scooper.common.exception.BusinessException;
import cn.com.scooper.common.resp.APIRespJson;
import cn.showclear.www.pojo.base.DemandInfoDo;
import cn.showclear.www.pojo.base.SearchDemdInfoQo;
import cn.showclear.www.pojo.base.SearchProdListQo;
import cn.showclear.www.service.demandInfo.DemandInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Wang Junbo
 * @description 求购信息查询类
 * @date 2019/4/11
 */
@Controller
@RequestMapping("/data/search")
public class DmdInfoDataController extends BaseDataController {
    private static final Logger log = LoggerFactory.getLogger(DmdInfoDataController.class);

    @Autowired
    private DemandInfoService demandInfoService;

    /**
     * 根据编号查询求购信息的详情
     * @param demandInfoNumber
     */
    @ResponseBody
    @RequestMapping("/searchDemandInfo")
    public APIRespJson searchDemandInfo(String demandInfoNumber) {
        SearchDemdInfoQo searchDemdInfoQo = null;
        try {
            searchDemdInfoQo = demandInfoService.searchDemdInfoQo(demandInfoNumber);
        } catch (BusinessException e) {
            return this.response(e.getCode(), e.getMessage());
        }
        return this.responseData(searchDemdInfoQo);
    }

    /**
     * 查询求购信息列表（指定求购信息属性）
     * @param demandInfoDo
     */
    @ResponseBody
    @RequestMapping("/searchDemandInfoList")
    public APIRespJson searchDemandInfoList(DemandInfoDo demandInfoDo) {
        log.info(demandInfoDo.toString());
        List<DemandInfoDo> demandInfoList = null;
        try {
            demandInfoList = demandInfoService.searchDemandInfoList(demandInfoDo);
        } catch (IllegalArgumentException e) {
            return this.handleIllegalArgumentException(e);
        }
        return this.responseList(demandInfoList);
    }

    @ResponseBody
    @RequestMapping("/searchDemdInfoListByQo")
    public APIRespJson searchDemdInofListByQo(SearchProdListQo searchProdListQo) {
        List<DemandInfoDo> demandInfoList = null;
        demandInfoList = demandInfoService.searchDemdInfoListByQo(searchProdListQo);
        return this.responseList(demandInfoList);
    }
}
