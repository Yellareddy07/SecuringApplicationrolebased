package com.example.SecuringApplicationrolebased;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SecuringApplicationrolebasedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuringApplicationrolebasedApplication.class, args);


		//prtinting the hash password to console
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		System.out.println(encoder.encode("password"));
	}

}
