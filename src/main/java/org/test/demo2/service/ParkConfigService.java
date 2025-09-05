package org.test.demo2.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import org.test.demo2.entity.ParkConfig;

import java.util.List;

@Service
public interface ParkConfigService extends IService<ParkConfig> {

    /**
     * 获取停车场配置列表
     * @return
     */
    List<ParkConfig> getParkConfigList();

    List<ParkConfig> getParkConfigList(int pageNum, int pageSize);

    List<ParkConfig> getParkConfigListByName(String parkName);

    int addParkConfig(ParkConfig parkConfig);

    int deleteParkConfigBySn(String parkId);

}
