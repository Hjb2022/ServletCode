package adminservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import main.MyMethod;
import model.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/AdminUserInfoServlet")
public class AdminUserInfoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> list = new ArrayList<User>();

        MyMethod md = new MyMethod();//�����ⲿ����ķ���
        list = md.getUsers();
        HttpSession session = request.getSession();//����session�����ڴ�ֵ����һ��ҳ��
        session.setAttribute("userlist", list);//���ô�����һ��ҳ���ֵ
        response.sendRedirect("adminuser.jsp");
    }
}
