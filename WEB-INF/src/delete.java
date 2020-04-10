import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class delete extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		int roll=Integer.parseInt(req.getParameter("roll"));
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123456");
			Statement stmt=con.createStatement();
			String q2="delete from studet where roll="+roll;
			int t=stmt.executeUpdate(q2);
			if(t>0)
			{
				pw.println("<center><h3>Deleted Successfully</center>");
				con.close();
			}
		}
		catch(Exception e)
		{
			pw.println(e);
		}
	}
}
		