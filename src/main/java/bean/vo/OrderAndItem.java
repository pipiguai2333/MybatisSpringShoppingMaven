package bean.vo;

public class OrderAndItem {
    private int id;
    private int orderId;
    private int itemId;

    public void setId(int id){this.id=id;}
    public int getId(){return id;}
    public void setOrderId(int orderId){this.orderId=orderId;}
    public int getOrderId(){return orderId;}
    public void setItemId(int itemId){this.itemId=itemId;}
    public int getItemId(){return itemId;}
}
