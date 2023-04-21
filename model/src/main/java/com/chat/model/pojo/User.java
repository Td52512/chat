package com.chat.model.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @TableName tb_user
 */
@TableName(value = "tb_user")
@Data
public class User extends BasePojo {
    private Long id;

    private String mobile;

    private String password;

    private String hxUser;

    private String hxPassword;

    private static final long serialVersionUID = 1L;
}