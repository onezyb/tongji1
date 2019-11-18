package com.zyb.tjpkg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;


/**
 * @ClassName: Application
 * @Description: TODO
 */
// @SpringBootApplication
// @MapperScan(basePackages = "com.ixinnuo.api.mapper")
// public class Application {
//
// public static void main(String[] args) {
// SpringApplication.run(Application.class, args);
// }
// }

@SpringBootApplication
@MapperScan(basePackages = "com.zyb.tjpkg.mapper")
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		System.out.println("Tappppppppppppppppppppppppppp1");
		return application.sources(Application.class);
	}

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

		return  restTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
