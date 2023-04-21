package com.chat.db.api.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chat.api.service.UserApi;
import com.chat.db.mapper.TbUserMapper;
import com.chat.model.pojo.User;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 陈文杰
 * @description 针对表【tb_user(用户表)】的数据库操作Service实现
 * @createDate 2023-04-21 19:50:59
 */
@DubboService
public class UserApiImpl extends ServiceImpl<TbUserMapper, User>
        implements UserApi {

    @Autowired
    private TbUserMapper userMapper;

    @Override
    public User findUserByPhone(String phone) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        return userMapper.selectOne(wrapper.eq(User::getMobile, phone));
    }

    @Override
    public Long registration(User user) {
        userMapper.insert(user);
        return user.getId();
    }
}




