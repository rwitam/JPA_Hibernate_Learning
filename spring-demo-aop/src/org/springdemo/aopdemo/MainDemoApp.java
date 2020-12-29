package org.springdemo.aopdemo;

import org.springdemo.aopdemo.dao.AccountDAO;
import org.springdemo.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

	public static void main(String[] args) {
       
		//read spring config java class
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DemoConfig.class);

		//get the bean from spring container
		AccountDAO accountDAO = applicationContext.getBean("accountDAO", AccountDAO.class);
		
		//get membership bean from spring container
		MembershipDAO membershipDAO = applicationContext.getBean("membershipDAO", MembershipDAO.class);
		
		//call the business method
		accountDAO.addAccount();
		
		//call the membership business method
		membershipDAO.addAccount();
		
		//close the context
	    applicationContext.close();
	}

}
