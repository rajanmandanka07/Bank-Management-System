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
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Asus
 */
public class NewServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String url = "jdbc:mysql://localhost:3306/bank1"; // URL of the MySQL database
		String user = "root"; // MySQL username
		String password = ""; // MySQL password
		Connection con = null;
		PreparedStatement pstmt = null;
                ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
                        String query1 = "SELECT * FROM accounts WHERE acc_no = ?";
			pstmt = con.prepareStatement(query1);
			pstmt.setString(1, request.getParameter("acc_no"));
			rs = pstmt.executeQuery();
                        if (rs.next()){
                            RequestDispatcher rd;
                            rd=request.getRequestDispatcher("existsAccount.jsp");
                            rd.forward(request, response);
                        }
                        else{
			String query = "INSERT INTO accounts (acc_no, name, atype, balance, password) VALUES (?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(query);
                        pstmt.setString(1, request.getParameter("acc_no"));
			pstmt.setString(2, request.getParameter("name"));
			pstmt.setString(3, request.getParameter("atype"));
                        pstmt.setInt(4, Integer.parseInt(request.getParameter("balance")));
			pstmt.setString(5, request.getParameter("password"));
			pstmt.executeUpdate();
                        out.println("<html>");
            out.println("<head>");
            out.println("<title>Account Information</title>");
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
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Account created successfully!</h1>");
            out.println("<h1 style=\"text-align: center; margin-top: 50px;\">Account Information</h1>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>Account Number</th>");
            out.println("<th>Account Name</th>");
            out.println("<th>Account Type</th>");
            out.println("<th>Balance</th>");
            out.println("<th>Password</th>");
            out.println("</tr>");
                out.println("<tr>");
                out.println("<td>" + request.getParameter("acc_no") + "</td>");
                out.println("<td>" + request.getParameter("name") + "</td>");
                out.println("<td>" + request.getParameter("atype") + "</td>");
                out.println("<td>" + request.getParameter("balance") + "</td>");
                out.println("<td>" + request.getParameter("password") + "</td>");
                out.println("</tr>");
            out.println("</table>");
            out.println("<div class=\"container\">\n" +
"    <div class=\"btn-container\">\n" +
"      <button onclick=\"location.href='index.html'\">Home</button>\n" +
"    </div>\n" +
"  </div>");
            out.println("</body>");
            out.println("</html>");
                        }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
        processRequest(request, response);
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
