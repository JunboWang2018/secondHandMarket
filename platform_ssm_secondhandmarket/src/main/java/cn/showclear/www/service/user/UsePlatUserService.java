package cn.showclear.www.service.user;

import cn.showclear.www.common.constant.Message;
import cn.showclear.www.pojo.base.UserDo;

public interface UsePlatUserService {
    /**
     * 登录验证
     * @param userDo
     * @return
     */
    Message login(UserDo userDo);

    /**
     * 通过token查找用户信息
     * @param token
     * @return
     */
    UserDo getUserInfoByToken(String token, String accUsername);

    /**
     * 注册
     * @param userDo
     * @return
     */
    Message register(UserDo userDo);

    /**
     * 退出账号
     * @param token
     * @return
     */
    Message logout(String token);

}
