package adminservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;



@SuppressWarnings("serial")
@WebServlet("/AlertBook")
public class AlertBook extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int bookid = Integer.parseInt(request.getParameter("bookid"));//url里的参数，以下同理
        String bookname = request.getParameter("bookname");
        String bookauthor = request.getParameter("bookauthor");
        String bookprice = request.getParameter("bookprice");

        HttpSession session = request.getSession();//定义session，用于传值给下一个页面
        session.setAttribute("bookid", bookid);//设置传给下一个页面的值
        session.setAttribute("bookname", bookname);//设置传给下一个页面的值
        session.setAttribute("bookauthor", bookauthor);//设置传给下一个页面的值
        session.setAttribute("bookprice", bookprice);//设置传给下一个页面的值
        response.sendRedirect("adminalertbook.jsp");
    }
}
