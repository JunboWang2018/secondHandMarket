package cn.showclear.www.service.product;

import cn.com.scooper.common.exception.BusinessException;
import cn.showclear.www.common.constant.Message;
import cn.showclear.www.pojo.base.ProductDo;
import cn.showclear.www.pojo.base.SearchProdListQo;
import cn.showclear.www.pojo.base.SearchProductQo;

import java.util.List;

public interface ProductService {

    /**
     * 查找单个物品，无需封装
     * @param productDo
     * @return
     */
    ProductDo searchProduct(ProductDo productDo) throws IllegalArgumentException;

    /**
     * 初始化查询条件（is_sold, is_selling, is_active）
     * @param productDo
     * @return
     */
    ProductDo searchProductInit(ProductDo productDo);

    /**
     * 查找单个物品，并查找其它需要的参数
     * @param productDo
     * @return
     */
    SearchProductQo searchProductQo(ProductDo productDo) throws IllegalArgumentException, BusinessException;

    /**
     * 查找多个物品，并查找其它需要的参数，返回封装后对象的集合
     * @param productDo
     * @return
     */
    List<SearchProductQo> searchProdQoList(ProductDo productDo) throws IllegalArgumentException, BusinessException;

    /**
     * 查找多个物品，返回物品集合，无需封装
     * @param productDo
     * @return
     */
    List<ProductDo> searchProductList(ProductDo productDo) throws IllegalArgumentException;

    /**
     * 初始化Qo查询条件（is_sold, is_selling, is_active）
     * @param searchProdListQo
     * @return
     */
    SearchProdListQo searchProductQoInit(SearchProdListQo searchProdListQo);

    /**
     * 通过自定义条件，查询物品，返回类中包含符合条件物品列表
     * @param searchProdListQo
     * @return
     * @throws IllegalArgumentException
     */
    List<ProductDo> searchProdListQo(SearchProdListQo searchProdListQo) throws IllegalArgumentException;

    /**
     * 出售物品（is_sold设为1）
     * @param productNumber
     * @return
     */
    Integer saleProduct(String productNumber);

    /**
     * 物品上/下架（is_selling设为1/0）
     * @param productDo
     * @return
     */
    Message takeUpOrDownProd(ProductDo productDo);
}
