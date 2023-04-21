package com.chat.server.test;

import com.chat.server.AppServerApplication;
import com.chat.autoconfig.template.SmsTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Td
 * @ClassName ApplicationTest
 * @description: TODO
 * @date 2023-04-21
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppServerApplication.class)
public class SmsTemplateTest {

    @Autowired
    private SmsTemplate smsTemplate;

    @Test
    public void testSendCode(){
        smsTemplate.senCode("123","1234");

    }
}
