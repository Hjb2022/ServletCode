package adminservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.MyMethod;
import model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/AdminOrderInfoServlet")
public class AdminOrderInfoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Order> list = new ArrayList<Order>();

        MyMethod md = new MyMethod();//调用外部类里的方法
        list = md.getOrders();
        HttpSession session = request.getSession();//定义session，用于传值给下一个页面
        session.setAttribute("orderlist", list);//设置传给下一个页面的值
        response.sendRedirect("adminorder.jsp");
    }
}
