package service.impl;

import bean.vo.Item;
import bean.vo.OrderAndItem;
import dao.OrderAndItemDao;
import org.springframework.stereotype.Service;
import service.OrderAndItemService;

import javax.annotation.Resource;
import java.util.List;

@Service("orderAndItemService")
public class OrderAndItemServiceImpl implements OrderAndItemService {

    @Resource(name="orderAndItemDao")
    OrderAndItemDao orderAndItemDao;
    @Override
    public int addOrderAndItem(List<OrderAndItem> list) {
        return orderAndItemDao.addOrderAndItem(list);
    }

    @Override
    public List<Item> getItemsByOrderId(Integer orderId) {
        return orderAndItemDao.getItemsByOrderId(orderId);
    }
}
