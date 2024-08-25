/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Asus
 */
public class displayServlet extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String r=String.valueOf(request.getAttribute("acc_no"));
        
        String url = "jdbc:mysql://localhost:3306/bank1"; // URL of the MySQL database
		String user = "root"; // MySQL username
		String password = ""; // MySQL password
		Connection con = null;
		PreparedStatement pstmt = null;
                ResultSet rs = null;
                String s1 = null;
                String s2 = null;
                String s3 = null;
                String s4 = null;
                String s5 = null;
                
        try (PrintWriter out = response.getWriter()) {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            String query1 = "SELECT * FROM accounts WHERE acc_no = ?";
            pstmt = con.prepareStatement(query1);
            pstmt.setString(1, r);
            rs = pstmt.executeQuery();
            while (rs.next()) {
            s1 = rs.getString("acc_no");
            s2 = rs.getString("name");
            s3 = rs.getString("atype");
            s4 = rs.getString("balance");
      }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<style>");
            out.println("table { border-collapse: collapse; width: 100%; }");
            out.println("th, td { text-align: left; padding: 8px; }");
            out.println("th { background-color: #4CAF50; color: white; }");
            out.println("tr:nth-child(even) { background-color: #f2f2f2; }");
            out.println(".container {\n" +
"      display: flex;\n" +
"      flex-direction: column;\n" +
"      align-items: center;\n" +
"      margin-top: 50px;\n" +
"    }\n" +
"\n" +
"    button {\n" +
"      padding: 10px 20px;\n" +
"      font-size: 18px;\n" +
"      background-color: #007bff;\n" +
"      color: #fff;\n" +
"      border: none;\n" +
"      border-radius: 5px;\n" +
"      cursor: pointer;\n" +
"      transition: all 0.3s ease;\n" +
"    }\n" +
"\n" +
"    button:hover {\n" +
"      background-color: #0062cc;\n" +
"    }\n" +
"\n" +
"    .btn-container {\n" +
"      display: flex;\n" +
"      justify-content: space-between;\n" +
"    }\n" +
"\n" +
"    .btn-container button {\n" +
"      width: 180px;\n" +
"    }");
            out.println("</style>");
            out.println("<title>Servlet AccountServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 style=\"text-align: center; margin-top: 50px;\">Account Information</h1>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>Account Number</th>");
            out.println("<th>Account Name</th>");
            out.println("<th>Account Type</th>");
            out.println("<th>Balance</th>");
            out.println("</tr>");
                out.println("<tr>");
                out.println("<td>" + s1 + "</td>");
                out.println("<td>" + s2 + "</td>");
                out.println("<td>" + s3 + "</td>");
                out.println("<td>" + s4 + "</td>");
                out.println("</tr>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
            RequestDispatcher rd;
            request.setAttribute("acc_no",r);
            rd=request.getRequestDispatcher("edit.jsp");
            rd.include(request, response);  
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(displayServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(displayServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(displayServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(displayServlet.class.getName()).log(Level.SEVERE, null, ex);
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
