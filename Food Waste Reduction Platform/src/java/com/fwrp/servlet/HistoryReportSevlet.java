/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.fwrp.servlet;

import com.fwrp.datatier.controller.ReportController;
import com.fwrp.datatier.dto.InventoryHistoryDetailDTO;
import com.mysql.cj.result.Row;
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
public class HistoryReportSevlet extends HttpServlet {
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
            out.println("<title>Servlet HistoryReportSevlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HistoryReportSevlet at " + request.getContextPath() + "</h1>");
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
        //        // Define the start and end dates for the report
       Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1); // Set the day of the month to 1 (start of the month)
        Date startDate = calendar.getTime(); // Start date is the 1st day of the current month

        // Move to the next month
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DATE, -1); // Move back one day to get the last day of the current month
        Date endDate = calendar.getTime(); // End date is the last day of the current month

//        
        List<InventoryHistoryDetailDTO> report =  reportController.generateHistoryReport(startDate, endDate);
        
//// Create a new Excel workbook
//Workbook workbook = new XSSFWorkbook();
//
//// Create a new Excel sheet
//Sheet sheet = workbook.createSheet("Inventory History Report");
//
//// Create header row
//Row headerRow = sheet.createRow(0);
//String[] headers = {"Item Name", "Quantity", "Date"};
//for (int i = 0; i < headers.length; i++) {
//    Cell cell = headerRow.createCell(i);
//    cell.setCellValue(headers[i]);
//}
//
//// Write data to Excel
//int rowNum = 1;
//for (InventoryHistoryDetailDTO item : report) {
//    Row row = sheet.createRow(rowNum++);
//    row.createCell(0).setCellValue(item.getItemName());
//    row.createCell(1).setCellValue(item.getQuantity());
//    row.createCell(2).setCellValue(item.getDate().toString()); // Adjust date format as needed
//}
//
//// Save Excel file
//response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
//response.setHeader("Content-Disposition", "attachment; filename=inventory_report.xlsx");
//workbook.write(response.getOutputStream());
//workbook.close();
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
