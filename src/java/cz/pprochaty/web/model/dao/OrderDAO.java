
package cz.pprochaty.web.model.dao;

import cz.pprochaty.web.model.Order;
import java.util.List;

public interface OrderDAO {
    Order getOrderById(int id);
    void deleteOrder(Order order_id);
    void updateOrder(Order order);
    void addOrder(Order order);
    List<Order> getAllOrders();
}
