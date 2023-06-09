package com.yzu.edu.web.servlet.score;

import com.yzu.edu.pojo.Info;
import com.yzu.edu.pojo.Score;
import com.yzu.edu.service.InfoService;
import com.yzu.edu.service.ScoreService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/servlet/score/insertSingleServlet")
public class InsertSingleServlet extends HttpServlet {
    private ScoreService scoreService = new ScoreService();
    private InfoService infoService = new InfoService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String admission = request.getParameter("admission");
        String str01 = request.getParameter("score01");
        String str02 = request.getParameter("score02");
        Score score = scoreService.selectSingle(admission);
        Info info = infoService.selectSingle(admission);
        if (score != null) {
            request.getSession(true).setAttribute("score_msg", "提示：不可重复录入！");
            request.getRequestDispatcher("/score/insertSingle.jsp").forward(request, response);
        } else if (info == null) {
            request.getSession(true).setAttribute("score_msg", "提示：准考证号有误！");
            request.getRequestDispatcher("/score/insertSingle.jsp").forward(request, response);
        } else if (str01 == null || str01.equals("") || str02 == null || str02.equals("")) {
            request.getSession(true).setAttribute("score_msg", "提示：数据不全！");
            request.getRequestDispatcher("/score/insertSingle.jsp").forward(request, response);
        } else {
            int score01 = Integer.parseInt(str01);
            int score02 = Integer.parseInt(str02);
            int scoreTotal = (int) (score01 * 0.6 + score02 * 0.4);
            scoreService.insertSingle(admission, score01, score02, scoreTotal);
            request.getSession(true).setAttribute("score_msg", "提示：成绩录入成功！");
            request.getRequestDispatcher("/score/insertSingle.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
