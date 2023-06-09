package com.yzu.edu.web.servlet.site;

import com.yzu.edu.pojo.Site;
import com.yzu.edu.service.SiteService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/servlet/site/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    SiteService service = new SiteService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Site> sites = service.selectAll();
        request.getSession(true).setAttribute("sites", sites);
        request.getRequestDispatcher("/site/selectAll.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
