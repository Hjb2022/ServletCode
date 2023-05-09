package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.MyMethod;
import model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SCartInfoServlet")
public class SCartInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SCartInfoServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = String.valueOf(session.getAttribute("username"));
        List<Book> list = new ArrayList<Book>();

        MyMethod md = new MyMethod();
        list = md.getScart(username);
        session.setAttribute("scartlist", list);
        response.sendRedirect("myscart.jsp");
    }
}
