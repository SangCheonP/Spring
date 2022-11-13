package com.example.demo;

import com.example.demo.chapter03.used.Greet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args)
				.getBean(DemoApplication.class).excute();
	}

	@Autowired // 생성된 인스턴스를 사용하고 싶은 곳에
	Greet greet;

	private void excute(){
		greet.greeting();
	}
}
