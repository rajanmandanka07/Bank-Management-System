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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Asus
 */
public class ChangePasswordServlet extends HttpServlet {

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
        String url = "jdbc:mysql://localhost:3306/bank1"; // URL of the MySQL database
        String user = "root"; // MySQL username
        String password = ""; // MySQL password
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ChangePassword</title>");
out.println("<style>\n" +
"    body {\n" +
"      font-family: Arial, sans-serif;\n" +
"      margin: 0;\n" +
"      padding: 0;\n" +
"    }\n" +
"\n" +
"    h1 {\n" +
"      text-align: center;\n" +
"      margin-top: 50px;\n" +
"    }\n" +
"\n" +
"    .container {\n" +
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
"      width: 400px;\n" +
"      margin-top: 30px;\n" +
"    }\n" +
"\n" +
"    .btn-container button {\n" +
"      width: 180px;\n" +
"    }\n" +
"  </style>");            
            out.println("</head>");
            out.println("<body>");
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            String accountNumber = request.getParameter("acc_no");
            String newpassword = request.getParameter("password");
            String currpassword = request.getParameter("currpassword");
            String confirmpassword = request.getParameter("confirmpassword");
            String query = "SELECT balance FROM accounts WHERE acc_no = ?";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1,Integer.parseInt(accountNumber) );
            rs = pstmt.executeQuery();
            if (rs.next()) {
                if(newpassword.equals(confirmpassword)){
                query = "UPDATE accounts SET password = ? WHERE acc_no = ?";
                    pstmt = con.prepareStatement(query);
                    pstmt.setString(1, newpassword);
                    pstmt.setInt(2,Integer.parseInt(accountNumber) );
                    pstmt.executeUpdate();
                    response.getWriter().println("<h1>Password Changed successful! New Password is " + newpassword + "</h2>");}
                else{
                    out.println("<h1>Please enter valid password.</h1>");
                }
            }
            HttpSession session = request.getSession();
            session.setAttribute("acc_no", accountNumber);
            out.println("<div class=\"container\">\n" +
"    <div class=\"btn-container\">\n" +
"      <button onclick=\"location.href='index.html'\">Logout</button>\n" +
"      <button onclick=\"location.href='newjsp.jsp'\">Options</button>\n" +
"    </div>\n" +
"  </div>");
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChangePasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ChangePasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ChangePasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ChangePasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
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
