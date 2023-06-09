package com.yzu.edu.web.servlet.info;

import com.yzu.edu.pojo.Info;
import com.yzu.edu.service.InfoService;
import com.yzu.edu.view.InfoView;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/servlet/info/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private InfoService service = new InfoService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<InfoView> infoViews = service.viewAll();
        request.getSession(true).setAttribute("infoViews", infoViews);
        request.getRequestDispatcher("/info/selectAll.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
