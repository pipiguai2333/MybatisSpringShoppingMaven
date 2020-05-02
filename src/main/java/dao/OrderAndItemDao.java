package dao;

import bean.vo.Item;
import bean.vo.OrderAndItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("orderAndItemDao")
public interface OrderAndItemDao {
    public int addOrderAndItem(List<OrderAndItem> list);
    public List<Item> getItemsByOrderId(Integer orderId);
}
