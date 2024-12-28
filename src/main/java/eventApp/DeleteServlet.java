package eventApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet{

	Connection con = null;
	PreparedStatement ps = null ;
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =  DriverManager.getConnection("jdbc:mysql://locahost:3306/emss","root","root");
			ps = con.prepareStatement("delete from ems where id=?");
			ps.setInt(1, id);
			int row  = ps.executeUpdate();
			PrintWriter pw = res.getWriter();
			pw.write("<h1>Event Deleted Successfully");
			RequestDispatcher rd = req.getRequestDispatcher("allEvents");
			rd.forward(req, res);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
