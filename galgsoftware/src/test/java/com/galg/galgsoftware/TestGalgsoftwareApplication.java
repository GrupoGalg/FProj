package com.galg.galgsoftware;

import org.springframework.boot.SpringApplication;

public class TestGalgsoftwareApplication {

	public static void main(String[] args) {
		SpringApplication.from(GalgsoftwareApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
