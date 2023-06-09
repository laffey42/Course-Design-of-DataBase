package com.yzu.edu.web.servlet.info;

import com.yzu.edu.service.InfoService;
import com.yzu.edu.view.InfoView;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Locale;

@WebServlet("/servlet/info/selectSingleServlet")
public class SelectSingleServlet extends HttpServlet {
    private InfoService service = new InfoService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String admission = request.getParameter("admission").trim();
        String stuId = request.getParameter("stuId").trim();
        if(admission.equals("") && stuId.equals("")){
            request.getSession(true).setAttribute("info_msg", "提示：请输入至少一个信息！");
            request.getRequestDispatcher("/info/answer.jsp").forward(request, response);
        } else {
            InfoView infoView = service.viewSingle(admission, stuId);
            if (infoView == null){
                request.getSession(true).setAttribute("info_msg", "提示：学号或准考证号有误！");
                request.getRequestDispatcher("/info/answer.jsp").forward(request, response);
            } else {
                request.getSession(true).setAttribute("infoView", infoView);
                request.getRequestDispatcher("/info/selectSingle.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
