import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class dept extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		String crs=req.getParameter("crs");
		String yr=req.getParameter("yr");
		int i=1;
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123456");
			Statement stmt=con.createStatement();
			String q2="select name from studet where course='"+crs+"' and year='"+yr+"' order by cgpa desc";
			ResultSet rs=stmt.executeQuery(q2);
			while(rs.next())
			{
				pw.println("<h3>Name::"+rs.getString(1));
				pw.println("<h5>Rank:"+i);
				i++;
			}
			con.close();
		}
		catch(Exception e)
		{
			pw.println(e);
		}
	}
}