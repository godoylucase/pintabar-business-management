package com.pintabar.businessmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Lucas.Godoy on 29/08/17.
 */
@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages = "com.pintabar")
public class PintabarBusinessManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PintabarBusinessManagementApplication.class, args);
	}

}
