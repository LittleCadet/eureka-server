package com.myproj.app.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author LittleCadet
 * @Date 2019/8/17
 */
@Slf4j
@Service
public class TestServiceImpl implements TestService
{

    @Override
    public String showInfo()
    {
        log.info("======================succeed to go inside:version 1=============================");
        return "succeed:version 1";
    }
}
