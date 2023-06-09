package com.yzu.edu.web.servlet.user;

import com.yzu.edu.pojo.User;
import com.yzu.edu.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/servlet/user/loginServlet")
public class LoginServlet extends HttpServlet {
    UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            user = service.selectSingle(username, password);
            if (user != null) {
                request.getSession(true).setAttribute("user", user);
                request.getRequestDispatcher("/user/index.jsp").forward(request, response);
            } else {
                request.setAttribute("login_msg", "提示：用户名或密码错误！");
                request.getRequestDispatcher("/user/login.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("/user/index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
