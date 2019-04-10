package cn.showclear.www.controller.data;

import cn.com.scooper.common.resp.APIRespJson;
import cn.showclear.www.controller.data.SearchDataController;
import cn.showclear.www.pojo.base.DemandInfoDo;
import cn.showclear.www.pojo.base.ProductDo;
import cn.showclear.www.service.search.SearchService;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Wang Junbo
 * @description
 * @date 2019/4/9
 */
@Controller
@Scope("prototype")
public class SearchDataController extends BaseDataController{
    private static final Logger log = LoggerFactory.getLogger(SearchDataController.class);

    @Autowired
    private SearchService searchService;

    /**
     * 通过id查询物品
     * @param searchNumber
     * @param response
     * @return
     */
    @RequestMapping("/search_product_by_number.action")
    public String searchProductByNumber(String searchNumber, HttpServletResponse response) {
        log.info("searchNumber = " + searchNumber);
        try {
            ProductDo productDo = searchService.searchProductByNumber(searchNumber);
            log.info("productDo = " + productDo);
            response.getWriter().write(JSONObject.toJSONString(new APIRespJson().setData(productDo)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "product_info.html";
    }

    /**
     * 通过关键字查询物品
     * @param searchKey
     * @param response
     * @return
     */
    @RequestMapping("/search_product_by_key.action")
    public String searchProductByKey(String searchKey, HttpServletResponse response) {
        log.info("searchKey = " + searchKey);
        try {
            if (StringUtils.isEmpty(searchKey)) {
                response.getWriter().write(JSONObject.toJSONString(this.response(-1, "查询关键字不能为空！")));
                return "index.html";
            }
            List<ProductDo> productDoList = searchService.searchProductByKey(searchKey);
            log.info("productList = " + productDoList);
            response.getWriter().write(JSONObject.toJSONString(this.responseList(productDoList)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "product_list.html";
    }

    /**
     * 通过物品分类查询物品
     * @param searchType
     * @param response
     * @return
     */
    @RequestMapping("/search_product_by_type.action")
    public String searchProductByType(String searchType, HttpServletResponse response) {
        log.info("searchType = " + searchType);
        try {
            List<ProductDo> productDoList = searchService.searchProductByType(searchType);
            log.info("productList = " + productDoList);
            response.getWriter().write(JSONObject.toJSONString(this.responseList(productDoList)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "product_list.html";
    }

    /**
     * 通过自定义条件查询物品
     * @return
     */
    @RequestMapping("/search_product_by_condition.action")
    public String searchProductByCondition() {
        return null;
    }

    /**
     * 通过id查询求购信息
     * @param searchNumber
     * @param response
     * @return
     */
    @RequestMapping("/search_demand_info_by_number.action")
    public String searchDemandInfoByNumber(String searchNumber, HttpServletResponse response) {
        log.info("searchNumber = " + searchNumber);
        try {
            DemandInfoDo demandInfoDo = searchService.searchDemandInfoByNumber(searchNumber);
            log.info("demandInfoDo = " + demandInfoDo);
            response.getWriter().write(JSONObject.toJSONString(this.responseData(demandInfoDo)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "requirement_info.html";
    }

    /**
     * 通过关键字查询求购信息
     * @param searchKey
     * @param response
     * @return
     */
    @RequestMapping("/search_demand_info_by_key.action")
    public String searchDemandInfoByKey(String searchKey, HttpServletResponse response) {
        log.info("searchKey = " + searchKey);
        try {
            if (StringUtils.isEmpty(searchKey)) {
                response.getWriter().write(JSONObject.toJSONString(this.response(-1, "查询关键字不能为空！")));
                return "index.html";
            }
            List<DemandInfoDo> demandInfoDoList = searchService.searchDemandInfoByKey(searchKey);
            log.info("demandInfoDoList = " + demandInfoDoList);
            response.getWriter().write(JSONObject.toJSONString(this.responseList(demandInfoDoList)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "requirement_list.html";
    }

    /**
     * 通过物品分类查询求购信息
     * @param searchType
     * @param response
     * @return
     */
    @RequestMapping("/search_demand_info_by_type.action")
    public String searchDemandInfoByType(String searchType, HttpServletResponse response) {
        log.info("searchType = " + searchType);
        try {
            List<DemandInfoDo> demandInfoDoList = searchService.searchDemandInfoByType(searchType);
            log.info("demandInfoDoList = " + demandInfoDoList);
            response.getWriter().write(JSONObject.toJSONString(this.responseList(demandInfoDoList)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "requirement_list.html";
    }

    /**
     * 通过自定义条件查询求购信息
     * @return
     */
    @RequestMapping("/search_demand_info_by_condition.action")
    public String searchDemandInfoByCondition() {
        return null;
    }
}
