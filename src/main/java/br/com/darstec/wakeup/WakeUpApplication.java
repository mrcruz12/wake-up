package br.com.darstec.wakeup;

import br.com.darstec.wakeup.scheduling.SchedulingTask;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WakeUpApplication {

	public static void main(String[] args) {
		SpringApplication.run(WakeUpApplication.class, args);

		SchedulingTask scheduling = new SchedulingTask();
		scheduling.scheduleFutureTask();
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
