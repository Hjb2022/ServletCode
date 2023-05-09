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

        MyMethod md = new MyMethod();//�����ⲿ����ķ���
        list = md.getOrders();
        HttpSession session = request.getSession();//����session�����ڴ�ֵ����һ��ҳ��
        session.setAttribute("orderlist", list);//���ô�����һ��ҳ���ֵ
        response.sendRedirect("adminorder.jsp");
    }
}
