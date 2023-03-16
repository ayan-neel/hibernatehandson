package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.demo.model.Teacher;
import hibernate.demo.model.TeacherDetails;

public class Delete {
	public static void main(String [] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
    			.addAnnotatedClass(Teacher.class)
    			.addAnnotatedClass(TeacherDetails.class)
    			.buildSessionFactory();
    	Session session = sessionFactory.getCurrentSession();
    	try {
    	
	    	Transaction transaction =session.beginTransaction();
	    	TeacherDetails td = session.get(TeacherDetails.class, 3);
	    	session.delete(td);
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

