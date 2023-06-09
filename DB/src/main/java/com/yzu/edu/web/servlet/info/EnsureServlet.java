package com.yzu.edu.web.servlet.info;

import com.yzu.edu.pojo.Info;
import com.yzu.edu.service.InfoService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/servlet/info/ensureServlet")
public class EnsureServlet extends HttpServlet {
    private InfoService service = new InfoService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Info> infos = service.selectAll();
        Info info = new Info();
        for (Info temp : infos) {
            info = temp;
            break;
        }
        if (info.getAdmission() != null) {
            request.getRequestDispatcher("/info/ensure.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/servlet/info/generateAllServlet").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
