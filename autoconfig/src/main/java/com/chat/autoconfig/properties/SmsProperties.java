package com.chat.autoconfig.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Td
 * @ClassName SmsProperties
 * @description: TODO
 * @date 2023-04-21
 * @version: 1.0
 */

@Data
@ConfigurationProperties("chat.sms")
public class SmsProperties {

    private String signName;
    private String templateCode;
    private String accessKey;
    private String secret;

}
