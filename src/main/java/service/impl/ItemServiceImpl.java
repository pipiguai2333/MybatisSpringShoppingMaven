package service.impl;

import bean.vo.Item;
import dao.ItemDao;
import org.springframework.stereotype.Service;
import service.ItemService;

import javax.annotation.Resource;
import java.util.List;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

    @Resource(name="itemDao")
    ItemDao itemDao;
    @Override
    public int deleteItem(int itemId) {
        return itemDao.deleteItem(itemId);
    }

    @Override
    public int modifyQuantity(Item modifyItem) {
        return itemDao.modifyQuantity(modifyItem);
    }

    @Override
    public int addItem(Item newItem) {
        return itemDao.addItem(newItem);
    }

    @Override
    public List<Item> getItemsById(String id) {
        return itemDao.getItemsById(id);
    }
}
