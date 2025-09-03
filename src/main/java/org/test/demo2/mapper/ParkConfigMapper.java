package org.test.demo2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.test.demo2.entity.ParkConfig;

import java.util.List;

@Mapper
public interface ParkConfigMapper extends BaseMapper<ParkConfig> {

    List<ParkConfig> selectParkConfigList();

    List<ParkConfig> selectParkConfigListByName(String parkName);
}
