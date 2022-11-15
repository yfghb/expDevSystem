package com.software_design.schedule;

import com.software_design.controller.DeviceController;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 计时任务，每隔1分钟清除一次缓存
 */
@Component
public class CacheClearTask {
    private static final SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss");
    @Resource
    private DeviceController deviceController;

    @Async
    @Scheduled(cron = "0 10 * * * ?")
    public void devInCacheTask(){
        deviceController.clearDevIn();
        System.out.println("开始定时任务 : 清空缓存，现在时间：" + f.format(new Date()));
    }

    @Async
    @Scheduled(cron = "0 10 * * * ?")
    public void devOutCacheTask(){
        deviceController.clearDevOut();
        System.out.println("开始定时任务 : 清空缓存，现在时间：" + f.format(new Date()));
    }

    @Async
    @Scheduled(cron = "0 10 * * * ?")
    public void devStatusCacheTask(){
        deviceController.clearDevStatus();
        System.out.println("开始定时任务 : 清空缓存，现在时间：" + f.format(new Date()));
    }
}
