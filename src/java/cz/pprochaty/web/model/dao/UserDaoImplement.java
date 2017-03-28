
package cz.pprochaty.web.model.dao;

import cz.pprochaty.web.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserDaoImplement implements UserDAO{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public User getUserById(int id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
       return this.sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }

    @Override
    public void deleteUser(Integer user_id) {
        User user = (User) sessionFactory.getCurrentSession().load(User.class, user_id);
        if (null != user){
            this.sessionFactory.getCurrentSession().delete(user);
        }
    }

    @Override
    public void addUser(User user) {
        this.sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void updateUser(User user) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public User getUserByLogin(String login) {
       return (User) sessionFactory.getCurrentSession().load(User.class, login);
    }

    @Override
    @SuppressWarnings("unchecked")
    public User getUserByUserName(String login) {
        List<User> users = new ArrayList<User>();
        users = sessionFactory.getCurrentSession().createQuery("from User where login=?").setParameter(0, login).list();
                if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}
    
}
