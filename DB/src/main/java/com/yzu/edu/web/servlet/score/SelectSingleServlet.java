package com.yzu.edu.web.servlet.score;

import com.yzu.edu.pojo.Score;
import com.yzu.edu.service.ScoreService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/servlet/score/selectSingleServlet")
public class SelectSingleServlet extends HttpServlet {
    private ScoreService service = new ScoreService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String admission = request.getParameter("admission");
        Score score = service.selectSingle(admission);
        request.getSession(true).setAttribute("score", score);
        request.getRequestDispatcher("/score/updateSingle.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
