package pl.policht.smws.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.openSession();
	}
	
	public void save(Object object) {
		getSession().save(object);
	}
	
	public void delete(Object object) {
		getSession().delete(object);
	}
}
