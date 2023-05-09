package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import main.MyMethod;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            Connection conn = code.JDBCUtils.getConnection();
            String sql = "SELECT * FROM users WHERE username=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            boolean f = rs.next();
            if (f) {
                PrintWriter out = response.getWriter();
                out.println("<script language='javascript'>alert('用户名已存在！');window.history.go(-1);</script>");
            } else {
                MyMethod me = new MyMethod();
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                me.insert(user);
                PrintWriter out = response.getWriter();
                out.println("<script language='javascript'>alert('注册成功！');window.location='login.jsp'</script>");
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
