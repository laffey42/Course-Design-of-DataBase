package com.yzu.edu.web.servlet.student;

import com.yzu.edu.pojo.Student;
import com.yzu.edu.service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/servlet/student/updateSingleServlet")
public class UpdateSingleServlet extends HttpServlet {
    private StudentService service = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stuId = request.getParameter("stuId").trim();
        String stuName = new String(request.getParameter("stuName").getBytes("iso-8859-1"), "utf-8").trim();
        String lanId = request.getParameter("lanId");
        Student student = (Student) request.getSession(true).getAttribute("student");
        if (stuId.length() != 5) {
            request.getSession(true).setAttribute("stu_msg", "提示：学号长度应为5位！");
            request.getRequestDispatcher("/student/updateSingle.jsp").forward(request, response);
            return;
        } else if (stuName.contains(" ")) {
            request.getSession(true).setAttribute("stu_msg", "提示：姓名中不允许有空格！");
            request.getRequestDispatcher("/student/updateSingle.jsp").forward(request, response);
            return;
        } else for (int i = 0; i < stuId.length(); i++) {
            if (stuId.charAt(i) < '0' || stuId.charAt(i) > '9') {
                request.getSession(true).setAttribute("stu_msg", "提示：学号格式应全为数字！");
                request.getRequestDispatcher("/student/updateSingle.jsp").forward(request, response);
                return;
            }
        }
        if (stuId.equals(student.getStuId())) {
            stuId = null;
        }
        boolean notSame = true;
        if (stuId != null) {
            List<Student> students = service.selectAll();
            for(Student s : students) {
                if (stuId.equals(s.getStuId())) {
                    notSame = false;
                    break;
                }
            }
        }
        if (notSame) {
            service.updateSingle(stuId, stuName, lanId, student.getStuId());
            request.getRequestDispatcher("/servlet/student/selectAllServlet").forward(request, response);
        } else {
            request.getSession(true).setAttribute("stu_msg", "提示：学号不允许重复！");
            request.getRequestDispatcher("/student/updateSingle.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
