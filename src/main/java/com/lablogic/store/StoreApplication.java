package com.lablogic.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class StoreApplication
{
	public static void main(String[] args)
	{
		System.setProperty("spring.datasource.username", args[0]);
		System.setProperty("spring.datasource.password", args[1]);

		SpringApplication.run(StoreApplication.class, args);
	}
}
