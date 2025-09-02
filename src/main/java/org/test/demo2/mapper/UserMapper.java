package org.test.demo2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.test.demo2.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
