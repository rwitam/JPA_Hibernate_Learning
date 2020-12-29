package org.springdemo.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("org.springdemo.annotations")
@PropertySource("classpath:sport.properties")
public class SportConfig {

	//define a bean for our sad fortune service
	@Bean
	public FortuneService sadFortuneService()
	{
		return new SadFortuneService();
	}

	//define a bean for our swim coach and inject dependency
	@Bean
	public Coach swimCoach()
	{
		return new SwimCoach(sadFortuneService());
	}
}
