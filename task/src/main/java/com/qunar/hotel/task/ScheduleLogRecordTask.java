package com.qunar.hotel.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 输出日志定时任务
 *
 * @author: jianyu.lin  Date: 16-7-24.
 */
public class ScheduleLogRecordTask implements Runnable {

    private Logger logger = LoggerFactory.getLogger(ScheduleLogRecordTask.class);

    private String taskName;

    public ScheduleLogRecordTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        logger.info("{} executing, time:{} ", taskName, System.currentTimeMillis());
    }
}
