package adminservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet("/AlertOrder")
public class AlertOrder extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int orderid = Integer.parseInt(request.getParameter("orderid"));//url里的参数，以下同理
        String username = request.getParameter("username");
        int bookid = Integer.parseInt(request.getParameter("bookid"));
        String bookname = request.getParameter("bookname");
        String bookauthor = request.getParameter("bookauthor");
        String bookprice = request.getParameter("bookprice");
        int booknum = Integer.parseInt(request.getParameter("booknum"));
        HttpSession session = request.getSession();//定义session，用于传值给下一个页面
        session.setAttribute("orderid", orderid);//设置传给下一个页面的值
        session.setAttribute("username", username);//设置传给下一个页面的值
        session.setAttribute("bookid", bookid);//设置传给下一个页面的值
        session.setAttribute("bookname", bookname);//设置传给下一个页面的值
        session.setAttribute("bookauthor", bookauthor);//设置传给下一个页面的值
        session.setAttribute("bookprice", bookprice);//设置传给下一个页面的值
        session.setAttribute("booknum", booknum);//设置传给下一个页面的值
        response.sendRedirect("adminalertorder.jsp");
    }
}
