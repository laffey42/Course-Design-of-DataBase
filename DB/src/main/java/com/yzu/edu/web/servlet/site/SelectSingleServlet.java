package com.yzu.edu.web.servlet.site;

import com.yzu.edu.pojo.Site;
import com.yzu.edu.service.SiteService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/servlet/site/selectSingleServlet")
public class SelectSingleServlet extends HttpServlet {
    SiteService service = new SiteService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String siteId = request.getParameter("siteId");
        Site site = service.selectSingle(siteId);
        request.getSession(true).setAttribute("site", site);
        request.getRequestDispatcher("/site/updateSingle.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
