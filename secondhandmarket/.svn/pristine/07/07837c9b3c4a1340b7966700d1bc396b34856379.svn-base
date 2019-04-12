package cn.showclear.www.service.product.impl;

import cn.showclear.www.common.constant.Message;
import cn.showclear.www.dao.base.product.ProductDao;
import cn.showclear.www.pojo.base.ProductDo;
import cn.showclear.www.service.product.ProductService;
import cn.showclear.www.service.validate.ValidateService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wang Junbo
 * @description  物品查询
 * @date 2019/4/11
 */
@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ValidateService validateService;
    /**
     * 通过商品编号查询物品
     * @param productNumber
     * @return 物品对象
     */
    @Override
    public ProductDo searchProduct(String productNumber) throws IllegalArgumentException {
        log.info("search product, which number is " + productNumber);
        ProductDo productDo = new ProductDo();
        productDo.setProductNumber(productNumber);
        ProductDo resultProduct = this.searchProductList(productDo).get(0);
        return resultProduct;
    }

    /**
     * 通过指定条件查询物品
     * @param productDo
     * @return 物品对象集合
     */
    @Override
    public List<ProductDo> searchProductList(ProductDo productDo) throws IllegalArgumentException {
        log.info("search product List");
        //默认查找未出售的物品
        if (productDo.getIsSold() == null) {
            productDo.setIsSold(0);
        }
        //输入参数校验
        validateService.validateProductSearch(productDo);
        return productDao.searchProdByCol(productDo);
    }
}
