package dao;

import bean.vo.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("orderDao")
public interface OrderDao {
    public List<Order> findAllOrders();
    public int deleteOrder(Integer orderId);
    public int addOrder(Order newOrder);
}
