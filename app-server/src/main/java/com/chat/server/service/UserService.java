package com.chat.server.service;

import java.util.Map;

public interface UserService {
    void sendCode(String phone);

    Map<String, Object> login(String phone, String code);
}
