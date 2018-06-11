package com.niit.lmy.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * 发短信工具类
 */
public class SendMessage {

    static final String product = "Dysmsapi";     //产品名称:云通信短信API产品,开发者无需替换

    static final String domain = "dysmsapi.aliyuncs.com"; //产品域名,开发者无需替换
    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)

    static final String accessKeyId = "LTAIzxMBl4eEVcFy";

    static final String accessKeySecret = "VLfEATFACrrZ4oPGVyLZku9SJLiztz";


    /**
     * 向指定手机发送指定模板的短信，返回6位随机验证码
     *
     * @param templateCode 短信模板code
     * @param mobile       手机号码
     * @return
     */
    public static String send(String templateCode, String mobile) throws Exception {

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "1000");
        System.setProperty("sun.net.client.defaultReadTimeout", "1000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(mobile);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName("企业管理系统登录验证");
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(templateCode);
        //可选:模板中的变量替换JSON串
        String codeString = CoreUtils.getRandomString();
        request.setTemplateParam("{\"code\":" + codeString + "}");

        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if (sendSmsResponse.getCode().equals("OK")) {
            return codeString;
        } else {
            return ConstConfig.VERIFY_CODE_FAIL;
        }
    }

    public static void main(String[] args) throws ClientException, InterruptedException {
        try {
            String code = SendMessage.send("SMS_136065009; ","15195226887");
            System.out.println(code);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
