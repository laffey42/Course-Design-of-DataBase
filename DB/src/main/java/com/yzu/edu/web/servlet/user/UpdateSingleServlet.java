package com.yzu.edu.web.servlet.user;

import com.yzu.edu.pojo.User;
import com.yzu.edu.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/servlet/user/updateSingleServlet")
public class UpdateSingleServlet extends HttpServlet {
    UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        if (username.contains(" ") || password.contains(" ") ) {
            request.getSession(true).setAttribute("user_msg", "提示：用户名或密码中不能包含空格！");
            request.getRequestDispatcher("/user/updateSingle.jsp").forward(request, response);
        } else if (password.length() < 6 || password.length() > 16) {
            request.getSession(true).setAttribute("user_msg", "提示：密码长度应为6~16位");
            request.getRequestDispatcher("/user/updateSingle.jsp").forward(request, response);
        } else {
            User user = (User) request.getSession().getAttribute("user");
            if (!user.getUsername().equals(username) || !user.getPassword().equals(password)) {
                service.updateSingle(user.getUid(), username, password);
                user = service.selectSingle(username, password);
                request.getSession(true).setAttribute("user", user);
            }
            request.getRequestDispatcher("/servlet/user/loginServlet").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
