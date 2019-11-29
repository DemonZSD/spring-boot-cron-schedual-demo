package org.weshzhu.cronschedualdemo.task;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.PeriodicTrigger;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 通过实现 SchedulingConfigurer 进行定时任务的执行
 *
 * @author by Zhu Shidong
 */
@Configuration
@EnableScheduling
public class CustomTaskAlternate implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        // 注册Runner对象，以及Trigger对象
        scheduledTaskRegistrar.addTriggerTask(new TaskRunner(),
                triggerContext -> new PeriodicTrigger(1000, TimeUnit.MILLISECONDS)
                        .nextExecutionTime(triggerContext));
    }
}
