package com.web;

import com.dao.PlayerLogRepository;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/1/5 0005.
 */
@RestController
public class HelloController {
    @Autowired
    private PlayerLogRepository logRepository;

    @GetMapping("/noteLog/{pid}")
    public String playerLogs(@PathVariable(value = "pid") Integer pid) {
        return "pid:" + pid;
//        return playerLogRepository.findAll();
    }
//    @GetMapping("/{pid}")
//    public String playerLogs(@RequestParam(value = "pid",required = false,defaultValue = "0")Integer pid) {
//        return "pid:" + pid;
////        return playerLogRepository.findAll();
//    }
}
