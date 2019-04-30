package cn.showclear.www.service.product;

import cn.com.scooper.common.exception.BusinessException;
import cn.showclear.www.pojo.base.ProductTypeDo;

import java.util.List;

public interface ProdTypeService {

    /**
     * 获取prod type集合
     * @param productTypeDo
     * @return
     */
    List<ProductTypeDo> searchProdTypeList(ProductTypeDo productTypeDo) throws IllegalArgumentException;

    /**
     * 获取prod type
     * @param productTypeDo
     * @return
     */
    ProductTypeDo searchProdType(ProductTypeDo productTypeDo) throws IllegalArgumentException, BusinessException;
}
