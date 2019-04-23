package cn.showclear.www.service.user.impl;

import cn.com.scooper.common.resp.ResultCode;
import cn.showclear.www.common.constant.Message;
import cn.showclear.www.pojo.base.UserDo;
import cn.showclear.www.service.user.UsePlatUserService;
import cn.showclear.www.service.validate.ValidateService;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.fluent.Form;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Wang Junbo
 * @description
 * @date 2019/4/23
 */

@Service
public class UsePlatUserServiceImpl implements UsePlatUserService {
    private final static Logger LOGGER = LoggerFactory.getLogger(UsePlatUserServiceImpl.class);

    @Autowired
    private ValidateService validateService;

    @Value("#{configProperties['scooper-core.base']}")
    private String scooperCoreBase;

    private URI _loginURI;
    private URI _logoutURI;
    private URI accountInfoURI;

    @Override
    public Message login(UserDo userDo) {
        validateService.validateUser(userDo);
        //登录并返回token
        try {
            String resStr = Request.Post(this.getLoginURI())
                    .bodyForm(Form.form()
                            .add("accUsername", userDo.getUserName())
                            .add("accPassword", this.sha256(userDo.getPassword()))
                            .build())
                    .execute()
                    .returnContent()
                    .asString();
            if (StringUtils.isEmpty(resStr)) {
                LOGGER.error("remote login failed : response is empty");
                return Message.LOGIN_FAILED;
            }
            JSONObject resJson = JSONObject.parseObject(resStr);
            int resCode = resJson.getIntValue("code");
            if (ResultCode.SUCC == resCode) {
                //取出token并设置
                userDo.setToken(resJson.getString("token"));
                //将密码清空
                userDo.setPassword("");
                return Message.LOGIN_SUCCESS;
            } else {
                return Message.USER_NOT_EXIST;
            }
        } catch (IOException e) {
            LOGGER.error("remote login failed", e.getMessage());
        }

        return null;
    }

    @Override
    public UserDo getUserInfoByToken(String token, String accUsername) {
        UserDo resultUser = new UserDo();
        if (StringUtils.isEmpty(token) || StringUtils.isEmpty(accUsername)) {
            throw new IllegalArgumentException();
        }
        try {
            String resStr = Request.Post(this.getAccountInfoURI())
                    .bodyForm(Form.form()
                            .add("token", token)
                            .add("accUsername", accUsername)
                            .build())
                    .execute()
                    .returnContent()
                    .asString();
            if (StringUtils.isEmpty(resStr)) {
                LOGGER.error("remote login failed : response is empty");
                return null;
            }
            JSONObject resJson = JSONObject.parseObject(resStr);
            int resCode = resJson.getIntValue("code");
            if (resCode == ResultCode.SUCC) {
                resultUser.setUserId(resJson.getInteger("id"));
                resultUser.setUserName(resJson.getString("accUsername"));
                resultUser.setToken(token);
                resultUser.setCreateDate(resJson.getTimestamp("createTime"));
                resultUser.setModifyDate(resJson.getTimestamp("modifyTime"));
                return resultUser;
            }
        } catch (IOException e) {
            LOGGER.error("remote getAccountInfo failed : " + e.getMessage());
        }

        return null;
    }

    @Override
    public Message register(UserDo userDo) {
        return null;
    }

    @Override
    public Message logout(String token) {
        return null;
    }


    private URI getLoginURI() {
        if (scooperCoreBase == null) {
            validateScooperCoreBase();
            try {
                _loginURI = new URI(scooperCoreBase + "/scooper-core-rest/data/system/authManage/loginTo");
            } catch (URISyntaxException e) {
                LOGGER.error("URI format incorrect" + scooperCoreBase);
            }
        }
        return _loginURI;
    }

    private URI getLogoutURI() {
        if (scooperCoreBase == null) {
            validateScooperCoreBase();
            try {
                _logoutURI = new URI(scooperCoreBase + "/scooper-core-rest/data/system/authManage/logout");
            } catch (URISyntaxException e) {
                LOGGER.error("URI format incorrect" + scooperCoreBase);
            }
        }
        return _logoutURI;
    }

    private URI getAccountInfoURI() {
        if (scooperCoreBase == null) {
            validateScooperCoreBase();
            try {
                accountInfoURI = new URI(scooperCoreBase + "/data/system/accountManage/getAccountDetail");
            } catch (URISyntaxException e) {
                LOGGER.error("URI format incorrect" + scooperCoreBase);
            }
        }
        return accountInfoURI;
    }

    private void validateScooperCoreBase() {
        if (StringUtils.isBlank(scooperCoreBase)) {
            throw new IllegalArgumentException("scooperCoreBase not set");
        }
    }

    private String sha256(String data) {
        return DigestUtils.sha256Hex(data);
    }

}
