package com.chat.server.test;

import com.chat.api.service.UserApi;
import com.chat.server.AppServerApplication;
import com.chat.server.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Td
 * @ClassName UserMapperTest
 * @description: TODO
 * @date 2023-04-21
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppServerApplication.class)
public class UserMapperTest {
    @DubboReference
    private UserApi userApi;

    @Test
    public void userTest(){
        System.out.println(userApi.findUserByPhone("13500000000"));
    }
}
