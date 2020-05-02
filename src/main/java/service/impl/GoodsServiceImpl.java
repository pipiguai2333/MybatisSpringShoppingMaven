package service.impl;

import bean.vo.GoodsVo;
import bean.vo.Item;
import dao.GoodsDAO;
import org.springframework.stereotype.Service;
import service.GoodsService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Resource(name="goodsDao")
    GoodsDAO goodsDAO;

    @Override
    public List<GoodsVo> getGoodsByPage(Map<String,Integer> map) {
        return goodsDAO.getGoodsByPage(map);
    }

    @Override
    public GoodsVo getGoodsById(String id) {
        return goodsDAO.getGoodsById(id);
    }

    @Override
    public int getPageCount() {
        return goodsDAO.getPageCount();
    }

    @Override
    public int addGoods(GoodsVo newGoods) {
        return goodsDAO.addGoods(newGoods);
    }

    @Override
    public int modifyGoods(GoodsVo modifyGoods) {
        return goodsDAO.modifyGoods(modifyGoods);
    }

    @Override
    public int deleteGoods(String id) {
        return goodsDAO.deleteGoods(id);
    }

}
