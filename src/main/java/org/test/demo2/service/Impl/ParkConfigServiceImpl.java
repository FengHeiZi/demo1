package org.test.demo2.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.demo2.entity.ParkConfig;
import org.test.demo2.mapper.ParkConfigMapper;
import org.test.demo2.service.ParkConfigService;

import java.util.List;

@Service
@Slf4j
public class ParkConfigServiceImpl extends ServiceImpl<ParkConfigMapper, ParkConfig> implements ParkConfigService {
    @Autowired
    ParkConfigMapper parkConfigMapper;

    @Override
    public List<ParkConfig> getParkConfigList() {
        List<ParkConfig> parkConfigList = parkConfigMapper.selectParkConfigList();
        return parkConfigList;
    }

    @Override
    public List<ParkConfig> getParkConfigList(int pageNum, int pageSize) {
        Page<ParkConfig> page = new Page<>(pageNum, pageSize);

        Page<ParkConfig> parkConfigPage = parkConfigMapper.selectPage(page, null);
        return parkConfigPage.getRecords();

    }

    @Override
    public List<ParkConfig> getParkConfigListByName(String parkName) {
        List<ParkConfig> parkConfigList = parkConfigMapper.selectParkConfigListByName(parkName);
        return parkConfigList;
    }

}
