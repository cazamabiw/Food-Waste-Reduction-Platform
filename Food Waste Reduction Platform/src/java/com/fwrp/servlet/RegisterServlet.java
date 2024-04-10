/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.fwrp.servlet;

import com.fwrp.datatier.controller.UserController;
import com.fwrp.models.User;
import com.fwrp.user.factory.CharitableOrganizationCreationDTO;
import com.fwrp.user.factory.ConsumerCreationDTO;
import com.fwrp.user.factory.RetailerCreationDTO;
import com.fwrp.utilities.Result;
import com.fwrp.utilities.UserType;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cazam
 */
public class RegisterServlet extends HttpServlet {
    private final UserController userController = new UserController();
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
            out.println("<title>Servlet RegisterServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath() + "</h1>");
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
       String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String phone = request.getParameter("phone");
    String city = request.getParameter("city");
    String province = request.getParameter("province");
    String postalCode = request.getParameter("postalCode");
    String userType = request.getParameter("userType");

    // Additional fields based on user type
    String storeName = request.getParameter("storeName");
    String contactPerson = request.getParameter("contactPerson");
    String shippingAddress = request.getParameter("shippingAddress");
    String paymentMethod = request.getParameter("paymentMethod");
    String organizationName = request.getParameter("organizationName");

    // Create a user object based on the retrieved parameters

     Result result =  new  Result();
     if ("retailer".equals(userType)) {
RetailerCreationDTO user = new RetailerCreationDTO();
    user.setFirstName(firstName);
    user.setLastName(lastName);
    user.setEmail(email);
    user.setPassword(password);
    user.setPhoneNumber(phone);
    user.setCity(city);
    user.setProvince(province);
    user.setPostalCode(postalCode);
    user.setContactPerson(contactPerson);
    user.setStoreName(storeName);
      user.setRoleName(UserType.RETAILER);
       result =        userController.createUser(user);
    } else if ("consumer".equals(userType)) {
     ConsumerCreationDTO user = new ConsumerCreationDTO();
    user.setFirstName(firstName);
    user.setLastName(lastName);
    user.setEmail(email);
    user.setPassword(password);
    user.setPhoneNumber(phone);
    user.setCity(city);
    user.setProvince(province);
    user.setPostalCode(postalCode);
    user.setPaymentMethod(paymentMethod);
    user.setShippingAddress(shippingAddress);
      user.setRoleName(UserType.CONSUMER);
       result =        userController.createUser(user);
           
    } else if ("charitable".equals(userType)) {
           CharitableOrganizationCreationDTO user = new CharitableOrganizationCreationDTO();
    user.setFirstName(firstName);
    user.setLastName(lastName);
    user.setEmail(email);
    user.setPassword(password);
    user.setPhoneNumber(phone);
    user.setCity(city);
    user.setProvince(province);
    user.setPostalCode(postalCode);
    user.setOrganizationName(organizationName);
    user.setRoleName(UserType.CHARITABLE_ORGANIZATION);
     result =       userController.createUser(user);
    }

response.sendRedirect("/Food_Waste_Reduction_Platform/views/login.jsp");
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
