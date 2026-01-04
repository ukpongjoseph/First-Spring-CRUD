package dev.joseph.springdemo;

// import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringdemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext appContext = SpringApplication.run(SpringdemoApplication.class, args);
		// Arrays.stream(appContext.getBeanDefinitionNames()).forEach(System.out::println);
		Object bean = appContext.getBean("restDefined");
		Object bean1 = appContext.getBean("restTemplate");
		System.out.println(bean1);
		System.out.println(bean);
	}

}
