package com.renuka.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@RestController
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@RequestMapping(path = "/hello", method = RequestMethod.POST)
	public ResponseEntity<HelloDTO> hello(@RequestBody RequestDTO requestDTO) {
		try {
			Thread.sleep(requestDTO.getInterval());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		HelloDTO hello = new HelloDTO();
		hello.setHello("Hello Renuka");
		return ResponseEntity.status(requestDTO.getHttpStatus()).body(hello);
	}
}
