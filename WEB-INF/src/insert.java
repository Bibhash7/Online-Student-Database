import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class insert extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		int roll=Integer.parseInt(req.getParameter("roll"));
		String nm=req.getParameter("nm");
		String gen=req.getParameter("gen");
		String crs=req.getParameter("crs");
		String yr=req.getParameter("yr");
		String ht=req.getParameter("ht");
		double marks=Double.parseDouble(req.getParameter("marks"));
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123456");
			Statement stmt=con.createStatement();
			String q1="insert into studet values("+roll+",'"+nm+"','"+gen+"','"+crs+"','"+yr+"','"+ht+"',"+marks+")";
			int t=stmt.executeUpdate(q1);
			if(t>0)
			{
				pw.println("<center><h3>Inserted Successfully</center>");
				con.close();
			}
		}
		catch(Exception e)
		{
			pw.println(e);
		}
	}
}
			