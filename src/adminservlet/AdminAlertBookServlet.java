package adminservlet;
import java.io.IOException;
import java.io.PrintWriter;
import main.MyMethod;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/AdminAlertBookServlet")
public class AdminAlertBookServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        int bookid = Integer.parseInt(request.getParameter("bookid"));
        String bookname = request.getParameter("bookname");
        String bookauthor = request.getParameter("bookauthor");
        String bookprice = request.getParameter("bookprice");
        MyMethod md = new MyMethod();//�����ⲿ����ķ���
        md.alertBook(bookid, bookname, bookauthor, bookprice);
        PrintWriter out = response.getWriter();
        out.println(
                "<script language='javascript'>alert('�޸ĳɹ���');window.location='/BookStore/AdminBookInfoServlet';</script>");
    }
}
