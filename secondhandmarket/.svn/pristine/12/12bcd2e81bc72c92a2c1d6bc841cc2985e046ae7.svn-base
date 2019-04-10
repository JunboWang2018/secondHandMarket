package cn.showclear.www.service.release.impl;

import cn.showclear.utils.AutoGenerateNumberUtil;
import cn.showclear.www.common.constant.CommonConstant;
import cn.showclear.www.dao.base.ReleaseDao;
import cn.showclear.www.pojo.base.DemandInfoDo;
import cn.showclear.www.pojo.base.ProductDo;
import cn.showclear.www.service.release.ReleaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author Wang Junbo
 * @description
 * @date 2019/4/8
 */
@Service
public class ReleaseServiceImpl implements ReleaseService {
    private static final Logger log = LoggerFactory.getLogger(ReleaseServiceImpl.class);

    private ReleaseDao releaseDao;

    /**
     * 发布二手物品
     * @param productDo
     * @return
     */
    @Override
    public String releaseProduct(ProductDo productDo) {
        String productNumber = AutoGenerateNumberUtil.getAutoGenerateId("prod");
        log.info("productNumber = " + productNumber);
        if (productNumber != null && !productNumber.isEmpty()) {
            productDo.setProductNumber(productNumber);
            Integer count = releaseDao.releaseProduct(productDo);
            log.info("insert Product table " + count + " rows");
            if (count == 1) {
                return CommonConstant.SUCCESS;
            } else {
                return CommonConstant.ERROR;
            }
        } else {
            return CommonConstant.ERROR;
        }
    }

    /**
     * 发布求购信息
     * @param demandInfoDo
     * @return
     */
    @Override
    public String releaseDemandInfo(DemandInfoDo demandInfoDo) {
        String demandInfoNumber = AutoGenerateNumberUtil.getAutoGenerateId("dmdi");
        log.info("productNumber = " + demandInfoNumber);
        if (demandInfoNumber != null && !demandInfoNumber.isEmpty()) {
            demandInfoDo.setDemandInfoNumber(demandInfoNumber);
            Integer count = releaseDao.releaseDemandInfo(demandInfoDo);
            log.info("insert DemandInfo table " + count + " rows");
            if (count == 1) {
                return CommonConstant.SUCCESS;
            } else {
                return CommonConstant.ERROR;
            }
        } else {
            return CommonConstant.ERROR;
        }
    }
}
