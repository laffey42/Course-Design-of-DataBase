package com.yzu.edu.web.servlet.student;

import com.yzu.edu.pojo.Student;
import com.yzu.edu.service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/servlet/student/deleteSingleServlet")
public class DeleteSingleServlet extends HttpServlet {
    private StudentService service = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = (Student) request.getSession(true).getAttribute("student");
        service.deleteSingle(student.getStuId());
        request.getRequestDispatcher("/servlet/student/selectAllServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
