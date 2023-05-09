package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import main.MyMethod;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String adminname = request.getParameter("adminname");
        String password = request.getParameter("password");

        boolean f = false;
        MyMethod md = new MyMethod();
        String psw = md.queryAdmin(adminname);
        if (psw != null) {
            f = true;
        }
        if (!f) {
            PrintWriter out = response.getWriter();
            out.println("<script language='javascript'>alert('用户名不存在！');window.history.go(-1);</script>");
        } else {
            if (!password.equals(psw)) {
                PrintWriter out = response.getWriter();
                out.println("<script language='javascript'>alert('密码错误！');window.history.go(-1);</script>");
            } else {
                response.sendRedirect("adminindex.jsp");
            }
        }
    }
}
