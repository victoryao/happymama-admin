package com.happymama.admin.service;

import com.happymama.admin.dao.StatisticsDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yaoqiang on 2018/5/19.
 */
@Service
public class StatisticsService {

    @Resource
    private StatisticsDao statisticsDao;

    public int getCourseInput(){
        return statisticsDao.getCourseInput();
    }

    public int getOrderInput(){
        return statisticsDao.getOrderInput();
    }
}
