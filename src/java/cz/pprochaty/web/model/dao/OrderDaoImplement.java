
package cz.pprochaty.web.model.dao;

import cz.pprochaty.web.model.Order;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class OrderDaoImplement implements OrderDAO{

    @Autowired
    SessionFactory sessionFactory;
    
    @Override
    public Order getOrderById(int id) {
        return (Order) sessionFactory.getCurrentSession().load(Order.class, id);
    }

    @Override
    public void deleteOrder(Order order_id) {
        Order order = (Order) sessionFactory.getCurrentSession().load(Order.class, order_id);
        if(null != order){
            this.sessionFactory.getCurrentSession().delete(order);
        }
    }

    @Override
    public void updateOrder(Order order) {
        this.sessionFactory.getCurrentSession().update(order);
    }

    @Override
    public void addOrder(Order order) {
        this.sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return this.sessionFactory.getCurrentSession().createCriteria(Order.class).list();
    }
    
}
