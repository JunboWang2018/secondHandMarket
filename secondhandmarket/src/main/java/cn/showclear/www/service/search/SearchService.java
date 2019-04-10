package cn.showclear.www.service.search;

import cn.showclear.www.pojo.base.DemandInfoDo;
import cn.showclear.www.pojo.base.ProductDo;
import cn.showclear.www.pojo.base.SearchDemandInfoConditionQo;
import cn.showclear.www.pojo.base.SearchProductConditionQo;

import java.util.List;

/**
 * 查询模块Service
 * 物品和求购信息分别有关键字、分类、自定义三种查询方式
 */
public interface SearchService {

    /**
     * 通过物品编号查询物品
     * @param productNumber
     * @return
     */
    ProductDo searchProductByNumber(String productNumber);
    /**
     * 通过物品关键字查询物品
     * @param searchKey
     * @return
     */
    List<ProductDo> searchProductByKey(String searchKey);

    /**
     * 通过物品类型查询物品
     * @param searchType
     * @return
     */
    List<ProductDo> searchProductByType(String searchType);

    /**
     * 通过物品自定义条件查询物品
     * @param searchProductConditionQo
     * @return
     */
    List<ProductDo> searchProductByCondition(SearchProductConditionQo searchProductConditionQo);

    /**
     * 通过求购信息编号查询求购信息
     * @param productNumber
     * @return
     */
    DemandInfoDo searchDemandInfoByNumber(String productNumber);
    /**
     * 通过求购信息关键字查询求购信息
     * @param searchKey
     * @return
     */
    List<DemandInfoDo> searchDemandInfoByKey(String searchKey);

    /**
     * 通过求购信息中物品类型查询求购信息
     * @param searchType
     * @return
     */
    List<DemandInfoDo> searchDemandInfoByType(String searchType);

    /**
     * 通过求购信息自定义条件查询求购信息
     * @param searchDemandInfoConditionQo
     * @return
     */
    List<DemandInfoDo> searchDemandInfoByCondition(SearchDemandInfoConditionQo searchDemandInfoConditionQo);
}
