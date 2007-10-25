package de.zeeman.sayingManager.data;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import de.zeeman.sayingManager.util.HibernateUtil;

public class DataController implements DataListener {

	public DataController() {
		
	}
	
	@Override
	public void addAuthor(Author newAuthor) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.getTransaction();
		s.save(s.merge(newAuthor));
		s.getTransaction().commit();
		s.close();
	}

	@Override
	public void addSaying(Saying newSaying) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.getTransaction();
		s.save(s.merge(newSaying));
		s.getTransaction().commit();
		s.close();
	}

	@Override
	public Saying getRandomSaying() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Saying> search(Saying searchDummy) {
		Session s = HibernateUtil.getSessionFactory().openSession();
	
		Criteria crit = s.createCriteria(Saying.class);		

		if (searchDummy != null) {
			if (searchDummy.getId() != 0) {
				crit.add(Restrictions.eq("id", searchDummy.getId()));
			}
			if ((searchDummy.getSaying() != null) && (searchDummy.getSaying().length() > 0)) {
				crit.add(Restrictions.like("saying", "%"+searchDummy.getSaying()+"%"));
			}
			if (searchDummy.getAuthor() != null) {
				crit.add(Restrictions.eq("author", searchDummy.getAuthor()));
			}			
		}
		
		return crit.list();
	}


	
}
