package org.wikimedia.maps.cassandradumper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.datastax.driver.core.Session;

@SpringBootApplication
@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
public class CassandraDumperApplication {


	public static void main(String[] args) {
		SpringApplication.run(CassandraDumperApplication.class, args);
	}
}
