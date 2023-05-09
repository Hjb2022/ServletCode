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
        HttpSession session = request.getSession();//����session����ȡ֮ǰҳ�洫��ֵ
        String username = String.valueOf(session.getAttribute("username"));//֮ǰҳ�洫������ֵ

        MyMethod md = new MyMethod();//�����ⲿ����ķ���
        md.buyAll(username);//�����ݿ⹺�ﳵ�������Ϣȫ����ӵ������������ɾ�����ﳵ�����û���Ϊ��ǰ�û�����Ϣ

        PrintWriter out = response.getWriter();
        out.println(
                "<script language='javascript'>alert('ȫ������ɹ���');window.location='/BookStore/SCartInfoServlet'</script>");//����ҳ�浯��������ת�����ﳵҳ��
    }

}
