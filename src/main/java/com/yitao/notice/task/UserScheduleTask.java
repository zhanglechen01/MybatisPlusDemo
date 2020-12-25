package com.yitao.notice.task;

import com.yitao.notice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@EnableScheduling   // 1.开启定时任务
@EnableAsync        // 2.开启多线程
public class UserScheduleTask {
	@Autowired
	private UserService userService;
	@Async
	//@Scheduled(fixedDelay = 1000*60*60*24)  //间隔1天执行一次
	@Scheduled(cron = "0 0 1 * * ?")  //每天凌晨1点执行一次
	public void first() throws InterruptedException {
		userService.getExpireData();
	}

}
