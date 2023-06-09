package com.yzu.edu.web.servlet.score;

import com.yzu.edu.pojo.Score;
import com.yzu.edu.service.ScoreService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/servlet/score/updateSingleServlet")
public class UpdateSingleServlet extends HttpServlet {
    private ScoreService service = new ScoreService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Score score = (Score) request.getSession(true).getAttribute("score");
        String admission = score.getAdmission();
        String str01 = request.getParameter("score01");
        String str02 = request.getParameter("score02");
        if (str01 == null || str01.equals("") || str02 == null || str02.equals("")) {
            request.getSession(true).setAttribute("score_msg", "提示：数据不全！");
            request.getRequestDispatcher("/score/updateSingle.jsp").forward(request, response);
        } else {
            int score01 = Integer.parseInt(str01);
            int score02 = Integer.parseInt(str02);
            int scoreTotal = (int) (score01 * 0.6 + score02 * 0.4);
            service.updateSingle(admission, score01, score02, scoreTotal);
            request.getRequestDispatcher("/servlet/score/selectAllServlet").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
