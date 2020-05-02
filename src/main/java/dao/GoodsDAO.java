package dao;

import bean.vo.GoodsVo;
import bean.vo.Item;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("goodsDao")
public interface GoodsDAO {
    public List<GoodsVo> getGoodsByPage(Map<String,Integer> map);
    public GoodsVo getGoodsById(String id);
    public int getPageCount();
    public int addGoods(GoodsVo newGoods);
    public int modifyGoods(GoodsVo modifyGoods);
    public int deleteGoods(String id);
}
