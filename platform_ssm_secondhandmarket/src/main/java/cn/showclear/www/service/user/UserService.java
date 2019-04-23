package cn.showclear.www.service.user;

import cn.com.scooper.common.exception.BusinessException;
import cn.showclear.www.common.constant.Message;
import cn.showclear.www.pojo.base.UserDo;

import java.util.List;

/**
 * 用户登录注册接口
 */
public interface UserService {


    /**
     * 用户登录
     * @param userDo
     * @return
     */
    Message userLogin(UserDo userDo) throws IllegalArgumentException;

    /**
     * 用户注册
     * @param userDo
     * @return
     */
    Message userRegister(UserDo userDo) throws IllegalArgumentException;

    /**
     * 根据自定义条件查找用户list
     * @param userDo
     * @return
     */
    List<UserDo> searchUserList(UserDo userDo) throws IllegalArgumentException;

    /**
     * 根据自定义条件查找用户
     * @param userDo
     * @return
     */
    UserDo searchUser(UserDo userDo) throws IllegalArgumentException, BusinessException;
}
