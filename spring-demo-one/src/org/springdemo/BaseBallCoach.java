package org.springdemo;

public class BaseBallCoach implements Coach {
	
	//define private field for the dependency
	private FortuneService fortuneService;
	
	
	//define constructor for dependency injetcion
	public BaseBallCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkOut()
	{
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		//use fortune service to get a fortune
		return fortuneService.getFortune();
	}

}
