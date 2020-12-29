package org.springdemo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//this is where we add all of our related advices for logging
	
	@Before("execution(public void org.springdemo.aopdemo.dao.AccountDAO.addAccount())")
	public void beforeAddAccountAdvice()
	{
		System.out.println("\n=====> Executing @Before advice on addAccount()");
	}
	
}


//PointCut Expression Language
//execution(modifiers-pattern? return-type-patter declaring-type-pattern?
          //method-name-pattern(param-pattern) throws-pattern?)