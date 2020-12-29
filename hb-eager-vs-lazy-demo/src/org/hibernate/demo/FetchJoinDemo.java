package org.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.demo.entity.Course;
import org.hibernate.demo.entity.Instructor;
import org.hibernate.demo.entity.InstructorDetail;
import org.hibernate.query.Query;

public class FetchJoinDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try
		{
		
			//start a transaction
			session.beginTransaction();
			
			//option 2: Hibernate Query with HQL
			
			//get the instructor from db
			int theId = 1;
			
			Query<Instructor> query = session.createQuery("select i from instructor i " 
															+ "JOIN FETCH i.courses "
															+ "where i.id=:theInstructorId",
															Instructor.class);
			//set parameter on query
			query.setParameter("theInstructorId", theId);
			
			//execute query and get instructor
			Instructor tempInstructor = query.getSingleResult();
			System.out.println("App: Instructor: " + tempInstructor);
			
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally
		{
			session.close();
			
			factory.close();
		}
	}

}
