package com.chat.autoconfig.template;

import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.dysmsapi20170525.models.SendSmsResponseBody;
import com.aliyun.teaopenapi.models.Config;
import com.aliyun.dysmsapi20170525.Client;
import com.chat.autoconfig.properties.SmsProperties;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Td
 * @ClassName SmsTemplate
 * @description: TODO
 * @date 2023-04-21
 * @version: 1.0
 */
@Slf4j
public class SmsTemplate {

    private SmsProperties properties;

    public SmsTemplate(SmsProperties properties) {
        this.properties = properties;
    }

    public void senCode(String phone, String code) {
        try {

//            Config config = new Config()
//                    // 您的AccessKey ID
//                    .setAccessKeyId(properties.getAccessKey())
//                    // 您的AccessKey Secret
//                    .setAccessKeySecret(properties.getSecret())
//                    .setEndpoint("dysmsapi.aliyuncs.com");
//
//            Client client = new Client(config);
//
//            SendSmsRequest sendSmsRequest = new SendSmsRequest()
//                    .setPhoneNumbers(phone) //目标手机号
//                    .setSignName(properties.getSignName()) //签名名称
//                    .setTemplateCode(properties.getTemplateCode()) //短信模板code
//                    .setTemplateParam("{\"code\":\"" + code + "\"}"); //模板中变量替换
//            SendSmsResponse sendSmsResponse = client.sendSms(sendSmsRequest);
//
//            SendSmsResponseBody body = sendSmsResponse.getBody();

//            log.info("ak：{}，sk：{}，sname：{}，tcode：{}",properties.getAccessKey(),properties.getSecret(),properties.getSignName(),properties.getTemplateCode());

            // code = OK 代表成功
            log.info("发送短信，接受短信的手机号：{}，验证码：{}，发送的结果：{}", phone, code, "ok");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
