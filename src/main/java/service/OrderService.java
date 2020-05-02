package service;

import bean.vo.Order;

import java.util.List;

public interface OrderService {
    public List<Order> findAllOrders();
    public int deleteOrder(Integer orderId);
    public int addOrder(Order newOrder);
}
