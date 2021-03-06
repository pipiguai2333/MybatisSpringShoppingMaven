package servlet;

import bean.vo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import service.CartService;
import service.GoodsService;
import service.ItemService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DeleteGoods extends HttpServlet {
    @Autowired
    GoodsService goodsService;
    @Autowired
    CartService cartService;

    public DeleteGoods() {
        super();
    }
    public void destroy() {
        super.destroy();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        AutowireCapableBeanFactory factory = wac.getAutowireCapableBeanFactory();
        factory.autowireBean(this);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String message;
        String goodsId = request.getParameter("goodsId");

        HttpSession session = request.getSession();
        ArrayList<Item> cart = (ArrayList<Item>)session.getAttribute("cart");
        if(cart != null) {
            Iterator<Item> it = cart.iterator();
            while (it.hasNext()) {
                Item oneItem = it.next();
                if (oneItem.getGoods().getGoodsId().equalsIgnoreCase(goodsId)) {
                    cart.remove(oneItem);
                    break;
                }
            }
            cartService.setCart(cart);
            session.setAttribute("cart", cartService.getCart());
        }

        if(goodsService.deleteGoods(goodsId)>0){
            message = "删除商品成功";
        }
        else {
            message = "删除商品失败";
        }

        request.setAttribute("message", message);

        String forward = "getAllGoods";
        RequestDispatcher rd = request.getRequestDispatcher(forward);
        rd.forward(request, response);
    }
}
