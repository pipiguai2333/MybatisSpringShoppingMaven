package bean.vo;

public class Item {
    private GoodsVo  goods;  //关联属性
    private int quantity;
    private int itemId;


    public GoodsVo getGoods() {
        return goods;
    }
    public void setGoods(GoodsVo goods) {
        this.goods = goods;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setItemId(int id) {itemId = id;}
    public int getItemId(){return itemId;}
}
