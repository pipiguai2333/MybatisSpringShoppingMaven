package bean.vo;

import java.util.List;

public class GoodsVo {
    String goodsId;
    String goodsName;
    Float price;
    List<Item> items;
    int number;

    public String getGoodsId() {
        return goodsId;
    }
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }
    public String getGoodsName() {
        return goodsName;
    }
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public List<Item> getItems(){return items;}
    public void setItems(List<Item> items){this.items = items;}
    public int getNumber(){return number;}
    public void setNumber(int number){this.number = number;}
}
