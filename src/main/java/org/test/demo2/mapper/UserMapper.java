package org.test.demo2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.test.demo2.entity.UserInfo;

@Mapper
public interface UserMapper extends BaseMapper<UserInfo> {


    int updateUserInfo(UserInfo userInfo);

    int updateUserInfoByAdmin(UserInfo userInfo);
}
