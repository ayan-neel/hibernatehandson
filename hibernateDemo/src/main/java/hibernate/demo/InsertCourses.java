package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.model.Course;
import hibernate.demo.model.Teacher;
import hibernate.demo.model.TeacherDetails;

public class InsertCourses {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Teacher.class).
				addAnnotatedClass(Course.class).
				addAnnotatedClass(TeacherDetails.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
		session.beginTransaction();
		
		int teacherId=1;
		//get teacher object
		Teacher teacher = session.get(Teacher.class,teacherId);
		
		Course course1 = new Course("JS100","JavaScript-Beginner");
		Course course2 = new Course("JS200","JavaScript-Advanced");
		
		//course1.setTeacher(teacher);
		//course2.setTeacher(teacher);  //this piece of code adds the reference of teacher id in course table*/
		
		teacher.add(course1); //this is not adding the reference
		teacher.add(course2);
		
		session.persist(course1);
		session.persist(course2);
		session.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
