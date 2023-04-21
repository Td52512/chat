package com.chat.server.controller;

import com.alibaba.fastjson.JSON;
import com.chat.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Td
 * @ClassName LoginController
 * @description: 登陆接口
 * @date 2023-04-21
 * @version: 1.0
 */
@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * @param map 接收请求参数
     *            根据手机号发送登陆验证码
     */
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> sendCode(@RequestBody Map<String, String> map) {
        String phone = map.get("phone");

        userService.sendCode(phone);
        HashMap<String, String> result = new HashMap<>();
        result.put("status", "200");
        result.put("msg", "success");
        return ResponseEntity.ok(result);
    }

    @PostMapping("/loginVerification")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> param) {
        String phone = param.get("phone");
        String code = param.get("verificationCode");
        Map<String, Object> result = userService.login(phone, code);

        return ResponseEntity.ok(result);
    }
}
