package cn.showclear.www.dao.base.product;

import cn.showclear.www.pojo.base.ProductDo;
import cn.showclear.www.pojo.base.SearchProdListQo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 二手物品
 */
@Repository
public interface ProductDao {
    /**
     * 根据指定列条件查找物品
     * @param productDo
     * @return
     */
    List<ProductDo> searchProdByCol(ProductDo productDo);

    /**
     * 发布商品
     * @param productDo
     * @return
     */
    Integer releaseProduct(ProductDo productDo);

    /**
     * 根据条件查询物品集合
     * @param searchProdListQo
     * @return
     */
    List<ProductDo> searchProdListByQo(SearchProdListQo searchProdListQo);

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
    Integer takeUpOrDownProd(ProductDo productDo);
}
