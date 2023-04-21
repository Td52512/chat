package com.chat.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Td
 * @ClassName AppServerApplication
 * @description: TODO
 * @date 2023-04-21
 * @version: 1.0
 */
@SpringBootApplication
@Slf4j
public class AppServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppServerApplication.class,args);
        log.info("服务器启动成功");

    }
}
