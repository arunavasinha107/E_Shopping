import java.io.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.*;//For getting the generic servlet class
import javax.servlet.http.*;//For getting the HttpServlet class
public class Add_to_cart extends HttpServlet
{
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw1=res.getWriter();
        String nm1=req.getParameter("cart");
       // pw1.println("<html><body bgcolor=skyblue>Welcome "+nm1+"<br> Enter your password: "+nm2+"<br> Address: "+nm3+"<br> Email: "+nm4+"<br> Security Question: "+nm5+"<br> Ans"+nm6+"<br> Hobbies: "+nm7+"</body></html>");//response from servlet
        try
        {
          HttpSession ses=req.getSession();
          String s1=(String)ses.getAttribute("mail");
          ses.setAttribute("prod",nm1);
          Class.forName("oracle.jdbc.driver.OracleDriver");
          Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Nayan");
          Statement stmt=con.createStatement();
          String q1="insert into cart values('"+s1+"','"+nm1+"')";
          int x=stmt.executeUpdate(q1);
           if(x>0)
           {
              pw1.println("Success");
           }
           else
         {
            pw1.println("Failure");
            con.close();
         }
    }
        catch(Exception e)
        {
            pw1.println(e);
        }
    }
}