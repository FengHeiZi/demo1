package org.test.demo2.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_user")
public class User {
    private long id;
    private String username;
    private String password;
    private String realName;
    private String phone;
    //角色：1-超级管理员，2-停车场管理员，3-操作员
    private int role;
    //所属停车场ID（管理员/操作员绑定）
    private String parkingLotId;
    private String status;
    private String createTime;
    private String updateTime;
}
