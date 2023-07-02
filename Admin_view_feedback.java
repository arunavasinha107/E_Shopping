import java.io.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.*;//For getting the generic servlet class
import javax.servlet.http.*;//For getting the HttpServlet class
public class Admin_view_feedback extends HttpServlet
{
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw1=res.getWriter();
       // pw1.println("<html><body bgcolor=skyblue>Welcome "+nm1+"<br> Enter your password: "+nm2+"<br> Address: "+nm3+"<br> Email: "+nm4+"<br> Security Question: "+nm5+"<br> Ans"+nm6+"<br> Hobbies: "+nm7+"</body></html>");//response from servlet
        try
        {
            HttpSession ses=req.getSession();
            String s2=(String)ses.getAttribute("id");
            Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Nayan");
              Statement stmt=con.createStatement();
             String q1="Select * from feedback_1 where id='"+s2+"'";
             //pw1.println(q1);
             ResultSet rs=stmt.executeQuery(q1);
             if(rs.next())
             {
                 pw1.println("");
             }
             else
             {
                 pw1.println("");
                 con.close();
             }
             }
        catch(Exception e)
        {
            pw1.println(e);
        }
    }
}