package cn.showclear.www.controller.data;

import cn.showclear.www.pojo.base.DemandInfoDo;
import cn.showclear.www.pojo.base.ProductDo;
import cn.showclear.www.service.demandInfo.DemandInfoService;
import cn.showclear.www.service.product.ProductService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

    @RequestMapping("/search")
    public void indexData(ProductDo productDo, DemandInfoDo demandInfoDo, HttpServletResponse response) {
        log.info(productDo.toString());
        log.info(demandInfoDo.toString());
        PrintWriter writer = null;
        List<ProductDo> productList = null;
        List<DemandInfoDo> demandInfoList = null;
        try {
            writer = response.getWriter();
            log.info("加载数据");
            //加载物品信息
            productList = productService.searchProductList(productDo);
            //加载求购信息
            demandInfoList = demandInfoService.searchDemandInfoList(demandInfoDo);
        } catch (IOException e) {
            log.error("获取response.write失败", e);
        } catch (IllegalArgumentException e) {
            writer.write(JSONObject.toJSONString(this.handleIllegalArgumentException(e)));
        }
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("productList", productList);
        resultMap.put("demandInfoList", demandInfoList);
        writer.write(JSONObject.toJSONString(this.responseData(resultMap)));
    }


}
