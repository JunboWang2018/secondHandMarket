package cn.showclear.www.service.validate.impl;

import cn.showclear.www.common.constant.Message;
import cn.showclear.www.pojo.base.*;
import cn.showclear.www.service.validate.ValidateService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author Wang Junbo
 * @description
 * @date 2019/4/11
 */
@Service
public class ValidateServiceImpl implements ValidateService {
    private static final Logger log = LoggerFactory.getLogger(ValidateServiceImpl.class);

    @Override
    public void validateUser(UserDo userDo) {
        if (StringUtils.isEmpty(userDo.getUserName())) {
            log.info("username is null");
            throw new IllegalArgumentException(Message.USERNAME_NULL.getMessage());
        }
        if (StringUtils.isEmpty(userDo.getPassword())) {
            log.info("password is null");
            throw new IllegalArgumentException(Message.PASSWORD_NULL.getMessage());
        }
    }

    @Override
    public boolean validateUserSearch(UserDo userDo) throws IllegalArgumentException {
        boolean flag = false; //默认不通过
        if (userDo.getUserId() != null) {
            flag = true;
        }
        if (userDo.getUserName() != null) {
            flag = true;
        }
        if (userDo.getCreateDate() != null) {
            flag = true;
        }
        if (userDo.getModifyDate() != null) {
            flag = true;
        }
        return flag;
    }

    @Override
    public void validateProductRelease(ProductDo productDo) {

    }

    @Override
    public void validateDemandInfoRelease(DemandInfoDo demandInfoDo) {

    }

    @Override
    public void validateProductSearch(ProductDo productDo) {

    }

    @Override
    public void validateDemandInfoSearch(DemandInfoDo demandInfoDo) {

    }

    @Override
    public void validateProdTypeSearch(ProductTypeDo productTypeDo) {

    }

    @Override
    public void validateSaleWaySearch(SaleWayDo saleWayDo) {

    }

    @Override
    public void validateBiddRecdSearch(BiddingRecordDo biddingRecordDo) {

    }

    @Override
    public void validateBiddRecdInsert(BiddingRecordDo biddingRecordDo) throws IllegalArgumentException {

    }

    @Override
    public void validateBargRecdSearch(BargainingRecordDo bargainingRecordDo) throws IllegalArgumentException {

    }

    @Override
    public void validateBargRecdInsert(BargainingRecordDo bargainingRecordDo) throws IllegalArgumentException {

    }

    @Override
    public void validateOrderSearch(OrderDo orderDo) throws IllegalArgumentException {

    }

    @Override
    public void validateOrderInsert(OrderDo orderDo) throws IllegalArgumentException {

    }
}
