package dao;

import bean.vo.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("itemDao")
public interface ItemDao {
    public int deleteItem(int itemId);
    public int modifyQuantity(Item modifyItem);
    public int addItem(Item newItem);
    public List<Item> getItemsById(String id);
}
