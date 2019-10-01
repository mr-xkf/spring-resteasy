package com.example.nettyweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class NettyWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(NettyWebApplication.class, args);
	}

}
