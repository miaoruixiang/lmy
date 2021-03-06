package com.niit.lmy.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.niit.lmy.entity.UserInfo;
import com.niit.lmy.entity.UserLogin;
import com.niit.lmy.mapper.UserInfoMapper;
import com.niit.lmy.mapper.UserLoginMapper;
import com.niit.lmy.service.RedisService;
import com.niit.lmy.service.UserService;
import com.niit.lmy.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.security.provider.MD5;

import java.security.NoSuchAlgorithmException;
import java.util.*;

@Service //标志为一个Service组件
@Transactional //事务注解
public class UserServiceImpl implements UserService {
    @Autowired
    private UserLoginMapper userLoginMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private RedisService redisService;

    @Override
    public boolean checkAccount(String mobile) {
        List<UserLogin> users = userLoginMapper.selectList(
                new EntityWrapper<UserLogin>().eq("user_account",mobile)
        );
        if (users.size() != 0){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public ResponseMessage getCode(String templateCode, String mobile) {
        ResponseMessage responseMessage = null;
        try {
            //给手机发注册模版短信，并返回6位验证码
            String code = SendMessage.send(templateCode,mobile);
            //将code存入redis缓存，并指定失效时间
            redisService.set("code"+mobile,code,60);
            //给客户端相应
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.VERIFY_CODE_OK,null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseMessage;
    }

    @Override
    public ResponseMessage checkCode(String mobile, String code) {
        ResponseMessage responseMessage = null;
        String trueCode = redisService.get("code"+mobile);
        System.out.println(trueCode);
        if (code.equals(trueCode)){
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.VERIFY_CODE_Ok,null);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.VERIFY_CODE_ERROR,null);
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage newUser(String mobile,String password) {
        ResponseMessage responseMessage = null;
        Date date = new Date();
        String MD5password = null;
        try {
            MD5password =  MD5Util.encrypt(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String uuid = UUIDUtils.getUUID();
        String secret = RandomString.getRandomString();

        UserLogin userLogin = new UserLogin();

        userLogin.setUuid(uuid);
        userLogin.setUserAccount(mobile);
        userLogin.setUserPassword(MD5password);
        userLogin.setSecet(secret);
        userLogin.setCreateTime(date);
        userLogin.setUpdateTime(date);

        UserInfo userInfo = new UserInfo();
        userInfo.setUserAccount(mobile);
        userInfo.setUserNickname(mobile);
        userInfo.setUserMobile(mobile);
        userInfo.setUserCreateTime(date);
        userInfo.setUserUpdateTime(date);

        int n = userLoginMapper.insert(userLogin);
        int m = userInfoMapper.insert(userInfo);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userLogin",userLogin);
        jsonObject.put("userInfo",userInfo);

        if (n != 0 && m != 0){
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.USER_NEW_OK,jsonObject);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.USER_NEW_ERROR,null);
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage userLogin(UserLogin userLogin) {
        ResponseMessage responseMessage = null;
        JSONObject jsonObject = new JSONObject();
        String account = userLogin.getUserAccount();
        String password = userLogin.getUserPassword();
        String MD5password = null;
        try {
            MD5password =  MD5Util.encrypt(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        List<UserLogin> userLoginList = userLoginMapper.selectList(
                new EntityWrapper<UserLogin>().eq("user_account",account)
        );
        List<UserInfo> userInfoList = userInfoMapper.selectList(
                new EntityWrapper<UserInfo>().eq("user_account",account)
        );
        UserLogin login = userLoginList.get(0);
        String secret = login.getSecet();
        String token = JWT.sign(login,30*24*60*60*1000,secret);
        System.out.println(token);
        redisService.set("token_"+account,token,1296000000);

        UserInfo userInfo = userInfoList.get(0);
        jsonObject.put("token",token);
        jsonObject.put("userInfo",userInfo);
        if (MD5password.equals(login.getUserPassword())){
            if (login.getUserStatus() == 0){
                responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.USER_LOGIN_OK,jsonObject);
            }else {
                responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.USER_LOGIN_ERROR,null);
            }
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.USER_LOGIN_PASSWORD_ERROR,null);
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage updatePassword(String account,String password) {
        ResponseMessage responseMessage = null;
        UserLogin userLogin = userLoginMapper.selectList(
                new EntityWrapper<UserLogin>().eq("user_account",account)
        ).get(0);
        Date date = new Date();
        String MD5password = password;
        try {
            MD5password =  MD5Util.encrypt(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        userLogin.setUserPassword(MD5password);
        userLogin.setUpdateTime(date);
        int n = 0;
        n = userLoginMapper.updateById(userLogin);
        if (n != 0){
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.USER_PASSWORD_UPDATE_OK,null);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.USER_PASSWORD_UPDATE_ERROR,null);
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage mobileLogin(String mobile, String code) {
        ResponseMessage responseMessage = null;
        JSONObject jsonObject = new JSONObject();
        String trueCode = redisService.get("code"+mobile);
        List<UserLogin> userLoginList = userLoginMapper.selectList(
                new EntityWrapper<UserLogin>().eq("user_account",mobile)
        );
        List<UserInfo> userInfoList = userInfoMapper.selectList(
                new EntityWrapper<UserInfo>().eq("user_account",mobile)
        );
        UserLogin login = userLoginList.get(0);
        UserInfo userInfo = userInfoList.get(0);
        String secret = login.getSecet();
        String token = JWT.sign(login,30*24*60*60*1000,secret);
        redisService.set("token_"+mobile,token,30*24*60*60*1000);

        jsonObject.put("token",token);
        jsonObject.put("userInfo",userInfo);
        if (code.equals(trueCode)){
            if (login.getUserStatus() == 0){
                responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.USER_LOGIN_OK,jsonObject);
            }else {
                responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.USER_LOGIN_ERROR,null);
            }
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.VERIFY_CODE_ERROR,null);
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage updateUserInfo(UserInfo userInfo) {
        ResponseMessage responseMessage = null;
        Date date = new Date();
        userInfo.setUserUpdateTime(date);
        int n = 0;
        n = userInfoMapper.updateById(userInfo);
        if (n != 0){
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.UPDATE_OK,null);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.UPDATE_ERROR,null);
        }
        return responseMessage;
    }
}
