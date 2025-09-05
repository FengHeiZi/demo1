package org.test.demo2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_password")
public class UserPassword {
    @TableId(value = "id", type = IdType.AUTO)
    private long id;
    private String username;
    private String password;
    private String userId;
}
