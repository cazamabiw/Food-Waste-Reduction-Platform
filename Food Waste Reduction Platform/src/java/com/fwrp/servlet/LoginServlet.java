/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.fwrp.servlet;

import com.fwrp.datatier.controller.FoodController;
import com.fwrp.datatier.controller.InventoryController;
import com.fwrp.datatier.controller.UserController;
import com.fwrp.models.CharitableOrganization;
import com.fwrp.models.Consumer;
import com.fwrp.models.FoodItem;
import com.fwrp.models.FoodStatus;
import com.fwrp.models.Inventory;
import com.fwrp.models.Retailer;
import com.fwrp.models.User;
import com.fwrp.utilities.InventoryResult;
import com.fwrp.utilities.LoginResult;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cazam
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     private final UserController userController = new UserController();
          private final FoodController foodController = new FoodController();
      private final InventoryController inventoryController = new InventoryController();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
//        email = "bill@mail.com";
//                password = "123456";
        LoginResult loginResult = userController.Login(email, password);
      
        if (loginResult.isSuccess() == true) {
            // Redirect to success page
              HttpSession session = request.getSession();
       // session.setAttribute("userId", loginResult.getUserId());
          
        //int userId = (int) request.getSession().getAttribute("userId");

        User currentUser = userController.getCurrentUser(loginResult.getUserId());
        currentUser.setUserId(loginResult.getUserId());
        if (currentUser != null) {
            if (currentUser instanceof Retailer) {
                Retailer retailerUser = (Retailer) currentUser;

                session.setAttribute("currentUser", retailerUser);
                // Handle retailer-specific actions
            } else if (currentUser instanceof Consumer) {
                Consumer consumerUser = (Consumer) currentUser;
                session.setAttribute("currentUser", consumerUser);

            } else if (currentUser instanceof CharitableOrganization) {
                CharitableOrganization charitableOrganization = (CharitableOrganization) currentUser;

                session.setAttribute("currentUser", charitableOrganization);

            }

            if (currentUser != null) {
                // Get the role of the current user
                String roleName = userController.getRoleByUserId(loginResult.getUserId()).getRoleName();
                session.setAttribute("roleName", roleName);
                // Call different methods based on the user's role
                   if(roleName.equalsIgnoreCase("retailer")){
        List<InventoryResult> inventory = inventoryController.getInventoryByRetailerId(loginResult.getUserId());
    
    // Set inventory data in session attribute
    session.setAttribute("inventory", inventory);
                   }
                   else if(roleName.equalsIgnoreCase("consumer") || roleName.equalsIgnoreCase("charitable_organization") )
                   {
                             List<InventoryResult> inventory = inventoryController.getSurplusInventory();
    
    // Set inventory data in session attribute
    session.setAttribute("inventory", inventory);
                   }
                   //foodController
                   
                  List<FoodStatus> foodStatuses =  foodController.getFoodStatuses();
                       session.setAttribute("foodStatuses", foodStatuses);
                     List<FoodItem> foodItems =  foodController.getFoodItems();
                                session.setAttribute("foodItems", foodItems);
                }

            } else {
                // Redirect to login page if user is not logged in
                response.sendRedirect("login.jsp");
            }
        
        
       //  RequestDispatcher dispatcher = request.getRequestDispatcher("InventoryServlet");
      //  dispatcher.forward(request, response);
  
          response.sendRedirect("/Food_Waste_Reduction_Platform/views/inventory.jsp");
           
        } else {
            // Redirect to login page with error message
          response.sendRedirect("views/login.jsp?error=" + loginResult.getMessage());
        }
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
