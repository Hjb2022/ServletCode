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
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
    //������Ʒ
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        HttpSession session = request.getSession();//����session����ȡ֮ǰҳ�洫��ֵ
        String username = String.valueOf(session.getAttribute("username"));//֮ǰҳ�洫������ֵ
        int bookid = Integer.parseInt(request.getParameter("bookid"));//url��Ĳ���������ͬ��
        String bookname = request.getParameter("bookname");
        String bookauthor = request.getParameter("bookauthor");
        String bookprice = request.getParameter("bookprice");
        String booknum = request.getParameter("booknum");

        MyMethod md = new MyMethod();//�����ⲿ����ķ���
        md.addScart(username, bookid, bookname, bookauthor, bookprice, booknum);//�������Ϣ��ӵ����ݿ�Ĺ��ﳵ����
        PrintWriter out = response.getWriter();
        out.println("<script language='javascript'>alert('���빺�ﳵ�ɹ���');window.location='index.jsp'</script>");//����ҳ�浯��������ת����ҳ
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
