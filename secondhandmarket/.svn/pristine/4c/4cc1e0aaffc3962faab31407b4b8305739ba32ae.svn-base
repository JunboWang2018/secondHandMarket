package cn.showclear.www.dao.base.user;

import cn.showclear.www.pojo.base.UserDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    /**
     * 登录
     * @param userName
     * @return 返回用户对象
     */
    UserDo searchUser(String userName);

    /**
     * 注册
     * @param userDo
     * @return 影响行数 [0: 注册失败，1：注册成功]
     */
    Integer register(UserDo userDo);


    /**
     * 根据条件返回用户列表
     * @param userDo
     * @return
     */
    List<UserDo> searchUserByCol(UserDo userDo);
}
