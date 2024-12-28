package eventApp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.mysql.cj.protocol.Resultset;

@WebServlet("/updatepage")
public class UpdatePageServlet extends HttpServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int id  = Integer.parseInt(req.getParameter("id"));
//		Connection con = null;
//		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://locahost:3306/emss","root","root");
			PreparedStatement ps = con.prepareStatement("select * from ems where id =?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				req.setAttribute("rs",rs);
				RequestDispatcher rd = req.getRequestDispatcher("update.jsp");
				rd.forward(req, res);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
//		}finally{
//			if(rs !=null) {
//				try {
//					rs.close();
//				}catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if(ps !=null) {
//				try {
//					ps.close();
//				}catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if(con !=null) {
//				try {
//					con.close();
//				}catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
	}
}
}
