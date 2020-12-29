package org.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.demo.entity.Instructor;
import org.hibernate.demo.entity.InstructorDetail;
import org.hibernate.demo.entity.Student;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try
		{
		
			//start a transaction
			session.beginTransaction();
			int theId = 2;
			InstructorDetail tempInstructorDetail = 
					session.get(InstructorDetail.class, theId);
			
			System.out.println("tempInstructorDetail: " + tempInstructorDetail);
			
			System.out.println("The associated instructor " +
											tempInstructorDetail.getInstructor());
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			//handle connection leak issue
			session.close();
			
			factory.close();
		}
	}

}
