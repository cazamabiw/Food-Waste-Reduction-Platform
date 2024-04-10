/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.fwrp.servlet;

import com.fwrp.datatier.controller.InventoryController;
import com.fwrp.models.Inventory;
import com.fwrp.models.Retailer;
import com.fwrp.models.User;
import com.fwrp.utilities.DateTimeService;
import com.fwrp.utilities.InventoryResult;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cazam
 */
public class AddItemServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     
      private final InventoryController inventoryController = new InventoryController();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddItemServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddItemServlet at " + request.getContextPath() + "</h1>");
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
        Retailer currentUser = (Retailer) session.getAttribute("currentUser");
        
        

  int quantity = Integer.parseInt(request.getParameter("quantity"));

   int itemId = Integer.parseInt(request.getParameter("foodItemId"));

    double price = Double.parseDouble(request.getParameter("price"));
   int foodStatusId = Integer.parseInt(request.getParameter("foodStatusId")); // Assuming foodStatus is an integer

   String expirationDateString = request.getParameter("expirationDate");
    Date expirationDate = null;  
    try {
    expirationDate = new SimpleDateFormat("yyyy-MM-dd").parse(expirationDateString);
} catch (ParseException e) {
    // Handle invalid date format
    e.printStackTrace();
}
////
    Inventory inventory = new Inventory();
    inventory.setUserId(currentUser.getUserId());
       inventory.setUserId(currentUser.getUserId());
       inventory.setPrice(price);
       inventory.setExpirationDate(expirationDate);
       inventory.setFoodStatusId(foodStatusId);
       inventory.setQuantity(quantity);
       inventory.setFoodItemId(itemId);
      inventory.setLastUpdated(DateTimeService.getCurrentUtcDateTime());

    inventoryController.addInventory(inventory);

//// Set inventory data in session
//List<InventoryResult> inventoryList = inventoryController.getInventoryByRetailerId(currentUser.getUserId());
//session.setAttribute("inventory", inventoryList);
//
//// Forward the request to the JSP page
//request.getRequestDispatcher("../views/inventory.jsp").forward(request, response);

response.sendRedirect("/Food_Waste_Reduction_Platform/views/inventory.jsp");
//response.sendRedirect("inventory.jsp");
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
