package service;

import bean.vo.Item;

import java.util.List;

public interface ItemService {
    public int deleteItem(int itemId);
    public int modifyQuantity(Item modifyItem);
    public int addItem(Item newItem);
    public List<Item> getItemsById(String id);
}
