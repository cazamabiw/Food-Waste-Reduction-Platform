/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.fwrp.servlet;

import com.fwrp.datatier.controller.InventoryController;
import com.fwrp.datatier.controller.UserSettingController;
import com.fwrp.models.Retailer;
import com.fwrp.models.User;
import com.fwrp.models.UserNotificationSetting;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cazam
 */
public class SettingNotificationServlet extends HttpServlet {
      private final UserSettingController userSettingController = new UserSettingController();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SettingNotificationServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SettingNotificationServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             HttpSession session = request.getSession();
        String isEmailValue = request.getParameter("isEmail");
          String isSMSValue = request.getParameter("isSms");
        
        

 

boolean isEmail = (isEmailValue != null && isEmailValue.equals("on"));
boolean isSMS = (isSMSValue != null && isSMSValue.equals("on"));
    User currentUser = (User) session.getAttribute("currentUser");
    
   //  String roleName = (String) session.getAttribute("roleName");
    UserNotificationSetting setting = new UserNotificationSetting();
    setting.setEmail(isEmail);
    setting.setPhone(isSMS);
    setting.setUserId(currentUser.getUserId());

        
userSettingController.updateUserNotificationSetting(setting);
         response.sendRedirect("/Food_Waste_Reduction_Platform/views/usernotificationsetting.jsp");

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
