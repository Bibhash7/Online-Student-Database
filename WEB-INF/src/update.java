import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class update extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("Text/html");
		PrintWriter pw=res.getWriter();
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123456");
			Statement stmt=con.createStatement();
			int roll=Integer.parseInt(req.getParameter("roll"));
			String nm=req.getParameter("nm");
			double marks=Double.parseDouble(req.getParameter("marks"));	
			String q1="update studet set name='"+nm+"',cgpa="+marks+" where roll="+roll;
			int t=stmt.executeUpdate(q1);
			if(t>0)
			{
				pw.println("Updated Successfully");
				con.close();
			}
		}
		catch(Exception e)
		{
			pw.println(e);
		}
	}
}
