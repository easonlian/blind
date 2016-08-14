package com.qunar.hotel.task;

import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 测试日期输出类
 *
 * @author: jianyu.lin  Date: 16-7-25.
 */
public class ScheduleLogRecordTaskTest {

    /**
     * 日志记录工具
     * @throws Exception 异常
     */
    @Test
    public void recordLog() throws Exception {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
        for (int i = 0; i < 2; i++) {
            service.scheduleWithFixedDelay(new ScheduleLogRecordTask("task_" + i), 0, 3, TimeUnit.SECONDS);
            Thread.sleep(1000);
        }
        System.in.read();
    }
}
