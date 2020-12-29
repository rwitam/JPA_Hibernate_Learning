package org.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.demo.entity.Instructor;
import org.hibernate.demo.entity.InstructorDetail;
import org.hibernate.demo.entity.Student;

public class CreateDemo {

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
			//create the objects
			Instructor tempInstructor = 
					new Instructor("Chad", "Darby", "darby@gmail.com");
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail("http://www.example.com/youtube",
							"Coding");
			
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//start a transaction
			session.beginTransaction();
			
			//save the instructor
			//This will also save the details object
			//because of CascadeType.ALL
			System.out.println("Saving Instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally
		{
			factory.close();
		}
	}

}
