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
@WebServlet("/AlertPwdServlet")
public class AlertPwdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    //修改密码
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        HttpSession session = request.getSession();//定义session，获取之前页面传的值
        String username = String.valueOf(session.getAttribute("username"));//之前页面传过来的值
        String password = String.valueOf(session.getAttribute("password"));//url里的参数，以下同理
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");

        MyMethod md = new MyMethod();//调用外部类里的方法
        if (!password.equals(password1)) {//判断旧密码是否输入正确
            PrintWriter out = response.getWriter();
            out.println("<script language='javascript'>alert('原密码错误！');window.history.go(-1);</script>");//设置页面弹窗
        } else {
            md.alertPwd(username, password2);//将数据库里该用户当前的密码修改成输入的新密码
            PrintWriter out = response.getWriter();
            out.println("<script language='javascript'>alert('修改成功！请重新登录！');window.location='login.jsp';</script>");//设置页面弹窗，并跳转至登录界面
        }

    }
}
