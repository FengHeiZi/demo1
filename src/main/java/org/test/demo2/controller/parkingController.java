package org.test.demo2.controller;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
        if (parkName == null||parkName.isEmpty()){
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

    /**
     * 添加车场
     * @param data
     * @return
     */
    @PostMapping("/addParkConfig")
    public R addParkConfig(@RequestBody ParkConfig data){
        int i = parkConfigService.addParkConfig(data);
        if (i == 0){
            return R.error().message("请求失败");
        }
        return R.ok();
    }

    /**
     * 删除车场
     * @param lotSn
     * @return
     */
    @PostMapping("/deleteParkConfigBySn")
    public R deleteParkConfigBySn(@RequestParam String lotSn){
        int i = parkConfigService.deleteParkConfigBySn(lotSn);
        if (i == 0){
            return R.error().message("请求失败");
        }
        return R.ok();
    }

}
