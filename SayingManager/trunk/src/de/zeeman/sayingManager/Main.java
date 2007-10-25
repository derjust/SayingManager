package de.zeeman.sayingManager;

import java.util.List;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import de.zeeman.sayingManager.data.Saying;
import de.zeeman.sayingManager.util.HibernateUtil;


public class Main {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Logger aLogger = Logger.getRootLogger();
		Layout systemLoggingLayout = new PatternLayout("[%t:%C]: %m%n");
		
		ConsoleAppender consoleAppender = new ConsoleAppender(systemLoggingLayout);
		aLogger.addAppender(consoleAppender);

		Session s = HibernateUtil.getSessionFactory().openSession();
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<");

//		Query q = s.createQuery("from Author");
//		List result = q.list();
		
		Criteria crit = s.createCriteria(Saying.class)
			.add( Restrictions.ge("id", 0));
		
		List result = crit.list();
	  
		for(Object o : result) {
			System.out.println(o.toString());
		}
		
		s.close();
	
	}

}
