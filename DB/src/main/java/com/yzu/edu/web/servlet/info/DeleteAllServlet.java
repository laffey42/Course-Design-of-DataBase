package com.yzu.edu.web.servlet.info;

import com.yzu.edu.service.HallService;
import com.yzu.edu.service.InfoService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/servlet/info/deleteAllServlet")
public class DeleteAllServlet extends HttpServlet {
    private HallService hallService = new HallService();
    private InfoService infoService = new InfoService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        infoService.deleteAll();
        hallService.deleteAll();
        request.getRequestDispatcher("/servlet/info/generateAllServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
