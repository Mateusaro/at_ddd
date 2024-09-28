package com.example.emprestimos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmprestimosApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmprestimosApplication.class, args);
	}

}
