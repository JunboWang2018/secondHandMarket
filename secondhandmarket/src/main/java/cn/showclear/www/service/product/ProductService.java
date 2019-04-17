package cn.showclear.www.service.product;

import cn.com.scooper.common.exception.BusinessException;
import cn.showclear.www.common.constant.Message;
import cn.showclear.www.pojo.base.ProductDo;
import cn.showclear.www.pojo.base.SearchProdListQo;
import cn.showclear.www.pojo.base.SearchProductQo;

import java.util.List;

public interface ProductService {

    /**
     * 通过编号查找某个物品
     * @param productDo
     * @return
     */
    ProductDo searchProduct(ProductDo productDo) throws IllegalArgumentException;

    /**
     * 通过编号查找某个物品，并查找其它需要的参数
     * @param productDo
     * @return
     */
    SearchProductQo searchProductQo(ProductDo productDo) throws IllegalArgumentException, BusinessException;

    /**
     * 按条件查找物品，返回物品集合
     * @param productDo
     * @return
     */
    List<ProductDo> searchProductList(ProductDo productDo) throws IllegalArgumentException;

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
}
