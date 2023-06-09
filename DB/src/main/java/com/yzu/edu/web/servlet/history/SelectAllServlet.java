package com.yzu.edu.web.servlet.history;

import com.yzu.edu.pojo.History;
import com.yzu.edu.service.HistoryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/servlet/history/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private HistoryService service = new HistoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<History> histories = service.selectAll();
        request.getSession(true).setAttribute("histories", histories);
        request.getRequestDispatcher("/history/selectAll.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
