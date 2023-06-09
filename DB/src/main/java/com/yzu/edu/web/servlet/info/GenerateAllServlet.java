package com.yzu.edu.web.servlet.info;

import com.yzu.edu.pojo.Hall;
import com.yzu.edu.pojo.Site;
import com.yzu.edu.pojo.Student;
import com.yzu.edu.service.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

@WebServlet("/servlet/info/generateAllServlet")
public class GenerateAllServlet extends HttpServlet {
    private HallService hallService = new HallService();
    private InfoService infoService = new InfoService();
    private SiteService siteService = new SiteService();
    private StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LocalDate now = LocalDate.now();
        LocalDate oneMonthLater = now.plusMonths(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String time = oneMonthLater.format(formatter);
        int[] numPerLan = getNumPerLan();
        String[] lanIds = getLanIds();
        String[] hallIds = getHallIds();
        String[] siteIds = getSiteIds();
        boolean[] hallUsed = new boolean[99];
        boolean[] siteUsed = new boolean[3];
        Random random = new Random();
        hallService.deleteAll();
        for (int i = 0; i < lanIds.length; i++) {
            int stuNum = numPerLan[i];
            String lanId = lanIds[i];
            String[] stuIds = getStuIds(lanId);
            int hallCode = 0, siteCode = 0, count = 1;
            String hallId = "", siteId = "";
            for (int j = 0; j < stuNum; j++, count++) {
                if (count == 1) {
                    do {
                        hallCode = random.nextInt(99);
                        siteCode = random.nextInt(3);
                    } while (hallUsed[hallCode] && siteUsed[siteCode]);
                    hallUsed[hallCode] = true;
                    siteUsed[siteCode] = true;
                    hallId = hallIds[hallCode];
                    siteId = siteIds[siteCode];
                    hallService.insertSingle(siteId, hallId, lanId);
                }
                String seat;
                if (count < 10) seat = "0" + count;
                else seat = "" + count;
                String admission = siteId + lanId + hallId + seat;
                String stuId = stuIds[j];
                infoService.insertSingle(admission, time, stuId, siteId, hallId, seat);
                if (count == 30) count = 0;
            }
        }
        request.getRequestDispatcher("/info/alert.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected int[] getNumPerLan() {
        List<Integer> nums = studentService.selectNumPerLan();
        int[] numPerLan = new int[nums.size()];
        int index = 0;
        for (Integer num : nums) {
            numPerLan[index++] = num;
        }
        return numPerLan;
    }

    protected String[] getLanIds(){
        List<String> ids = studentService.selectAllLanId();
        String[] lanIds = new String[ids.size()];
        int index = 0;
        for (String id : ids){
            lanIds[index++] = id;
        }
        return lanIds;
    }

    protected String[] getHallIds() {
        String[] hallIds = new String[99];
        for (int i = 0; i < hallIds.length; i++) {
            if (i < 9) {
                hallIds[i] = "0" + (i + 1);
            } else {
                hallIds[i] = "" + (i + 1);
            }
        }
        return hallIds;
    }

    protected String[] getSiteIds() {
        List<Site> sites = siteService.selectAll();
        String[] siteIds = new String[3];
        int index = 0;
        for (Site site : sites) {
            siteIds[index++] = site.getSiteId();
        }
        return siteIds;
    }

    protected String[] getStuIds(String lanId) {
        List<Student> students = studentService.selectAllInLanId(lanId);
        String[] stuIds = new String[students.size()];
        int index = 0;
        for (Student student : students) {
            stuIds[index++] = student.getStuId();
        }
        return stuIds;
    }
}
