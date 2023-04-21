package com.chat.server.service.impl;

import cn.hutool.crypto.digest.DigestUtil;
import com.chat.api.service.UserApi;
import com.chat.autoconfig.template.SmsTemplate;
import com.chat.model.pojo.User;
import com.chat.server.service.UserService;
import com.chat.util.JwtUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Td
 * @ClassName UserServiceImpl
 * @description: TODO
 * @date 2023-04-21
 * @version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SmsTemplate smsTemplate;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @DubboReference
    private UserApi userApi;


    @Override
    public void sendCode(String phone) {

        //生成验证码
        String code = RandomStringUtils.randomNumeric(6);

        //发送验证码
        smsTemplate.senCode(phone, code);

        //将验证码存入redis
        redisTemplate.opsForValue().set("CHECK:CODE:" + phone, code, Duration.ofMinutes(5));

    }

    @Override
    public Map<String, Object> login(String phone, String code) {
        //校验验证码
        String redisCode = redisTemplate.opsForValue().get("CHECK:CODE:" + phone);
        if (StringUtils.isEmpty(redisCode) || !redisCode.equals(code)) {
            throw new RuntimeException("验证码错误");
        }

        //删除验证码
        redisTemplate.delete("CHECK:CODE:" + phone);

        //查询用户
        User user = userApi.findUserByPhone(phone);

        //新用户
        if (user == null) {
            //注册用户
            user = new User();
            user.setMobile(phone);
            user.setPassword(DigestUtil.md5Hex("123456"));
            Long id = userApi.registration(user);
            user.setId(id);
        }

        Long id = user.getId();
        HashMap<String, Object> data = new HashMap<>();
        data.put("id", id);
        data.put("mobile", phone);

        //生成jwt
        String token = JwtUtils.getToken(data);

        HashMap<String, Object> result = new HashMap<>();
        result.put("token", token);
        result.put("isNew", false);

        return result;
    }
}
