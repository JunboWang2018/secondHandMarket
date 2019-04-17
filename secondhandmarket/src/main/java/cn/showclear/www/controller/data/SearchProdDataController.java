package cn.showclear.www.controller.data;

import cn.com.scooper.common.exception.BusinessException;
import cn.com.scooper.common.resp.APIRespJson;
import cn.showclear.www.pojo.base.ProductDo;
import cn.showclear.www.pojo.base.SearchProdListQo;
import cn.showclear.www.pojo.base.SearchProductQo;
import cn.showclear.www.service.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Wang Junbo
 * @description 物品查询类
 * @date 2019/4/11
 */
@Controller
@RequestMapping("/data/search")
public class SearchProdDataController extends BaseDataController {
    private static final Logger log = LoggerFactory.getLogger(SearchProdDataController.class);

    @Autowired
    private ProductService productService;

    /**
     * 根据物品编号查询物品信息
     * @param productNumber
     */
    @ResponseBody
    @RequestMapping("/searchProductInfo")
    public APIRespJson searchProduct(String productNumber) {
        log.info("productNumber = " + productNumber);
        SearchProductQo productQo = null;
        try {
            ProductDo productDo = new ProductDo();
            productDo.setProductNumber(productNumber);
            productQo = productService.searchProductQo(productDo);
            log.info("searchNumber " + productNumber + " result is " + productQo.toString());
        } catch (IllegalArgumentException e) {
            return this.handleIllegalArgumentException(e);
        } catch (BusinessException e) {
            return this.response(e.getCode(), e.getMessage());
        }
        return this.responseData(productQo);
    }

    /**
     * 根据条件查询物品列表
     * @param productDo
     */
    @ResponseBody
    @RequestMapping("/searchProdList")
    public APIRespJson searchProductList(ProductDo productDo) {
        log.info(productDo.toString());
        List<ProductDo> productList = null;
        try {
            productList = productService.searchProductList(productDo);
        } catch (IllegalArgumentException e) {
            return this.handleIllegalArgumentException(e);
        }
        return this.responseList(productList);
    }

    /**
     * 根据用户特定条件查询物品列表
     * @param searchProdListQo
     */
    @ResponseBody
    @RequestMapping("/searchProdListByQo")
    public APIRespJson searchProdListByQo(SearchProdListQo searchProdListQo) {
        List<ProductDo> productList = null;
        try {
            productList = productService.searchProdListQo(searchProdListQo);
        } catch (IllegalArgumentException e) {
            return this.handleIllegalArgumentException(e);
        }
        return this.responseList(productList);
    }
}
