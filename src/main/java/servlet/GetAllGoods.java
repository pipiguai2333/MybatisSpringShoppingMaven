package servlet;

import bean.vo.GoodsVo;
import bean.vo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import service.GoodsService;
import service.ItemService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GetAllGoods extends HttpServlet {

    @Autowired
    GoodsService goodsService;
    @Autowired
    ItemService itemService;

    public GetAllGoods() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        //request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();

        String pageNo = request.getParameter("pageNo");
        int pageSize = 2;
        int page = 1;
        if(pageNo != null){
            page = Integer.parseInt(pageNo);
        }

        Map<String, Integer> map = new HashMap<>();
        map.put("pageNo", page);
        map.put("pageSize", pageSize);
        List<GoodsVo> goodsList = goodsService.getGoodsByPage(map);
        for(GoodsVo goods:goodsList){
            List<Item> items=itemService.getItemsById(goods.getGoodsId());
            int number=0;
            for(Item item:items){
                number +=item.getQuantity();
            }
            goods.setNumber(number);
            goods.setItems(items);
        }
        int pageCount = goodsService.getPageCount();

        request.setAttribute("goodList", goodsList);
        request.setAttribute("pageNo", page);
        request.setAttribute("pageCount", pageCount);

        String forward = "goodslist.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(forward);
        rd.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        doGet(request,response);
    }

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        AutowireCapableBeanFactory factory = wac.getAutowireCapableBeanFactory();
        factory.autowireBean(this);
    }

    public void destroy(){
        super.destroy();
    }
}
