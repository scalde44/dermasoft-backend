package co.edu.usbcali.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BackendDermasoftApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendDermasoftApplication.class, args);
	}

}
