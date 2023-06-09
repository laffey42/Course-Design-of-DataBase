package com.yzu.edu.web.filter;

import com.yzu.edu.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest)request;
        String[] urls = {"/user/login.jsp", "/servlet/user/loginServlet"};
        String url = req.getRequestURL().toString();
        for (String u : urls){
            if (url.contains(u)){
                chain.doFilter(request, response);
                return;
            }
        }
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        if (user != null) {
            chain.doFilter(request, response);
        } else {
            req.getRequestDispatcher("/user/login.jsp").forward(request, response);
        }
    }
}
