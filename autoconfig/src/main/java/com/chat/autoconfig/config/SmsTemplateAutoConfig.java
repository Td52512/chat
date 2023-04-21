package com.chat.autoconfig.config;

import com.chat.autoconfig.properties.SmsProperties;
import com.chat.autoconfig.template.SmsTemplate;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author Td
 * @ClassName SmsTemplateAutoConfig
 * @description: TODO
 * @date 2023-04-21
 * @version: 1.0
 */
@EnableConfigurationProperties({
        SmsProperties.class
})
public class SmsTemplateAutoConfig {

    @Bean
    public SmsTemplate smsTemplate(SmsProperties smsProperties) {
        return new SmsTemplate(smsProperties);
    }

}
