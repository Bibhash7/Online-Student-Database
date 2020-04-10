import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class edit extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("Text/html");
		PrintWriter pw=res.getWriter();
		int roll=Integer.parseInt(req.getParameter("roll"));
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123456");
			Statement stmt=con.createStatement();
			String q1="select roll,name,cgpa from studet where roll="+roll;
			ResultSet rs=stmt.executeQuery(q1);
			if(rs.next())
			{
				pw.println("<form action=update method=get>Roll<input type=text name=roll value="+rs.getInt(1)+" readonly><br>Name<input type=text name=nm value="+rs.getString(2)+"><br>CGPA<input type=text name=marks value="+rs.getDouble(3)+"><br><br><input type=submit value=edit></form>");
			}
			else
			{
				pw.println("Invalid Roll Number");
			}
		}
		catch(Exception e)
		{
			pw.println(e);
		}
	}
}