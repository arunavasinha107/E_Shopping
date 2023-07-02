import java.io.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.*;//For getting the generic servlet class
import javax.servlet.http.*;//For getting the HttpServlet class
public class Admin_forget_pass_2 extends HttpServlet
{
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw1=res.getWriter();
        String nm2=req.getParameter("n2");
       // pw1.println("<html><body bgcolor=skyblue>Welcome "+nm1+"<br> Enter your password: "+nm2+"<br> Address: "+nm3+"<br> Email: "+nm4+"<br> Security Question: "+nm5+"<br> Ans"+nm6+"<br> Hobbies: "+nm7+"</body></html>");//response from servlet
        try
        {
            HttpSession ses=req.getSession();
            String s1=(String)ses.getAttribute("email");
            Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Nayan");
              Statement stmt=con.createStatement();
             String q1="Select * from admin where id='"+s1+"' and ans='"+nm2+"'";
             //pw1.println(q1);
             ResultSet rs=stmt.executeQuery(q1);
             if(rs.next())
             {
                 pw1.println("<html>\n" +
"<head><title>Forget_pass_1</title>\n" +
"<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css\" integrity=\"sha512-1sCRPdkRXhBV2PBLUdRb4tMg1w2YPf37qatUFeS7zlBy7jJI8Lf4VHwWfZZfpXtYSLy85pkm9GaYVYMfw5BC1A==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\n" +
"<style>\n" +
"        \n" +
"        *{\n" +
"        margin: 0;\n" +
"        padding: 0;\n" +
"        box-sizing: border-box;\n" +
"    }\n" +
"\n" +
"    html {\n" +
"        font-size: 62.5%;\n" +
"    }\n" +
"\n" +
"    body {\n" +
"        font-family: 'Montserrat', sans-serif;\n" +
"    }        \n" +
"    /* footer styling */\n" +
"    \n" +
"\n" +
"    .footer{\n" +
"        background-color: rgb(14, 1, 1);\n" +
"        text-align: center;\n" +
"        padding: 2rem;\n" +
"    }\n" +
"\n" +
"    .footer i {\n" +
"        padding-left: 3rem;\n" +
"        padding-bottom: 1.6rem;\n" +
"        color: white;\n" +
"    }\n" +
"\n" +
"    .footer p {\n" +
"        font-size: 2rem;\n" +
"        color: white;\n" +
"    }\n" +
"\n" +
"    /* forget password */\n" +
"    .forget {\n" +
"        background-color: #C0EEC0;\n" +
"        height: 86%;\n" +
"    }\n" +
"    table {\n" +
"        padding: 8rem;;\n" +
"    }\n" +
"    td {\n" +
"        font-size: 3rem;\n" +
"        font-family: 'Courier New', Courier, monospace;\n" +
"        font-weight: 500;\n" +
"        padding: 0.3rem;\n" +
"    }\n" +
"    td input {\n" +
"        border-radius: 2rem;;\n" +
"        font-size: 1.5rem;\n" +
"        padding: 1rem;\n" +
"    }\n" +
"    textarea {\n" +
"        border-radius: 2rem;\n" +
"        height: 9rem;\n" +
"        width: 18rem;\n" +
"\n" +
"    }\n" +
"\n" +
"  </style>\n" +
"</head>\n" +
"<body>\n" +
"    <form method=\"post\" action=\"Admin_forget_pass_3\" class=\"forget\">\n" +
"        <table>\n" +
"        <tr>\n" +
"        <td>New Password:</td>\n" +
"        <td><input type=\"password\" name=\"n1\"\n" +
"        placeholder=\"Enter new Password\"></td>\n" +
"        </tr>\n" +
"        <tr><td><input type=\"submit\" value=\"sign in\"></td>\n" +
"        </tr>\n" +
"        </table>\n" +
"    </form>\n" +
"<footer class = \"footer\">\n" +
"    <div class=\"social-media-links\">\n" +
"        <i class=\"fa-brands fa-facebook fa-4x\"></i>\n" +
"        <i class=\"fa-brands fa-twitter fa-4x\"></i>\n" +
"        <i class=\"fa-brands fa-instagram fa-4x\"></i>\n" +
"    </div>\n" +
"    <p>Super Shopper &copy; 2023, All Rights Reserved</p>\n" +
"</footer>\n" +
"</body>\n" +
"</html>");
             }
             else
             {
                 pw1.println("<html>\n" +
"<head><title>Forget_pass_2</title>\n" +
"<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css\" integrity=\"sha512-1sCRPdkRXhBV2PBLUdRb4tMg1w2YPf37qatUFeS7zlBy7jJI8Lf4VHwWfZZfpXtYSLy85pkm9GaYVYMfw5BC1A==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\n" +
"<style>\n" +
"        \n" +
"        *{\n" +
"        margin: 0;\n" +
"        padding: 0;\n" +
"        box-sizing: border-box;\n" +
"    }\n" +
"\n" +
"    html {\n" +
"        font-size: 62.5%;\n" +
"    }\n" +
"\n" +
"    body {\n" +
"        font-family: 'Montserrat', sans-serif;\n" +
"    }        \n" +
"    /* footer styling */\n" +
"    \n" +
"\n" +
"    .footer{\n" +
"        background-color: rgb(14, 1, 1);\n" +
"        text-align: center;\n" +
"        padding: 2rem;\n" +
"    }\n" +
"\n" +
"    .footer i {\n" +
"        padding-left: 3rem;\n" +
"        padding-bottom: 1.6rem;\n" +
"        color: white;\n" +
"    }\n" +
"\n" +
"    .footer p {\n" +
"        font-size: 2rem;\n" +
"        color: white;\n" +
"    }\n" +
"\n" +
"    /* forget password */\n" +
"    .forget {\n" +
"        background-color: #C0EEC0;\n" +
"        height: 86%;\n" +
"    }\n" +
"    table {\n" +
"        padding: 8rem;;\n" +
"    }\n" +
"    td {\n" +
"        font-size: 3rem;\n" +
"        font-family: 'Courier New', Courier, monospace;\n" +
"        font-weight: 500;\n" +
"        padding: 0.3rem;\n" +
"    }\n" +
"    td input {\n" +
"        border-radius: 2rem;;\n" +
"        font-size: 1.5rem;\n" +
"        padding: 1rem;\n" +
"    }\n" +
"    textarea {\n" +
"        border-radius: 2rem;\n" +
"        height: 9rem;\n" +
"        width: 18rem;\n" +
"\n" +
"    }\n" +
"\n" +
"  </style>\n" +
"</head>\n" +
"<body>\n" +
"    <form method=\"post\" action=\"Admin_forget_pass_1\" class=\"forget\">\n" +
"        <table>\n" +
"        <tr>\n" +
"           <td>Security Question:</td>\n" +
"       </tr>\n" +
"\n" +
"        <tr>\n" +
"            <td>Ans:</td>\n" +
"            <td><input type=\"text\" name=\"n2\"></td>\n" +
"        </tr>\n" +
"        <tr><td><input type=\"submit\" value=\"sign in\"></td>\n" +
"        </tr>\n" +
"        <tr>\n"+
"        <font face=\"Arial\" size=\"6\" color=\"red\">Fetch Unsccess</font>\n" +
"        </tr>\n"+
"        </table>\n" +
"    </form>\n" +
"<footer class = \"footer\">\n" +
"    <div class=\"social-media-links\">\n" +
"        <i class=\"fa-brands fa-facebook fa-4x\"></i>\n" +
"        <i class=\"fa-brands fa-twitter fa-4x\"></i>\n" +
"        <i class=\"fa-brands fa-instagram fa-4x\"></i>\n" +
"    </div>\n" +
"    <p>Super Shopper &copy; 2023, All Rights Reserved</p>\n" +
"</footer>\n" +
"</body>\n" +
"</html>");
                 con.close();
             }
             }
        catch(Exception e)
        {
            pw1.println(e);
        }
    }
}