package com.yzu.edu.web.servlet.score;

import com.yzu.edu.pojo.Score;
import com.yzu.edu.service.ScoreService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/servlet/score/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private ScoreService service = new ScoreService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Score> scores = service.selectAll();
        request.getSession(true).setAttribute("scores", scores);
        request.getRequestDispatcher("/score/selectAll.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
