package org.test.demo2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.test.demo2.entity.UserPassword;

@Mapper
public interface UserPasswordMapper extends BaseMapper<UserPassword> {
}
