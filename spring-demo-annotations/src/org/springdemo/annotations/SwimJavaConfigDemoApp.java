package org.springdemo.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		//get bean from spring container
		SwimCoach coach = context.getBean("swimCoach",SwimCoach.class);
		
		//calling methods on the bean
		System.out.println(coach.getDailyWorkout());
		
		System.out.println(coach.getDailyFortune());
		
		//call our new swim coach methods ... has the props values injected
		System.out.println("email "+coach.getEmail());
		
		System.out.println("team "+coach.getTeam());
		
		//closing context
		context.close();
		
	}

}
