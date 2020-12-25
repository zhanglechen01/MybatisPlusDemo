package com.yitao.notice;

//import com.yitao.utils.exception.GlobalExceptionHandler;
import com.yitao.utils.exception.GlobalExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class NoticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoticeApplication.class, args);
	}

	/**
	 * 启用统一异常拦截
	 * @return
	 */
	@Bean
	GlobalExceptionHandler GlobalExceptionHandler(){
		return new GlobalExceptionHandler();
	}
}
