package cn.showclear.www.service.demandInfo.impl;

import cn.com.scooper.common.exception.BusinessException;
import cn.showclear.utils.FilterByConditionUtil;
import cn.showclear.www.dao.base.demandInfo.DemandInfoDao;
import cn.showclear.www.pojo.base.*;
import cn.showclear.www.service.demandInfo.DemandInfoService;
import cn.showclear.www.service.product.ProdTypeService;
import cn.showclear.www.service.user.UserService;
import cn.showclear.www.service.validate.ValidateService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wang Junbo
 * @description
 * @date 2019/4/11
 */
@Service
public class DemandInfoServiceImpl implements DemandInfoService {
    private static final Logger log = LoggerFactory.getLogger(DemandInfoServiceImpl.class);

    @Autowired
    private DemandInfoDao demandInfoDao;

    @Autowired
    private ValidateService validateService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProdTypeService prodTypeService;

    @Override
    public DemandInfoDo searchDemandInfo(String demandInfoNumber) {
        List<DemandInfoDo> list = null;
        DemandInfoDo demandInfoDo = new DemandInfoDo();
        demandInfoDo.setDemandInfoNumber(demandInfoNumber);
        list = this.searchDemandInfoList(demandInfoDo);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    /**
     * 通过number查找某条求购信息,并查询需要的信息
     * @param demandInfoNumber
     * @return 求购信息对象
     */
    @Override
    public SearchDemdInfoQo searchDemdInfoQo(String demandInfoNumber) throws BusinessException {
        DemandInfoDo resultDemandInfo = null;
        SearchDemdInfoQo searchDemdInfoQo = new SearchDemdInfoQo();
        resultDemandInfo = this.searchDemandInfo(demandInfoNumber);
        searchDemdInfoQo.setDemandInfoDo(resultDemandInfo);
        //查询类别名称
        ProductTypeDo productTypeDo = new ProductTypeDo();
        productTypeDo.setCode(resultDemandInfo.getTypeCode());
        searchDemdInfoQo.setTypeName(prodTypeService.searchProdType(productTypeDo).getName());
        //查询用户名称、联系方式
        UserDo userDo = new UserDo();
        userDo.setUserId(resultDemandInfo.getUserId());
        UserDo userResult = userService.searchUser(userDo);
        searchDemdInfoQo.setUserName(userResult.getUserName());
        searchDemdInfoQo.setUserTel(userResult.getTel());
        return searchDemdInfoQo;
    }

    /**
     * 通过指定条件查询求购信息
     * @param demandInfoDo
     * @return 求购信息对象
     */
    @Override
    public List<DemandInfoDo> searchDemandInfoList(DemandInfoDo demandInfoDo) {
        log.info(demandInfoDo.toString());
        validateService.validateDemandInfoSearch(demandInfoDo);
        List<DemandInfoDo> demandInfoDoList= demandInfoDao.searchDemandInfoByCol(demandInfoDo);
        return demandInfoDoList;
    }

    /**
     * 按自定义条件查询求购信息
     * @param searchProdListQo
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public List<DemandInfoDo> searchDemdInfoListByQo(SearchProdListQo searchProdListQo) {
        List<DemandInfoDo> resultList = demandInfoDao.searchDemdInfoListByQo(searchProdListQo);
        //按折旧率过滤求购信息
        if (resultList != null && !StringUtils.isEmpty(searchProdListQo.getDepRateSymbol()) && searchProdListQo.getDepreciationRate() != null) {
            resultList = FilterByConditionUtil.filterDemdInfoListByRate(resultList, searchProdListQo.getDepRateSymbol(), searchProdListQo.getDepreciationRate());
        }
        return resultList;
    }
}
