package org.springdemo.annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	FortuneService fortineService;
	
	//define a default constructor
	public TennisCoach()
	{
		System.out.println("inside default constructor");
	}
	
	//define my init method
	@PostConstruct
	public void doMyStartUpStuff()
	{
		System.out.println(">> TennisCoach: inside of doMyStartUpStuff()");
	}
	
	//define my destroy method
	@PreDestroy
	public void doMyCleanUpStuff()
	{
		System.out.println(">> TennisCoach: inside of doMyCleanUpStuff()");
	}
	
	
	@Autowired
	public void setFortineService(FortuneService fortineService) {
		System.out.println("inside setFortuneService() method");
		this.fortineService = fortineService;
	}
	
	/*
	 * @Autowired public TennisCoach(FortuneService fortineService) { super();
	 * this.fortineService = fortineService; }
	 */





	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortineService.getFortune();
	}

}
