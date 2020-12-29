package org.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.demo.entity.Course;
import org.hibernate.demo.entity.Instructor;
import org.hibernate.demo.entity.InstructorDetail;
import org.hibernate.demo.entity.Review;

public class CreateCoursesAndReviewsDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try
		{
		
			//start a transaction
			session.beginTransaction();
			
			//create a course
			Course tempCourse = new Course("Pacman - How To Score One <illion Points");
			
			//add some reviews
			tempCourse.addReview(new Review("Greate course ... loved if!"));
			tempCourse.addReview(new Review("Cool course, job well done"));
			tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));
			
			
			//save the course ... and leverage the cascade all :-)
			System.out.println("Saving the course");
			session.save(tempCourse);
			System.out.println(tempCourse.getReviews());
			
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
