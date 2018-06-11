package com.niit.lmy.service;

import com.niit.lmy.entity.UserInfo;
import com.niit.lmy.entity.UserLogin;
import com.niit.lmy.utils.ResponseMessage;

public interface UserService {
    /**
     * 验证手机号是否可用
     * @param mobile
     * @return
     */
    boolean checkAccount(String mobile);

    /**
     *获取验证码
     * @param mobile
     * @return
     */
    ResponseMessage getCode(String templateCode, String mobile);

    /**
     * 核对验证码
     * @param mobile
     * @param code
     * @return
     */
    ResponseMessage checkCode(String mobile, String code);

    /**
     * 注册
     * @param mobile
     * @param password
     * @return
     */
    ResponseMessage newUser(String mobile, String password);

    /**
     * 帐号密码登录
     * @param userLogin
     * @return
     */
    ResponseMessage userLogin(UserLogin userLogin);

    /**
     * 改密码
     * @param account
     * @return
     */
    ResponseMessage updatePassword(String account, String password);

    /**
     * 手机登录
     * @param mobile
     * @param code
     * @return
     */
    ResponseMessage mobileLogin(String mobile,String code);

    /**
     * 修改用户信息
     * @param userInfo
     * @return
     */
    ResponseMessage updateUserInfo(UserInfo userInfo);

}
