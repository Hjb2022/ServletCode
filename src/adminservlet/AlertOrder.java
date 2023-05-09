package adminservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet("/AlertOrder")
public class AlertOrder extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int orderid = Integer.parseInt(request.getParameter("orderid"));//url��Ĳ���������ͬ��
        String username = request.getParameter("username");
        int bookid = Integer.parseInt(request.getParameter("bookid"));
        String bookname = request.getParameter("bookname");
        String bookauthor = request.getParameter("bookauthor");
        String bookprice = request.getParameter("bookprice");
        int booknum = Integer.parseInt(request.getParameter("booknum"));
        HttpSession session = request.getSession();//����session�����ڴ�ֵ����һ��ҳ��
        session.setAttribute("orderid", orderid);//���ô�����һ��ҳ���ֵ
        session.setAttribute("username", username);//���ô�����һ��ҳ���ֵ
        session.setAttribute("bookid", bookid);//���ô�����һ��ҳ���ֵ
        session.setAttribute("bookname", bookname);//���ô�����һ��ҳ���ֵ
        session.setAttribute("bookauthor", bookauthor);//���ô�����һ��ҳ���ֵ
        session.setAttribute("bookprice", bookprice);//���ô�����һ��ҳ���ֵ
        session.setAttribute("booknum", booknum);//���ô�����һ��ҳ���ֵ
        response.sendRedirect("adminalertorder.jsp");
    }
}
