package cn.showclear.www.service.demandInfo.impl;

import cn.showclear.www.dao.base.demandInfo.DemandInfoDao;
import cn.showclear.www.pojo.base.DemandInfoDo;
import cn.showclear.www.service.demandInfo.DemandInfoService;
import cn.showclear.www.service.validate.ValidateService;
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

    /**
     * 通过number查找某条求购信息
     * @param demandInfoNumber
     * @return 求购信息对象
     */
    @Override
    public DemandInfoDo searchDemandInfo(String demandInfoNumber) throws IllegalArgumentException {
        log.info("search product, which number is " + demandInfoNumber);
        DemandInfoDo demandInfoDo = new DemandInfoDo();
        demandInfoDo.setDemandInfoNumber(demandInfoNumber);
        DemandInfoDo resultDemandInfo = this.searchDemandInfoList(demandInfoDo).get(0);
        return resultDemandInfo;
    }

    /**
     * 通过指定条件查询求购信息
     * @param demandInfoDo
     * @return 求购信息对象
     */
    @Override
    public List<DemandInfoDo> searchDemandInfoList(DemandInfoDo demandInfoDo) throws IllegalArgumentException {
        log.info(demandInfoDo.toString());
        validateService.validateDemandInfoSearch(demandInfoDo);
        List<DemandInfoDo> demandInfoDoList= demandInfoDao.searchDemandInfoByCol(demandInfoDo);
        return demandInfoDoList;
    }
}
