package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import main.MyMethod;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        HttpSession session = request.getSession();//定义session，获取之前页面传的值
        String username = String.valueOf(session.getAttribute("username"));//之前页面传过来的值
        int bookid = Integer.parseInt(request.getParameter("bookid"));//url里的参数，以下同理
        String bookname = request.getParameter("bookname");
        String bookauthor = request.getParameter("bookauthor");
        String bookprice = request.getParameter("bookprice");
        String booknum = request.getParameter("booknum");

        MyMethod md = new MyMethod();//调用外部类里的方法
        md.addOrder(username, bookid, bookname, bookauthor, bookprice, booknum);//将书的信息添加到数据库的订单表里
        PrintWriter out = response.getWriter();
        out.println("<script language='javascript'>alert('购买成功！');window.location='index.jsp'</script>");//设置页面弹窗，并跳转至主页
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
