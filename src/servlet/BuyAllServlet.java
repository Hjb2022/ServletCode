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
@WebServlet("/BuyAllServlet")
public class BuyAllServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();//定义session，获取之前页面传的值
        String username = String.valueOf(session.getAttribute("username"));//之前页面传过来的值

        MyMethod md = new MyMethod();//调用外部类里的方法
        md.buyAll(username);//将数据库购物车表里的信息全部添加到订单表里，并且删除购物车表里用户名为当前用户的信息

        PrintWriter out = response.getWriter();
        out.println(
                "<script language='javascript'>alert('全部购买成功！');window.location='/BookStore/SCartInfoServlet'</script>");//设置页面弹窗，并跳转至购物车页面
    }

}
