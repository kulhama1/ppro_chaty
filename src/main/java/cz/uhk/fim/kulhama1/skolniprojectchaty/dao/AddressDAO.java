/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.uhk.fim.kulhama1.skolniprojectchaty.dao;

import cz.uhk.fim.kulhama1.skolniprojectchaty.model.Address;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDAO{

    @Autowired
    SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    public List<Address> getAllAddresses() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Address> addressList = session.createQuery("from Address").list();
        return addressList;
    }
    
    public Address getAddress(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Address address = (Address) session.get(Address.class, new Integer(id));
		return address;
	}
    public Address addAddress(Address address) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(address);
		return address;
	}

    public void updateAddress(Address address) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(address);
	}

    
    public void deleteAddress(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Address a = (Address) session.load(Address.class, new Integer(id));
		if (null != a) {
			session.delete(a);
		}
	}  
}
