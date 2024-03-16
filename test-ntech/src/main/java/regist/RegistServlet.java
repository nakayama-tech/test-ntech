package regist;

import java.io.IOException;
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

@WebServlet("/regist")
public class RegistServlet extends HttpServlet {
	
	static final String LOGIN_INSERT = "insert into login_table(mail_address,password) values (?,?);";
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = request.getParameter("address");
		String password = request.getParameter("password");
        Connection db = null;
        ResultSet rset = null;
        PreparedStatement stmt = null;
		try {       
			String psUrl = "jdbc:postgresql://192.168.230.100:9999/nakayama"; 
			String psUser = "postgres"; 
			String psPass = "postgres";
			Class.forName("org.postgresql.Driver");
			db = DriverManager.getConnection(psUrl, psUser, psPass);
			
			stmt = db.prepareStatement(LOGIN_INSERT);
			stmt.setString(1, address);
			stmt.setString(2, password);
			stmt.executeUpdate();

			request.setAttribute("mailaddress", address);
			request.getRequestDispatcher("jsp/regist.jsp").forward(request, response);

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
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
