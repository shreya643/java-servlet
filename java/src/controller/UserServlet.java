package controller;

import domain.User;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class UserServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String check=request.getParameter("pageRequest");
        if(check.equalsIgnoreCase("login")) {

            String username = request.getParameter("username");
            String password = request.getParameter("password");

            User user = new UserService().getUser(username, password);

            if (user != null) {
               response.sendRedirect("displayHero?pageRequest=list");
                HttpSession session=request.getSession(false);
                session.setAttribute("user",user);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
        }
        else if(check.equalsIgnoreCase("register"))
        {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String role = request.getParameter("role");

            new UserService().setUser(username,password,role);

            response.sendRedirect("userList?pageRequest=userList");
        }
        else if(check.equalsIgnoreCase("edit"))
        {

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String role = request.getParameter("role");
            Integer id=Integer.parseInt(request.getParameter("id"));
            System.out.println(username);
            System.out.println(id);
            new UserService().updateUser(username,password,role,id);

            response.sendRedirect("userList?pageRequest=userList");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String check=request.getParameter("pageRequest");
        if(check.equalsIgnoreCase("logout"))
        {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
        else if(check.equalsIgnoreCase("userList"))
        {
            List<User> userList= new UserService().getUserList();
            request.setAttribute("userList", userList);
            RequestDispatcher rd = request.getRequestDispatcher("user/list.jsp");
            rd.forward(request, response);
        }
        else if(check.equalsIgnoreCase("createUser"))
        {
            RequestDispatcher rd = request.getRequestDispatcher("user/registration.jsp");
            rd.forward(request, response);
        }
        else if(check.equalsIgnoreCase("editUser"))
        {
            String username = request.getParameter("name");
            String password = request.getParameter("password");

            User user = new UserService().getUser(username, password);
            request.setAttribute("user",user);
            RequestDispatcher rd = request.getRequestDispatcher("user/edit.jsp");
            rd.forward(request, response);
        }
        else if(check.equalsIgnoreCase("deleteUser"))
        {
            Integer id=Integer.parseInt(request.getParameter("id"));
//            System.out.println(id);
            new UserService().deleteUser(id);
//            List<User> userList = new UserService().getUserList();
//            request.setAttribute("users", userList);
            response.sendRedirect("userList?pageRequest=userList");
        }
    }
}
