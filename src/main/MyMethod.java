package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Book;
import model.Order;
import model.User;
public class MyMethod {
    public void insert(User user) {
        try {
            Connection conn = code.JDBCUtils.getConnection();
            String sql = "INSERT INTO users(username,password) " + "VALUES(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String queryUser(String username) {
        try {
            Connection conn = code.JDBCUtils.getConnection();
            String sql = "SELECT * FROM users WHERE username=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String password = rs.getString("password");
                conn.close();
                return password;
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Book> getBooks() {
        List<Book> list = new ArrayList<Book>();
        try {
            Connection conn = code.JDBCUtils.getConnection();
            String sql = "SELECT * FROM books";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setBookid(rs.getInt("bookid"));
                book.setBookname(rs.getString("bookname"));
                book.setBookauthor(rs.getString("bookauthor"));
                book.setBookprice(rs.getFloat("bookprice"));
                list.add(book);
            }
            conn.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void alertPwd(String username, String password) {
        try {
            Connection conn = code.JDBCUtils.getConnection();
            String sql = "UPDATE users SET password=? WHERE username=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2, username);
            ps.executeUpdate();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addScart(String username, int bookid, String bookname, String bookauthor, String bookprice,
                         String booknum) {
        try {
            Connection conn = code.JDBCUtils.getConnection();
            String sql = "INSERT INTO scart(username,bookid,bookname,bookauthor,bookprice,booknum) "
                    + "VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setInt(2, bookid);
            ps.setString(3, bookname);
            ps.setString(4, bookauthor);
            ps.setString(5, bookprice);
            ps.setString(6, booknum);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addOrder(String username, int bookid, String bookname, String bookauthor, String bookprice,
                         String booknum) {
        try {
            Connection conn = code.JDBCUtils.getConnection();
            String sql = "INSERT INTO orders(username,bookid,bookname,bookauthor,bookprice,booknum) "
                    + "VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setInt(2, bookid);
            ps.setString(3, bookname);
            ps.setString(4, bookauthor);
            ps.setString(5, bookprice);
            ps.setString(6, booknum);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Book> getScart(String username) {
        List<Book> list = new ArrayList<Book>();
        try {
            Connection conn = code.JDBCUtils.getConnection();
            String sql = "SELECT * FROM scart WHERE username=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setBookid(rs.getInt("bookid"));
                book.setBookname(rs.getString("bookname"));
                book.setBookauthor(rs.getString("bookauthor"));
                book.setBookprice(rs.getFloat("bookprice"));
                book.setBooknum(rs.getInt("booknum"));
                list.add(book);
            }
            conn.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Book> getOrder(String username) {
        List<Book> list = new ArrayList<Book>();
        try {
            Connection conn = code.JDBCUtils.getConnection();
            String sql = "SELECT * FROM orders WHERE username=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setBookid(rs.getInt("bookid"));
                book.setBookname(rs.getString("bookname"));
                book.setBookauthor(rs.getString("bookauthor"));
                book.setBookprice(rs.getFloat("bookprice"));
                book.setBooknum(rs.getInt("booknum"));
                list.add(book);
            }
            conn.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void buyAll(String username) {
        try {
            Connection conn1 = code.JDBCUtils.getConnection();
            Connection conn2 = code.JDBCUtils.getConnection();
            String sql1 = "SELECT * FROM scart WHERE username=?";
            String sql2 = "INSERT INTO orders(username,bookid,bookname,bookauthor,bookprice,booknum) "
                    + "VALUES(?,?,?,?,?,?)";
            PreparedStatement ps1 = conn1.prepareStatement(sql1);
            PreparedStatement ps2 = conn2.prepareStatement(sql2);
            ps1.setString(1, username);
            ResultSet rs1 = ps1.executeQuery();
            while (rs1.next()) {
                ps2.setString(1, username);
                ps2.setInt(2, rs1.getInt("bookid"));
                ps2.setString(3, rs1.getString("bookname"));
                ps2.setString(4, rs1.getString("bookauthor"));
                ps2.setFloat(5, rs1.getFloat("bookprice"));
                ps2.setInt(6, rs1.getInt("booknum"));
                ps2.executeUpdate();
            }
            conn1.close();
            conn2.close();
            removeAll(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeAll(String username) {
        try {
            Connection conn = code.JDBCUtils.getConnection();
            String sql = "DELETE FROM scart WHERE username=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String queryAdmin(String adminname) {
        try {
            Connection conn = code.JDBCUtils.getConnection();
            String sql = "SELECT * FROM admins WHERE adminname=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, adminname);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String password = rs.getString("password");
                conn.close();
                return password;
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void alertBook(int bookid, String bookname, String bookauthor, String bookprice) {
        try {
            Connection conn = code.JDBCUtils.getConnection();
            String sql = "UPDATE books SET bookname=?,bookauthor=?,bookprice=? WHERE bookid=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, bookname);
            ps.setString(2, bookauthor);
            ps.setString(3, bookprice);
            ps.setInt(4, bookid);
            ps.executeUpdate();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getUsers() {
        List<User> list = new ArrayList<User>();
        try {
            Connection conn = code.JDBCUtils.getConnection();
            String sql = "SELECT * FROM users";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                list.add(user);
            }
            conn.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Order> getOrders() {
        List<Order> list = new ArrayList<Order>();
        try {
            Connection conn = code.JDBCUtils.getConnection();
            String sql = "SELECT * FROM orders";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setOrderid(rs.getString("orderid"));
                order.setUsername(rs.getString("username"));
                order.setBookid(rs.getInt("bookid"));
                order.setBookname(rs.getString("bookname"));
                order.setBookauthor(rs.getString("bookauthor"));
                order.setBookprice(rs.getFloat("bookprice"));
                order.setBooknum(rs.getInt("booknum"));
                list.add(order);
            }
            conn.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void alertOrder(int orderid, String bookname, String bookauthor, String bookprice, int booknum) {
        try {
            Connection conn = code.JDBCUtils.getConnection();
            String sql = "UPDATE orders SET bookname=?,bookauthor=?,bookprice=?,booknum=? WHERE orderid=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, bookname);
            ps.setString(2, bookauthor);
            ps.setString(3, bookprice);
            ps.setInt(4, booknum);
            ps.setInt(5, orderid);
            ps.executeUpdate();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addBook(Book book) {
        try {
            Connection conn = code.JDBCUtils.getConnection();
            String sql = "INSERT INTO books(bookname,bookauthor,bookprice) " + "VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, book.getBookname());
            ps.setString(2, book.getBookauthor());
            ps.setFloat(3, book.getBookprice());
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
