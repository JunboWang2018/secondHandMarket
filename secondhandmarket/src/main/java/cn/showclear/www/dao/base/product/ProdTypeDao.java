package cn.showclear.www.dao.base.product;

import cn.showclear.www.pojo.base.ProductTypeDo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdTypeDao {

    /**
     * 查找类别
     * @param productTypeDo
     * @return
     */
    List<ProductTypeDo> searchProdTypeByCol(ProductTypeDo productTypeDo);

}
