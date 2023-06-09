package com.yzu.edu.web.servlet.student;

import com.yzu.edu.pojo.Student;
import com.yzu.edu.service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/servlet/student/selectSingleServlet")
public class SelectSingleServlet extends HttpServlet {
    private StudentService service = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stuId = request.getParameter("stuId");
        String action = request.getParameter("action");
        Student student = service.selectSingle(stuId);
        System.out.println(student);
        request.getSession(true).setAttribute("student", student);
        if (action.equals("update")) {
            request.getRequestDispatcher("/student/updateSingle.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/student/deleteSingle.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
