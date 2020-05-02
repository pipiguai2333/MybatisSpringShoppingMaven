package bean.vo;

import java.util.Date;
import java.util.List;

public class Order {
    private int orderId;
    private Date createdTime;
    private List<Item> items;

    public void setOrderId(int orderId){this.orderId=orderId;}
    public int getOrderId(){return orderId;}
    public void setCreatedTime(Date createdTime){this.createdTime=createdTime;}
    public Date getCreatedTime(){return createdTime;}
    public void setItems(List<Item> items){this.items=items;}
    public List<Item> getItems(){return items;}
}
