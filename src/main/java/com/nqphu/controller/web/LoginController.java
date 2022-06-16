package com.nqphu.controller.web;

import com.nqphu.model.ProfileModel;
import com.nqphu.service.ProfileService;
import com.nqphu.utils.FormUtil;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/login-page"})
public class LoginController extends HttpServlet {
    private ProfileService profileService = new ProfileService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("views/web/login.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null && action.equals("login")) {
            ProfileModel pro;
            pro = FormUtil.toModel(ProfileModel.class, req);
            pro = profileService.findByUserNameAndPassword(pro.getUsername(), pro.getPwd());
            if (pro == null) {
                resp.sendRedirect("/login-page");
            }
            else {
                resp.sendRedirect("/profile-detail-page?id="+pro.getId());
            }
        }
    }
    
    
}
