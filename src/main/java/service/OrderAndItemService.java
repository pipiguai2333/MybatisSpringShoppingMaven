package service;

import bean.vo.Item;
import bean.vo.OrderAndItem;

import java.util.List;

public interface OrderAndItemService {
    public int addOrderAndItem(List<OrderAndItem> list);
    public List<Item> getItemsByOrderId(Integer orderId);
}
