package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import main.MyMethod;
import model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/AdminAddBookServlet")
public class AdminAddBookServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String bookname = request.getParameter("bookname");
        String bookauthor = request.getParameter("bookauthor");
        float bookprice = Float.valueOf(request.getParameter("bookprice"));
        MyMethod md = new MyMethod();
        Book book = new Book();
        book.setBookname(bookname);
        book.setBookauthor(bookauthor);
        book.setBookprice(bookprice);
        md.addBook(book);
        PrintWriter out = response.getWriter();
        out.println(
                "<script language='javascript'>alert('Ìí¼Ó³É¹¦£¡');window.location='/BookStore/AdminBookInfoServlet'</script>");

    }
}
