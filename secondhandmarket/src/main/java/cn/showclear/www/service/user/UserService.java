package cn.showclear.www.service.user;

/**
 * 用户登录注册接口
 */
public interface UserService {


    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    public String userLogin(String username, String password);

    public String userRegister(String username, String password);
}
