package cn.showclear.www.dao.base;

import cn.showclear.www.pojo.base.UserDo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    /**
     * 登录
     * @param username
     * @return 返回用户对象
     */
    UserDo login(String username);

    /**
     * 注册
     * @param userDo
     * @return 影响行数 [0: 注册失败，1：注册成功]
     */
    Integer register(UserDo userDo);
}
