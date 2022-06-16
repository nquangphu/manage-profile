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

@WebServlet(urlPatterns = {"/profile-detail-page"})
public class ProfileDetailController extends HttpServlet {

    private ProfileService profileService = new ProfileService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String action = req.getParameter("action");
//        if (action != null && action.equals("login")) {
//            RequestDispatcher rd = req.getRequestDispatcher("views/web/login.jsp");
//            rd.forward(req, resp);
//        } else if (action != null && action.equals("logout")) {
//
//        } else {
            String id = req.getParameter("id");
            
            ProfileModel pm = profileService.getProfile(Integer.parseInt(id));
            req.setAttribute("profile", pm);

            RequestDispatcher rd = req.getRequestDispatcher("views/web/profile-detail.jsp");
            rd.forward(req, resp);
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        

    }
}
