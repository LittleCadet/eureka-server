package com.myproj.app.controller;

import com.myproj.app.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author LittleCadet
 * @Date 2019/8/17
 */
@RestController
@RequestMapping("/eureka")
public class TestController
{
    @Autowired
    private TestService testService;

    @GetMapping("/client")
    public String showInfo(){
        return testService.showInfo();
    }



}
