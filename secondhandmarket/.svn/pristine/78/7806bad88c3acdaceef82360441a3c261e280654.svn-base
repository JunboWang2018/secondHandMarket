package cn.showclear.www.service.validate.impl;

import cn.com.scooper.common.exception.BusinessException;
import cn.showclear.www.common.constant.Message;
import cn.showclear.www.pojo.base.DemandInfoDo;
import cn.showclear.www.pojo.base.ProductDo;
import cn.showclear.www.pojo.base.UserDo;
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
    public void validateUser(UserDo userDo) throws IllegalArgumentException{
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
    public void validateProductRelease(ProductDo productDo) throws IllegalArgumentException {

    }

    @Override
    public void validateDemandInfoRelease(DemandInfoDo demandInfoDo) throws IllegalArgumentException {

    }

    @Override
    public void validateProductSearch(ProductDo productDo) throws IllegalArgumentException {

    }

    @Override
    public void validateDemandInfoSearch(DemandInfoDo demandInfoDo) throws IllegalArgumentException {

    }
}
