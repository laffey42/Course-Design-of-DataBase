package com.yzu.edu.web.servlet.student;

import com.github.javafaker.Faker;
import com.yzu.edu.pojo.Student;
import com.yzu.edu.service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/servlet/student/generateAllServlet")
public class GenerateAllServlet extends HttpServlet {
    private StudentService service = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num = request.getParameter("num");
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            if (ch < '0' || ch > '9'){
                request.getSession(true).setAttribute("errorMsg", "提示：请输入数字！");
                request.getRequestDispatcher("/student/generateAll.jsp").forward(request, response);
                return;
            }
        }
        int n = Integer.parseInt(num);
        if ( n < 0 || n > 60000) {
            request.getSession(true).setAttribute("errorMsg", "提示：数字过大！");
            request.getRequestDispatcher("/student/generateAll.jsp").forward(request, response);
            return;
        }
        service.deleteAll();
        Random random = new Random();
        Faker faker = new Faker(new Locale("zh-CN"));
        Set<String> stuIds = new HashSet<>();
        List<Student> students = new ArrayList<>();
        while (stuIds.size() < n) {
            int number = random.nextInt(90000) + 10000;
            String stuId = String.valueOf(number);
            if (!stuIds.contains(stuId)) {
                stuIds.add(stuId);
            }
        }
        for (String stuId : stuIds) {
            String stuName = faker.name().fullName();
            int Id = random.nextInt(6) + 1;
            String lanId = "0" + Id;
            Student student = new Student();
            student.setStuId(stuId);
            student.setStuName(stuName);
            student.setLanId(lanId);
            students.add(student);
        }
        for (Student student : students) {
            String stuId = student.getStuId();
            String stuName = student.getStuName();
            String lanId = student.getLanId();
            service.insertSingle(stuId, stuName, lanId);
        }
        request.getRequestDispatcher("/servlet/student/selectAllServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
