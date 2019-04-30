package cn.showclear.www.controller.data;

import cn.com.scooper.common.exception.BusinessException;
import cn.com.scooper.common.resp.APIRespJson;
import cn.showclear.www.common.constant.Message;
import cn.showclear.www.pojo.base.ProductDo;
import cn.showclear.www.pojo.base.SearchProdListQo;
import cn.showclear.www.pojo.base.SearchProductQo;
import cn.showclear.www.pojo.base.UserDo;
import cn.showclear.www.service.product.ProductService;
import cn.showclear.www.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Wang Junbo
 * @description 物品查询类
 * @date 2019/4/11
 */
@Controller
@RequestMapping("/data/search")
public class ProdDataController extends BaseDataController {
    private static final Logger log = LoggerFactory.getLogger(ProdDataController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    /**
     * 根据物品编号查询正在出售中的物品信息
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
            productDo = productService.searchProductInit(productDo);
            productQo = productService.searchProductQo(productDo);
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
            productDo = productService.searchProductInit(productDo);
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
            searchProdListQo = productService.searchProductQoInit(searchProdListQo);
            productList = productService.searchProdListQo(searchProdListQo);
        } catch (IllegalArgumentException e) {
            return this.handleIllegalArgumentException(e);
        }
        return this.responseList(productList);
    }

    @ResponseBody
    @RequestMapping("/searchMyProduct")
    public APIRespJson searchMyProduct(HttpSession session) {
        List<SearchProductQo> myProdList = null;
        String username = (String) session.getAttribute("user");
        //查找用户ID
        UserDo userQuery = new UserDo();
        userQuery.setUserName(username);
        try {
            UserDo userResult = userService.searchUser(userQuery);
            ProductDo prodQuery = new ProductDo();
            prodQuery.setUserId(userResult.getUserId());
            myProdList = productService.searchProdQoList(prodQuery);
        } catch (IllegalArgumentException e) {
            log.error("参数错误", e);
            this.handleIllegalArgumentException(e);
        } catch (BusinessException e) {
            return this.response(e.getCode(), e.getMessage());
        }
        return this.responseList(myProdList);
    }

    @ResponseBody
    @RequestMapping("/takeUpOrDownProd")
    public APIRespJson takeUpOrDownProd(ProductDo productDo) {
        Message message = null;
        try {
            message = productService.takeUpOrDownProd(productDo);
        } catch (IllegalArgumentException e) {
            log.error("参数错误", e);
            this.handleIllegalArgumentException(e);
        }
        return  this.response(message.getCode(), message.getMessage());
    }
}
