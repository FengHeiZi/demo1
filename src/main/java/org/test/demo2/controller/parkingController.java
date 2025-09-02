package org.test.demo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.test.demo2.entity.ParkConfig;
import org.test.demo2.service.ParkConfigService;
import org.test.demo2.utils.R;

import java.util.ArrayList;
import java.util.List;

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
}
