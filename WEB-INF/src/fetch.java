import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class fetch extends HttpServlet
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
			String q2="select *from studet where roll="+roll;
			ResultSet rs=stmt.executeQuery(q2);
			if(rs.next())
			{
				pw.println("Roll No:"+rs.getInt(1)+"<br>");
				pw.println("Name::"+rs.getString(2)+"<br>");
				pw.println("Gender:"+rs.getString(3)+"<br>");
				pw.println("Course:"+rs.getString(4)+"<br>");
				pw.println("Year:"+rs.getString(5)+"<br>");
				pw.println("HomeTown:"+rs.getString(6)+"<br>");
				pw.println("CGPA:"+rs.getDouble(7)+"<br>");
				con.close();
			}
			else
			{
				pw.println("<center><h3>Invalid Eid::</center>");
			}
		}
		catch(Exception e)
		{
			pw.println(e);
		}
	}
}