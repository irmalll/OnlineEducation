package com.yucheng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class Application {

	public static void main(String[] args) {
		//System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(Application.class, args);
		System.out.println("启动完成----");
	
	}
}

