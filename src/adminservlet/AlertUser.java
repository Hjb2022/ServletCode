package adminservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet("/AlertUser")
public class AlertUser extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();//����session�����ڴ�ֵ����һ��ҳ��
        session.setAttribute("username", username);//���ô�����һ��ҳ���ֵ
        session.setAttribute("password", password);//���ô�����һ��ҳ���ֵ
        response.sendRedirect("adminalertuser.jsp");
    }
}
