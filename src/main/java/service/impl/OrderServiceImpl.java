package service.impl;

import bean.vo.Order;
import dao.OrderDao;
import org.springframework.stereotype.Service;
import service.OrderService;

import javax.annotation.Resource;
import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Resource(name="orderDao")
    OrderDao orderDao;
    @Override
    public List<Order> findAllOrders() {
        return orderDao.findAllOrders();
    }

    @Override
    public int deleteOrder(Integer orderId) {
        return orderDao.deleteOrder(orderId);
    }

    @Override
    public int addOrder(Order newOrder) {
        return orderDao.addOrder(newOrder);
    }
}
