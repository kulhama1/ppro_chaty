/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.uhk.fim.kulhama1.skolniprojectchaty.dao;

import cz.uhk.fim.kulhama1.skolniprojectchaty.model.Cottage;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CottageDAO{

    @Autowired
    SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    public List<Cottage> getAllCottages() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Cottage> cottageList = session.createQuery("from Cottage").list();
        return cottageList;
    }
    
    public Cottage getCottage(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Cottage cottage = (Cottage) session.get(Cottage.class, new Integer(id));
		return cottage;
	}
    public void addCottage(Cottage cottage) {
		this.sessionFactory.getCurrentSession().save(cottage);
	}

    public void updateCottage(Cottage cottage) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(cottage);
	}

    
    public void deleteCottage(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Cottage c = (Cottage) session.load(Cottage.class, new Integer(id));
		if (null != c) {
			session.delete(c);
		}
	}
}
