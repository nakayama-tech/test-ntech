package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="LoginServlet", urlPatterns="/login/*")

public class LoginServlet extends HttpServlet {
	
	//static final String LOGIN_SELECT = "select id, mail_address, pgp_sym_decrypt(password, 'nakayamatest') from login_table where mail_address = ? and password = ?;";
	static final String LOGIN_SELECT = "select mail_address, password from login_table where mail_address = ?";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
			out.println("Hello Servlet!");
	}
	@SuppressWarnings("resource")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//PrintWriter out = response.getWriter();
			String address = request.getParameter("address");
			String password = request.getParameter("password");
	        Connection db = null;
	        PreparedStatement stmt = null;
	        ResultSet rset = null;

			try {

				String psUrl = "jdbc:postgresql://192.168.230.100:9999/nakayama"; 
				String psUser = "postgres"; 
				String psPass = "postgres"; 
				Class.forName("org.postgresql.Driver");
				
				db = DriverManager.getConnection(psUrl, psUser, psPass);
				db.setAutoCommit(false);
				stmt = db.prepareStatement(LOGIN_SELECT);
				stmt.setString(1, address);
				rset = stmt.executeQuery();
				
				while(rset.next()) {
					if(!address.equals(rset.getString("mail_address"))) {
						throw new Exception("あどれすが ちがいます");
					}
					if(!password.equals(rset.getString("password"))) {
						throw new Exception("じゅもんが ちがいます");
					}

				}
				request.setAttribute("mailaddress", address);
				request.getRequestDispatcher("jsp/top.jsp").forward(request, response);

			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
	            try {
	                if(rset != null)rset.close();
	                if(stmt != null)stmt.close();
	                if(db != null)db.close();
	            }
	            catch (SQLException e){
	                e.printStackTrace();
	            }
			}
	}
}
