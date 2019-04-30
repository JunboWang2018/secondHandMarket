package cn.showclear.www.dao.base;

import cn.showclear.www.pojo.base.DemandInfoDo;
import cn.showclear.www.pojo.base.ProductDo;
import cn.showclear.www.pojo.base.SearchDemandInfoConditionQo;
import cn.showclear.www.pojo.base.SearchProductConditionQo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchDao {
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
     * @param demandInfoNumber
     * @return
     */
    DemandInfoDo searchDemandInfoByNumber(String demandInfoNumber);
    /**
     * 通过求购信息关键字查询求购信息
     * @param searchKey
     * @return
     */
    List<DemandInfoDo> searchDemandInfoByKey(String searchKey);

    /**
     * 通过求购信息中通过物品类型查询求购信息
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
