package cz.uhk.fim.kulhama1.skolniprojectchaty.dao;

import cz.uhk.fim.kulhama1.skolniprojectchaty.model.Group;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GroupDAO{

    @Autowired
    SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    public List<Group> getAllGroups() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Group> groupList = session.createQuery("from Group").list();
        return groupList;
    }
    
    public Group getGroup(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Group group = (Group) session.get(Group.class, new Integer(id));
		return group;
	}
    public Group addGroup(Group group) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(group);
		return group;
	}

    public void updateGroup(Group group) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(group);
	}

    
    public void deleteGroup(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Group g = (Group) session.load(Group.class, new Integer(id));
		if (null != g) {
			session.delete(g);
		}
	}
    
}
