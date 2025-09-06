package org.test.demo2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
@TableName("sys_user")
public class UserInfo {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private long id;
    private String realName;
    private String phone;
    //角色：1-超级管理员，2-停车场管理员，3-操作员
    @NotNull
    private Integer role;
    //所属停车场ID（管理员/操作员绑定）
    private String parkingLotSn;
    private String status;
    private String createTime;
    private String updateTime;
}
