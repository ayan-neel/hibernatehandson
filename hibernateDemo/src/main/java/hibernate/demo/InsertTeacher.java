package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.demo.model.Course;
import hibernate.demo.model.Review;
import hibernate.demo.model.Teacher;
import hibernate.demo.model.TeacherDetails;
/**
 * Hello world!
 *
 */
public class InsertTeacher 
{
    public static void main( String[] args )
    {
    	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
    			.addAnnotatedClass(Teacher.class)
    			.addAnnotatedClass(TeacherDetails.class)
    			.addAnnotatedClass(Course.class)
    			.addAnnotatedClass(Review.class)
    			.buildSessionFactory();
    	Session session = sessionFactory.getCurrentSession();
    	try {
    	
	    	Transaction transaction =session.beginTransaction();
	    	Teacher t = new Teacher("Ayan","Medhi","ayan@gmail.com");
	    	TeacherDetails details = new TeacherDetails("Ghy","Music");
	    	//details.setTeacher(t); //you cannot do this because Teacher is the owner not Teacher Details
	    	t.setTeacherDetails(details);	
	    	session.persist(t);
	    	transaction.commit();
    	}
    	catch (Exception e){
    		e.printStackTrace();
    		
    	}
    	finally
    	{
    		session.close();
    		sessionFactory.close();
    	}
    	
    }
}
