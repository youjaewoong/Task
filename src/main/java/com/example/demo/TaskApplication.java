package com.example.demo;

import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@SpringBootApplication
public class TaskApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {

	}

	@PreDestroy
	public void closeApp() {
	}
}
