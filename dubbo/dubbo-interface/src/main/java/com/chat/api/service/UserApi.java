package com.chat.api.service;

import com.chat.model.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 陈文杰
* @description 针对表【tb_user(用户表)】的数据库操作Service
* @createDate 2023-04-21 19:50:59
*/
public interface UserApi extends IService<User> {

    User findUserByPhone(String phone);

    Long registration(User user);

}
