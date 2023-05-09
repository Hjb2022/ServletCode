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
@WebServlet("/AdminAlertUserServlet")
public class AdminAlertUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        MyMethod md = new MyMethod();//调用外部类里的方法
        md.alertPwd(username, password);
        PrintWriter out = response.getWriter();
        out.println(
                "<script language='javascript'>alert('修改成功！');window.location='/BookStore/AdminUserInfoServlet';</script>");
    }
}
