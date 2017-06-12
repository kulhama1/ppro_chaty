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
import org.hibernate.criterion.Restrictions;
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
        return this.sessionFactory.getCurrentSession().createCriteria(Cottage.class).list();
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
		Cottage cottage = (Cottage) sessionFactory.getCurrentSession().load(Cottage.class, id);
        if (null != cottage) {
            cottage.setGroup(null);
            cottage.setGallery(null);
            this.sessionFactory.getCurrentSession().delete(cottage);
        }
	}

    public List<Cottage> getCottagesByRow(String row, String operand , String stringArray) {
        return this.sessionFactory.getCurrentSession().createCriteria(Cottage.class).add(Restrictions.sqlRestriction(row + " " + operand + " (" + stringArray + ")")).list();  
    }

    public void updateMultipleCottages(List<Cottage> cottages) {
        try {
            for(Cottage cottage : cottages) { 
                this.sessionFactory.getCurrentSession().update(cottage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
