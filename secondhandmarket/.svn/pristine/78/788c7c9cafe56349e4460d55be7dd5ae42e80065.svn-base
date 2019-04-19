package cn.showclear.www.controller.data;

import cn.com.scooper.common.resp.APIRespJson;
import cn.showclear.www.pojo.base.DemandInfoDo;
import cn.showclear.www.pojo.base.ProductDo;
import cn.showclear.www.service.demandInfo.DemandInfoService;
import cn.showclear.www.service.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wang Junbo
 * @description 首页加载
 * @date 2019/4/12
 */
@Controller
@RequestMapping("/data/index")
public class IndexDataController extends BaseDataController {
    private static final Logger log = LoggerFactory.getLogger(IndexDataController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private DemandInfoService demandInfoService;

    @ResponseBody
    @RequestMapping("/search")
    public APIRespJson indexData(ProductDo productDo, DemandInfoDo demandInfoDo) {
        List<ProductDo> productList = null;
        List<DemandInfoDo> demandInfoList = null;
        try {
            log.info("加载数据");
            //加载物品信息
            productList = productService.searchProductList(productDo);
            //加载求购信息
            demandInfoList = demandInfoService.searchDemandInfoList(demandInfoDo);
        } catch (IllegalArgumentException e) {
            return this.handleIllegalArgumentException(e);
        }
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("productList", productList);
        resultMap.put("demandInfoList", demandInfoList);
        return this.responseData(resultMap);
    }


}
