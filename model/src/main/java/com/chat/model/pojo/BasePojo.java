package com.chat.model.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Td
 * @ClassName BasePojo
 * @description: 基础模型类
 * @date 2023-04-21
 * @version: 1.0
 */
@Data
public class BasePojo implements Serializable {

    @TableField(fill = FieldFill.INSERT) //自动填充
    private Date created;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updated;
}
