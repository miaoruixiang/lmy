package com.niit.lmy.controller;


import com.alibaba.fastjson.JSONObject;
import com.niit.lmy.entity.UserInfo;
import com.niit.lmy.entity.UserLogin;
import com.niit.lmy.service.UserService;
import com.niit.lmy.utils.ConstConfig;
import com.niit.lmy.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "user/")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "verify", method = RequestMethod.POST)
    public ResponseMessage verify(@RequestBody JSONObject jsonObject){
        String mobile = (String) jsonObject.get("mobile");
        boolean flag = userService.checkAccount(mobile);
        ResponseMessage responseMessage = null;
        if (mobile.length() != 11){
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.PHONE_NUMBER_ERROR,null);
        }else {
            if (flag){//该手机可用
                responseMessage = userService.getCode("SMS_136070001",mobile);
            }else {
                //该手机已被使用,不能用
                responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.PHONE_NUMBER_EXIST,null);
            }
        }
        return responseMessage;
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public ResponseMessage newUser(@RequestBody JSONObject jsonObject){
        ResponseMessage responseMessage =null;
        String mobile = (String) jsonObject.get("mobile");
        String password = (String) jsonObject.get("password");
        String myCode = (String) jsonObject.get("code");
        ResponseMessage res= userService.checkCode(mobile,myCode);
        if (res.getMsg().equals("验证码正确")){
            responseMessage = userService.newUser(mobile,password);
        }else {
            responseMessage = res;
        }
        return responseMessage;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseMessage userLogin(@RequestBody UserLogin userLogin){
        ResponseMessage responseMessage = null;
        String account = userLogin.getUserAccount();
        boolean flag = userService.checkAccount(account);
        if (flag){
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.USER_LOGIN_MOBILE_ERROR,null);
        }else {
            responseMessage = userService.userLogin(userLogin);
        }
        return responseMessage;
    }

    @RequestMapping(value = "login/mobile/send", method = RequestMethod.POST)
    public ResponseMessage mobileSend(@RequestBody JSONObject jsonObject){
        String mobile = (String) jsonObject.get("mobile");
        ResponseMessage responseMessage = null;
        boolean flag = userService.checkAccount(mobile);
        if (mobile.length() != 11){
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.USER_LOGIN_MOBILE_ERROR,null);
        }else {
            if (flag){//帐号不存在
                responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.USER_LOGIN_MOBILE_ERROR,null);
            }else {
                //帐号存在
                responseMessage = userService.getCode("SMS_136065007",mobile);
            }
        }
        return responseMessage;
    }

    @RequestMapping(value = "login/mobile/check", method = RequestMethod.POST)
    public ResponseMessage mobileLogin(@RequestBody JSONObject jsonObject){
        String mobile = (String) jsonObject.get("mobile");
        String myCode = (String) jsonObject.get("code");
        ResponseMessage responseMessage = userService.mobileLogin(mobile,myCode);
        return responseMessage;
    }

    @RequestMapping(value = "password/mobile/send", method = RequestMethod.POST)
    public ResponseMessage passwordMobileSend(@RequestBody JSONObject jsonObject){
        ResponseMessage responseMessage = null;
        String mobile = (String) jsonObject.get("mobile");
        boolean flag = userService.checkAccount(mobile);
        if (mobile.length() != 11){
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.USER_LOGIN_MOBILE_ERROR,null);
        }else {
            if (flag){//帐号不存在
                responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.USER_LOGIN_MOBILE_ERROR,null);
            }else {
                //帐号存在
                responseMessage = userService.getCode("SMS_136000009",mobile);
            }
        }
        return responseMessage;
    }

    @RequestMapping(value = "password/mobile/check", method = RequestMethod.POST)
    public ResponseMessage passwordMobileCheck(@RequestBody JSONObject jsonObject){
        String mobile = (String) jsonObject.get("mobile");
        String myCode = (String) jsonObject.get("code");
        ResponseMessage responseMessage = userService.checkCode(mobile,myCode);
        return responseMessage;
    }

    @RequestMapping(value = "password", method = RequestMethod.PUT)
    public ResponseMessage updatePassword(@RequestBody JSONObject jsonObject){
        String mobile = (String) jsonObject.get("mobile");
        String password = (String) jsonObject.get("password");
        ResponseMessage responseMessage = userService.updatePassword(mobile,password);
        return responseMessage;
    }

    @RequestMapping(value = "info", method = RequestMethod.PUT)
    public ResponseMessage updateUserInfo(@RequestBody UserInfo userInfo){
        ResponseMessage responseMessage = null;
        responseMessage = userService.updateUserInfo(userInfo);
        return responseMessage;
    }

}
