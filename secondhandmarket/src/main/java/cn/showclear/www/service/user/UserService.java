package cn.showclear.www.service.user;

import cn.showclear.www.common.constant.Message;
import cn.showclear.www.pojo.base.UserDo;

/**
 * 用户登录注册接口
 */
public interface UserService {


    /**
     * 用户登录
     * @param userDo
     * @return
     */
    Message userLogin(UserDo userDo);

    /**
     * 用户注册
     * @param userDo
     * @return
     */
    Message userRegister(UserDo userDo);
}
