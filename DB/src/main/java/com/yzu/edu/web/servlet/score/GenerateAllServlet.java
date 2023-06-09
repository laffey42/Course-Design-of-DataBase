package com.yzu.edu.web.servlet.score;

import com.yzu.edu.pojo.Info;
import com.yzu.edu.service.InfoService;
import com.yzu.edu.service.ScoreService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@WebServlet("/servlet/score/generateAllServlet")
public class GenerateAllServlet extends HttpServlet {
    private InfoService infoService = new InfoService();
    private ScoreService scoreService = new ScoreService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        scoreService.deleteAll();
        List<Info> infos = infoService.selectAll();
        Random random = new Random();
        for (Info info : infos) {
            String admission = info.getAdmission();
            int score01 = random.nextInt(101);
            if (score01 < 40) {
                score01 += random.nextInt(60);
            } else if (score01 < 60) {
                score01 += random.nextInt(40);
            }
            int score02 = random.nextInt(101);
            if (score02 < 40) {
                score02 += random.nextInt(60);
            } else if (score02 < 60) {
                score02 += random.nextInt(40);
            }
            int scoreTotal = (int) (score01 * 0.6 + score02 * 0.4);
            scoreService.insertSingle(admission, score01, score02, scoreTotal);
        }
        request.getRequestDispatcher("/servlet/score/selectAllServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
