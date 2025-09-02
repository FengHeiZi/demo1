package org.test.demo2.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName("parking_lot")
public class ParkConfig {
    @TableField("id")
    private long parkId;
    @TableField("name")
    private String parkName;
    private String lotSn;
    private String address;
    // 车位总数
    private Integer totalSpaces;
    // 可用车位
    private Integer availableSpaces;
    // 联系人
    private String contactPerson;
    // 联系电话
    private String contactPhone;
    //经度
    private String lng;
    // 纬度
    private String lat;
    // 状态
    private String status;
    private String createTime;
    private String updateTime;
}
