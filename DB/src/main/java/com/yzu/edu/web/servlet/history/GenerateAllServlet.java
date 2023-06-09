package com.yzu.edu.web.servlet.history;

import com.yzu.edu.pojo.History;
import com.yzu.edu.pojo.Info;
import com.yzu.edu.pojo.Score;
import com.yzu.edu.pojo.Student;
import com.yzu.edu.service.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/servlet/history/generateAllServlet")
public class GenerateAllServlet extends HttpServlet {
    private HistoryService historyService = new HistoryService();
    private InfoService infoService = new InfoService();
    private ScoreService scoreService = new ScoreService();
    private StudentService studentService = new StudentService();
    private HallService hallService = new HallService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Info> infos = infoService.selectAll();
        List<Score> scores = scoreService.selectAll();
        List<Student> students = studentService.selectAll();
        Score temp = new Score();
        for (Score score : scores) {
            temp = score;
        }
        if (temp == null || scores.size() != infos.size()) {
            request.getSession(true).setAttribute("history_msg", "提示：成绩录入未完成！");
            request.getRequestDispatcher("/history/answer.jsp").forward(request, response);
        } else {
            for (int i = 0; i < infos.size(); i++) {
                Info info = infos.get(i);
                Score score = scores.get(i);
                Student student = students.get(i);
                String stuId = info.getStuId();
                String time = info.getTime();
                String siteId = info.getSiteId();
                String hallId = info.getHallId();
                String lanId = student.getLanId();
                int score01 = score.getScore01();
                int score02 = score.getScore02();
                int scoreTotal = score.getScoreTotal();
                historyService.insertSingle(stuId, time, siteId, hallId, lanId, score01, score02, scoreTotal);
            }
            List<History> histories = historyService.selectAll();
            infoService.deleteAll();
            scoreService.deleteAll();
            studentService.deleteAll();
            hallService.deleteAll();
            request.getRequestDispatcher("/servlet/history/selectAllServlet").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
