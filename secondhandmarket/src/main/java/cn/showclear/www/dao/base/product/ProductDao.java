package cn.showclear.www.dao.base.product;

import cn.showclear.www.pojo.base.ProductDo;
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
}
