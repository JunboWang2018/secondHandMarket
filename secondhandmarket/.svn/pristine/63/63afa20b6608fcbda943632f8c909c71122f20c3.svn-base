package cn.showclear.www.service.product.impl;

import cn.com.scooper.common.exception.BusinessException;
import cn.showclear.www.common.constant.Message;
import cn.showclear.www.dao.base.product.SaleWayDao;
import cn.showclear.www.pojo.base.SaleWayDo;
import cn.showclear.www.service.product.SaleWayService;
import cn.showclear.www.service.validate.ValidateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wang Junbo
 * @description
 * @date 2019/4/15
 */
@Service
public class SaleWayServiceImpl implements SaleWayService {
    private static final Logger log = LoggerFactory.getLogger(SaleWayServiceImpl.class);

    @Autowired
    private SaleWayDao saleWayDao;

    @Autowired
    private ValidateService validateService;

    @Override
    public List<SaleWayDo> searchSaleWayList(SaleWayDo saleWayDo) {
        validateService.validateSaleWaySearch(saleWayDo);
        log.info("data validate pass before search sale way");
        return saleWayDao.searchSaleWayListByCol(saleWayDo);
    }

    @Override
    public SaleWayDo searchSaleWay(SaleWayDo saleWayDo) {
        List<SaleWayDo> list = this.searchSaleWayList(saleWayDo);
        if (list.size() >= 1) {
            return list.get(0);
        } else {
            throw new BusinessException(Message.SALE_WAY_NOT_EXIST.getCode(), Message.SALE_WAY_NOT_EXIST.getMessage());
        }
    }


}
