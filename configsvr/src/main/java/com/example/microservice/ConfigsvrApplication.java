package com.example.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer //<-- dong nay khoi tao project se hoat dong nhu mot configServer
public class ConfigsvrApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigsvrApplication.class, args);
	}

}
