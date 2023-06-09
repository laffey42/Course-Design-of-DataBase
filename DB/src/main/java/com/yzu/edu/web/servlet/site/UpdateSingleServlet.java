package com.yzu.edu.web.servlet.site;

import com.yzu.edu.pojo.Site;
import com.yzu.edu.service.SiteService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/servlet/site/updateSingleServlet")
public class UpdateSingleServlet extends HttpServlet {
    SiteService service = new SiteService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String siteId = request.getParameter("siteId");
        String siteName = new String(request.getParameter("siteName").getBytes("iso-8859-1"), "utf-8");
        Site site = (Site) request.getSession(true).getAttribute("site");
        if (siteId.equals(site.getSiteId())) {
            siteId = null;
        }
        boolean notSame = true;
        if (siteId != null) {
            List<Site> sites = service.selectAll();
            for( Site s : sites){
                if(siteId.equals(s.getSiteId())) {
                    notSame = false;
                    break;
                }
            }
        }
        if (notSame) {
            service.updateSingle(siteId, siteName, site.getSiteId());
            request.getRequestDispatcher("/servlet/site/selectAllServlet").forward(request, response);
        } else {
            request.getSession(true).setAttribute("site_msg", "提示：考场代码不允许重复！");
            request.getRequestDispatcher("/site/updateSingle.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
