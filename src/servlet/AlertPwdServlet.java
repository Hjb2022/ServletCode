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

    //�޸�����
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        HttpSession session = request.getSession();//����session����ȡ֮ǰҳ�洫��ֵ
        String username = String.valueOf(session.getAttribute("username"));//֮ǰҳ�洫������ֵ
        String password = String.valueOf(session.getAttribute("password"));//url��Ĳ���������ͬ��
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");

        MyMethod md = new MyMethod();//�����ⲿ����ķ���
        if (!password.equals(password1)) {//�жϾ������Ƿ�������ȷ
            PrintWriter out = response.getWriter();
            out.println("<script language='javascript'>alert('ԭ�������');window.history.go(-1);</script>");//����ҳ�浯��
        } else {
            md.alertPwd(username, password2);//�����ݿ�����û���ǰ�������޸ĳ������������
            PrintWriter out = response.getWriter();
            out.println("<script language='javascript'>alert('�޸ĳɹ��������µ�¼��');window.location='login.jsp';</script>");//����ҳ�浯��������ת����¼����
        }

    }
}
