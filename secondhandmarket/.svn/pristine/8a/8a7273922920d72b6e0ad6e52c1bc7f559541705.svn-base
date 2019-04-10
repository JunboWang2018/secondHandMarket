package cn.showclear.www.service.user.impl;

import cn.showclear.www.common.constant.CommonConstant;
import cn.showclear.www.dao.base.UserDao;
import cn.showclear.www.pojo.base.UserDo;
import cn.showclear.www.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * @author Junbo Wang
 * @description
 * @date 2019/4/5
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;
    /**
     * 登录
     * @param username
     * @return
     */
    @Override
    public UserDo userLogin(String username) {
        log.info("Enter UserServiceImpl.userLogin");
        UserDo userDo = userDao.login(username);
        log.info("Exit UserServiceImpl.userLogin");
        return userDo;
    }

    /**
     * 注册
     * @param username
     * @param password
     * @return
     */
    @Override
    public String userRegister(String username, String password) {
        log.info("Enter UserServiceImpl.userRegister");
        UserDo userDo = new UserDo();
        userDo.setUserName(username);
        userDo.setPassword(password);
        userDo.setCreateDate(new Timestamp(System.currentTimeMillis()));
        Integer count = userDao.register(userDo);
        if (count == 1) {
            log.info("count = " + count + ", register success");
            return CommonConstant.SUCCESS;
        }
        log.info("count = " + count + ", register failed");
        log.info("Exit UserServiceImpl.userRegister");
        return CommonConstant.ERROR;
    }
}
