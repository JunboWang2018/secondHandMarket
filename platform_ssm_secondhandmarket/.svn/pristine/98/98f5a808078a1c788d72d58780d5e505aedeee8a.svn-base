package cn.showclear.www.service.search.impl;

import cn.showclear.www.dao.base.SearchDao;
import cn.showclear.www.pojo.base.DemandInfoDo;
import cn.showclear.www.pojo.base.ProductDo;
import cn.showclear.www.pojo.base.SearchDemandInfoConditionQo;
import cn.showclear.www.pojo.base.SearchProductConditionQo;
import cn.showclear.www.service.search.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wang Junbo
 * @description 查询模块Service。物品和求购信息分别有关键字、分类、自定义三种查询方式
 * @date 2019/4/9
 */
@Service
public class SearchServiceImpl implements SearchService {
    private static final Logger log = LoggerFactory.getLogger(SearchServiceImpl.class);

    @Autowired
    private SearchDao searchDao;

    /**
     * 通过物品编号查询
     * @param productNumber
     * @return
     */
    @Override
    public ProductDo searchProductByNumber(String productNumber) {
        return searchDao.searchProductByNumber(productNumber);
    }

    /**
     * 通过物品关键字查询
     * @param searchKey
     * @return
     */
    @Override
    public List<ProductDo> searchProductByKey(String searchKey) {
        return searchDao.searchProductByKey(searchKey);
    }

    /**
     * 通过物品分类查询
     * @param searchType
     * @return
     */
    @Override
    public List<ProductDo> searchProductByType(String searchType) {
        return searchDao.searchProductByType(searchType);
    }

    /**
     * 通过物品自定义条件查询
     * @param searchProductConditionQo
     * @return
     */
    @Override
    public List<ProductDo> searchProductByCondition(SearchProductConditionQo searchProductConditionQo) {
        return searchDao.searchProductByCondition(searchProductConditionQo);
    }

    /**
     * 通过求购信息编号查询
     * @param demandInfoNumber
     * @return
     */
    @Override
    public DemandInfoDo searchDemandInfoByNumber(String demandInfoNumber) {
        return searchDao.searchDemandInfoByNumber(demandInfoNumber);
    }

    /**
     * 通过求购信息关键字查询
     * @param searchKey
     * @return
     */
    @Override
    public List<DemandInfoDo> searchDemandInfoByKey(String searchKey) {
        return searchDao.searchDemandInfoByKey(searchKey);
    }

    /**
     * 通过求购信息通过物品分类查询
     * @param searchType
     * @return
     */
    @Override
    public List<DemandInfoDo> searchDemandInfoByType(String searchType) {
        return searchDao.searchDemandInfoByType(searchType);
    }

    /**
     * 通过求购信息自定义条件查询
     * @param searchDemandInfoConditionQo
     * @return
     */
    @Override
    public List<DemandInfoDo> searchDemandInfoByCondition(SearchDemandInfoConditionQo searchDemandInfoConditionQo) {
        return searchDao.searchDemandInfoByCondition(searchDemandInfoConditionQo);
    }
}
