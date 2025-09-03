package org.test.demo2.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.test.demo2.entity.ParkConfig;
import org.test.demo2.service.ParkConfigService;
import org.test.demo2.utils.R;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/parking")
public class parkingController {

    @Autowired
    ParkConfigService parkConfigService;

    @PostMapping("/getParkConfigList")
    public R getParkConfigList() {
        List<ParkConfig> parkConfigList = parkConfigService.getParkConfigList();
        return R.ok().data(parkConfigList);
    }

    /**
     * 查找车场by name
     * @param parkName
     */
    @PostMapping("/getParkConfigByName")
    public R getParkConfigByName(@RequestParam String parkName) {
        if (parkName == null||parkName.equals(" ")){
            return R.error().message("车场名称为空");
        }
        List<ParkConfig> parkConfig= parkConfigService.getParkConfigListByName(parkName);
        return R.ok().data(parkConfig);
    }

    /**
     * 分页查询车场列表
     * @param page
     * @param size
     * @return ParkConfig
     */
    @PostMapping("/getParkConfigByPage")
    public R getParkConfigByPage(@RequestParam(required = false) int page,
                                 @RequestParam(required = false) int size){
        log.info("pageNum: {}, pageSize: {}", page, size);
        List<ParkConfig> parkConfigList = parkConfigService.getParkConfigList(page, size);
        return R.ok().data(parkConfigList);
    }
}
