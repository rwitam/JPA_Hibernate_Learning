package org.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDempApp {

	public static void main(String[] args) {
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach", Coach.class);

		//check if they are same
		boolean result = (theCoach == alphaCoach);
		
		//print the results
		
		System.out.println("\nPointing to the same object "+ result);
		
		System.out.println("\nMemory Location For the theCoach "+theCoach);
		
		System.out.println("\nMemory Location For the alphaCoach "+alphaCoach);
		
		context.close();
	}

}
