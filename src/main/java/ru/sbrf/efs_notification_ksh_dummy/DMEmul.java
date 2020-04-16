package ru.sbrf.efs_notification_ksh_dummy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:context.xml")
public class DMEmul {

	public static void main(String[] args) {
		SpringApplication.run(DMEmul.class, args);
	}
}
