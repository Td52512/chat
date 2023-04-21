package com.chat.db;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Td
 * @ClassName DbApplication
 * @description: 数据库启动类
 * @date 2023-04-21
 * @version: 1.0
 */
@Slf4j
@SpringBootApplication
@MapperScan("com.chat.db.mapper")
public class DbApplication {
    public static void main(String[] args) {
        SpringApplication.run(DbApplication.class, args);
        log.info("数据库服务启动成功");
    }
}
