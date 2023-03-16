package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.demo.model.Course;
import hibernate.demo.model.Teacher;
import hibernate.demo.model.TeacherDetails;

public class Read {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
    			.addAnnotatedClass(Teacher.class)
    			.addAnnotatedClass(TeacherDetails.class)
    			.addAnnotatedClass(Course.class)
    			.buildSessionFactory();
    	Session session = sessionFactory.getCurrentSession();
    	try {
    	
	    	Transaction transaction =session.beginTransaction();
	    	Teacher td = session.get(Teacher.class, 1);
	    	System.out.println("Details: "+td);
	    	System.out.println(td.getTeacherDetails());
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
