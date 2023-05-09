package adminservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;



@SuppressWarnings("serial")
@WebServlet("/AlertBook")
public class AlertBook extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int bookid = Integer.parseInt(request.getParameter("bookid"));//url��Ĳ���������ͬ��
        String bookname = request.getParameter("bookname");
        String bookauthor = request.getParameter("bookauthor");
        String bookprice = request.getParameter("bookprice");

        HttpSession session = request.getSession();//����session�����ڴ�ֵ����һ��ҳ��
        session.setAttribute("bookid", bookid);//���ô�����һ��ҳ���ֵ
        session.setAttribute("bookname", bookname);//���ô�����һ��ҳ���ֵ
        session.setAttribute("bookauthor", bookauthor);//���ô�����һ��ҳ���ֵ
        session.setAttribute("bookprice", bookprice);//���ô�����һ��ҳ���ֵ
        response.sendRedirect("adminalertbook.jsp");
    }
}
