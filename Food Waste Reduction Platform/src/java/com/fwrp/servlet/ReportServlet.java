/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.fwrp.servlet;
//import org.apache.pdfbox.pdmodel.*;
//import org.apache.pdfbox.pdmodel.font.*;
//import org.apache.pdfbox.pdmodel.PDPageContentStream;
//import org.apache.pdfbox.pdmodel.font.PDType1Font;
import com.fwrp.datatier.controller.ReportController;
import com.fwrp.datatier.dto.InventoryHistoryDetailDTO;
import com.fwrp.datatier.dto.InventorySummaryReportDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cazam
 */
public class ReportServlet extends HttpServlet {
     private final ReportController reportController = new ReportController();
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
            out.println("<title>Servlet ReportServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ReportServlet at " + request.getContextPath() + "</h1>");
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
             Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1); // Set the day of the month to 1 (start of the month)
        Date startDate = calendar.getTime(); // Start date is the 1st day of the current month

        // Move to the next month
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DATE, -1); // Move back one day to get the last day of the current month
        Date endDate = calendar.getTime(); // End date is the last day of the current month

//        
      
            InventorySummaryReportDTO  report = reportController.generateSummaryReport( startDate,  endDate) ;
            // Generate PDF
//    PDDocument document = new PDDocument();
//    PDPage page = new PDPage();
//    document.addPage(page);
//
//    try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
//        contentStream.beginText();
//        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
//        contentStream.newLineAtOffset(100, 700);
//        contentStream.showText("Inventory Summary Report");
//        contentStream.endText();
//
//        // Add more text and data from the report to the content stream
//
//        contentStream.close();
//    }
//
//    // Save PDF to output stream
//    response.setContentType("application/pdf");
//    response.setHeader("Content-Disposition", "attachment; filename=inventory_summary_report.pdf");
//    document.save(response.getOutputStream());
//
//    // Close the document
//    document.close();
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
