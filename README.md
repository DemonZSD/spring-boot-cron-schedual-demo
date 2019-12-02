> 借助spring-boot 启动定时任务
1. 方式一
```java
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

```
2. 方式二: 通过实现 SchedulingConfigurer 接口完成动态定时任务
```java
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
```