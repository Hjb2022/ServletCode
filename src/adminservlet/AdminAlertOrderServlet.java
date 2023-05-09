package adminservlet;

import java.io.IOException;
import java.io.PrintWriter;

import main.MyMethod;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/AdminAlertOrderServlet")
public class AdminAlertOrderServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        int orderid = Integer.parseInt(request.getParameter("orderid"));//url里的参数，以下同理
        String bookname = request.getParameter("bookname");
        String bookauthor = request.getParameter("bookauthor");
        String bookprice = request.getParameter("bookprice");
        int booknum = Integer.parseInt(request.getParameter("booknum"));

        MyMethod md = new MyMethod();//调用外部类里的方法
        md.alertOrder(orderid, bookname, bookauthor, bookprice, booknum);
        PrintWriter out = response.getWriter();
        out.println(
                "<script language='javascript'>alert('修改成功！');window.location='/BookStore/AdminOrderInfoServlet';</script>");
    }
}
