package com.prajeeth.crud_thymeleaf_springboot.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PassGen {
    public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		System.out.println(encoder.encode("admin"));
		System.out.println(encoder.encode("editor"));
        System.out.println(encoder.encode("user"));
	}
    
}
