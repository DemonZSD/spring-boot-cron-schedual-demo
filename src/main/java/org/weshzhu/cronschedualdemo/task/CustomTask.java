package org.weshzhu.cronschedualdemo.task;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 使用方式一进行启动定时任务
 *
 * @author by Zhu Shidong
 */
@Configuration
@EnableScheduling
@PropertySource("classpath:application.yaml")
public class CustomTask {
    
    /**
     * 对该方法进行 {@code Scheduled} 进行注解，使得spring能找到该任务
     * @author Zhu Shidong
     */
    @Scheduled(fixedRateString = "${cron-interval}")
    public void work(){
        // TODO do something
        System.out.println("run CustomTask... ");
    }
}
