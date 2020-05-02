package servlet;

import bean.vo.Item;
import bean.vo.Order;
import bean.vo.OrderAndItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import service.CartService;
import service.ItemService;
import service.OrderAndItemService;
import service.OrderService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ProcessOrder extends HttpServlet {

    @Autowired
    OrderAndItemService orderAndItemService;
    @Autowired
    OrderService orderService;
    @Autowired
    CartService cartService;
    @Autowired
    ItemService itemService;

    public ProcessOrder() {
        super();
    }
    public void destroy() {
        super.destroy();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        HttpSession session = request.getSession();
        ArrayList<Item> cart = (ArrayList<Item>)session.getAttribute("cart");

        Order newOrder = new Order();
        Date date = new Date();
        newOrder.setCreatedTime(date);

        orderService.addOrder(newOrder);

        List<OrderAndItem> list = new ArrayList<OrderAndItem>();

        if(cart != null) {
            Iterator<Item> it = cart.iterator();
            while (it.hasNext()) {
                Item temp = it.next();
                itemService.addItem(temp);

            }
        }

        if(cart != null) {
            Iterator<Item> it = cart.iterator();
            while (it.hasNext()) {
                Item temp = it.next();
                int itemId = temp.getItemId();
                int orderId = newOrder.getOrderId();
                OrderAndItem newOrderAndItem = new OrderAndItem();
                newOrderAndItem.setOrderId(orderId);
                newOrderAndItem.setItemId(itemId);
                list.add(newOrderAndItem);
            }
        }
        orderAndItemService.addOrderAndItem(list);

        session.removeAttribute("cart");
        cartService.submit();

        String forward = "getAllGoods";
        RequestDispatcher rd = request.getRequestDispatcher(forward);
        rd.forward(request, response);
    }

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        AutowireCapableBeanFactory factory = wac.getAutowireCapableBeanFactory();
        factory.autowireBean(this);
    }
}
