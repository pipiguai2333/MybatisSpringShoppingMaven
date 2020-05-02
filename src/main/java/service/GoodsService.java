package service;

import bean.vo.GoodsVo;
import bean.vo.Item;

import java.util.List;
import java.util.Map;


public interface GoodsService {
    public List<GoodsVo> getGoodsByPage(Map<String,Integer> map);
    public GoodsVo getGoodsById(String id);
    public int getPageCount();
    public int addGoods(GoodsVo newGoods);
    public int modifyGoods(GoodsVo modifyGoods);
    public int deleteGoods(String id);
}
