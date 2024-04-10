package com.fwrp.servlet;

import com.fwrp.datatier.controller.UserController;
import com.fwrp.datatier.dto.UserCreationDTO;
import com.fwrp.user.factory.CharitableOrganizationCreationDTO;
import com.fwrp.user.factory.ConsumerCreationDTO;
import com.fwrp.user.factory.RetailerCreationDTO;
import com.fwrp.utilities.Result;
import com.fwrp.utilities.UserType;
import static com.fwrp.utilities.UserType.CHARITABLE_ORGANIZATION;
import static com.fwrp.utilities.UserType.CONSUMER;
import static com.fwrp.utilities.UserType.RETAILER;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet responsible for handling user registration.
 */
public class RegistrationServlet extends HttpServlet {

    private  UserController userController = new UserController();
    
    
       /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            /* TODO process request */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistrationServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrationServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
   
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
    // Retrieve parameters from the registration form
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String addressLine = request.getParameter("addressLine");
    String city = request.getParameter("city");
    String province = request.getParameter("province");
    String postalCode = request.getParameter("postalCode");
    String phoneNumber = request.getParameter("phoneNumber");
    String userTypeStr = request.getParameter("userType");
    
    // Convert userTypeStr to UserType enum
    UserType userType = null;
    if (userTypeStr != null) {
        userTypeStr = userTypeStr.toLowerCase(); 
        if (userTypeStr.equals("retailer")) {
            userType = UserType.RETAILER;
        } else if (userTypeStr.equals("consumer")) {
            userType = UserType.CONSUMER;
        } else if (userTypeStr.equals("charitable")) {
            userType = UserType.CHARITABLE_ORGANIZATION;
        }
    }    
    // Create UserCreationDTO object based on user type
    UserCreationDTO userCreation = null;
    if (null != userType) switch (userType) {
            case RETAILER:
                RetailerCreationDTO retailerCreation = new RetailerCreationDTO();
                retailerCreation.setStoreName(request.getParameter("storeName"));
                retailerCreation.setContactPerson(request.getParameter("contactPerson"));
                userCreation = retailerCreation;
                break;
            case CONSUMER:
                ConsumerCreationDTO consumerCreation = new ConsumerCreationDTO();
                consumerCreation.setShippingAddress(request.getParameter("shippingAddress"));
                consumerCreation.setPaymentMethod(request.getParameter("paymentMethod"));
                userCreation = consumerCreation;
                break;
            case CHARITABLE_ORGANIZATION:
                CharitableOrganizationCreationDTO charitableCreation = new CharitableOrganizationCreationDTO();
                charitableCreation.setOrganizationName(request.getParameter("organizationName"));
                userCreation = charitableCreation;
                break;
            default:
                break;
        }
    
    
    if (userCreation != null) {
        userCreation.setFirstName(firstName);
        userCreation.setLastName(lastName);
        userCreation.setEmail(email);
        userCreation.setPassword(password);
        userCreation.setAddressLine(addressLine);
        userCreation.setCity(city);
        userCreation.setProvince(province);
        userCreation.setPostalCode(postalCode);
        userCreation.setPhoneNumber(phoneNumber);
        userCreation.setRoleName(userType);
        
        // Register the user
        Result registrationResult = userController.createUser(userCreation);
                
        if (registrationResult.isSuccess()) {
    HttpSession session = request.getSession();
    session.setAttribute("registration Success", true);
     System.out.println("Registration servlet doPost method executed");
}
        
      String redirectURL;
        switch (userType) {
            case RETAILER:
                redirectURL = "RetailerHomepage.jsp"; 
                break;
            case CONSUMER:
                redirectURL = "ConsumerHomepage.jsp";
                break;
            case  CHARITABLE_ORGANIZATION:
                redirectURL = "ChartyHomepage.jsp";
                break;
            default:
                redirectURL = "login.jsp"; 
                break;
        }
        response.sendRedirect(request.getContextPath() + redirectURL);
    } else {
            // Registration failed
          
            System.out.println("error creating ");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    
}

 

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
