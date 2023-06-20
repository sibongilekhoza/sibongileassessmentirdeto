package com.irdeto.sibongileassessment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.irdeto.sibongileassessment")
public class SibongileassessmentApplication {

	public static void main(String[] args) throws FileNotFoundException {
			
		SpringApplication.run(SibongileassessmentApplication.class, args);
	}

}
