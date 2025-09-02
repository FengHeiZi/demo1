package org.test.demo2.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.demo2.entity.ParkConfig;
import org.test.demo2.mapper.ParkConfigMapper;
import org.test.demo2.service.ParkConfigService;

import java.util.List;

@Service
public class ParkConfigServiceImpl extends ServiceImpl<ParkConfigMapper, ParkConfig> implements ParkConfigService {
    @Autowired
    ParkConfigMapper parkConfigMapper;

    @Override
    public List<ParkConfig> getParkConfigList() {
        List<ParkConfig> parkConfigList = parkConfigMapper.selectParkConfigList();
        return parkConfigList;
    }
}
