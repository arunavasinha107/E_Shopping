import java.io.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.*;//For getting the generic servlet class
import javax.servlet.http.*;//For getting the HttpServlet class
public class user_forget_pass_3 extends HttpServlet
{
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw1=res.getWriter();
        String nm1=req.getParameter("n1");
        try
        {
            HttpSession ses=req.getSession();
            String s1=(String)ses.getAttribute("email");
            Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Nayan");
              Statement stmt=con.createStatement();
             String q1="update customer set password='"+nm1+"' where id='"+s1+"'";
             //pw1.println(q1);
             int x=stmt.executeUpdate(q1);
             if(x>0)
             {
                 pw1.println("<html>\n" +
"    <head>\n" +
"        <title>Forget_pass_2</title>\n" +
"       <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css\" integrity=\"sha512-1sCRPdkRXhBV2PBLUdRb4tMg1w2YPf37qatUFeS7zlBy7jJI8Lf4VHwWfZZfpXtYSLy85pkm9GaYVYMfw5BC1A==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\n" +
"  <style>\n" +
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
"    .backtologin{\n" +
"        color: rgb(3, 48, 247);\n" +
"        margin-top: 3rem;\n" +
"        font-size: 1.5rem;\n" +
"        text-decoration: none;\n" +
"        background-color: #C0EEC0;\n" +
"        border-style: solid;\n" +
"        border-color: white;\n" +
"        margin-top: 4rem;\n" +
"        margin-left: 1.5rem;\n" +
"        padding: 0.5rem;\n" +
"        border-radius: 2rem;\n" +
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
"        <form class=\"forget\">\n" +
"        <table>\n" +
"            <tr>\n" +
"            <td><font face=\"Arial\" size=\"15\" color=\"red\">\n" +
"                Updated Successfully</font></td>\n" +
"            </tr>\n" +
"        <br>\n" +
"        <tr>\n" +
"            <td><a href=\"user_login.html\" class=\"backtologin\"><font face=\"Arial\" size=\"5\" color=\"blue\">Back to Login</td></font></a></tr>\n" +
"        </table>\n" +
"        </form>\n" +
"    <footer class = \"footer\">\n" +
"    <div class=\"social-media-links\">\n" +
"        <i class=\"fa-brands fa-facebook fa-4x\"></i>\n" +
"        <i class=\"fa-brands fa-twitter fa-4x\"></i>\n" +
"        <i class=\"fa-brands fa-instagram fa-4x\"></i>\n" +
"    </div>\n" +
"    <p>Super Shopper &copy; 2023, All Rights Reserved</p>\n" +
"</footer>\n" +
"    </body>\n" +
"</html>");
             }
             else
             {
                 pw1.println("<html>\n" +
"    <head>\n" +
"        <title>Forget_pass_2</title>\n" +
"       <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css\" integrity=\"sha512-1sCRPdkRXhBV2PBLUdRb4tMg1w2YPf37qatUFeS7zlBy7jJI8Lf4VHwWfZZfpXtYSLy85pkm9GaYVYMfw5BC1A==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\n" +
"  <style>\n" +
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
"    .backtologin{\n" +
"        color: rgb(3, 48, 247);\n" +
"        margin-top: 3rem;\n" +
"        font-size: 1.5rem;\n" +
"        text-decoration: none;\n" +
"        background-color: #C0EEC0;\n" +
"        border-style: solid;\n" +
"        border-color: white;\n" +
"        margin-top: 4rem;\n" +
"        margin-left: 1.5rem;\n" +
"        padding: 0.5rem;\n" +
"        border-radius: 2rem;\n" +
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
"        <form class=\"forget\">\n" +
"        <table>\n" +
"            <tr>\n" +
"            <td><font face=\"Arial\" size=\"15\" color=\"red\">\n" +
"                Updated Successfully</font></td>\n" +
"            </tr>\n" +
"        <br>\n" +
"        <tr>\n" +
"            <td><a href=\"user_login.html\" class=\"backtologin\"><font face=\"Arial\" size=\"5\" color=\"blue\">Back to Login</td></font></a></tr>\n" +
"        </table>\n" +
"        </form>\n" +
"    <footer class = \"footer\">\n" +
"    <div class=\"social-media-links\">\n" +
"        <i class=\"fa-brands fa-facebook fa-4x\"></i>\n" +
"        <i class=\"fa-brands fa-twitter fa-4x\"></i>\n" +
"        <i class=\"fa-brands fa-instagram fa-4x\"></i>\n" +
"    </div>\n" +
"    <p>Super Shopper &copy; 2023, All Rights Reserved</p>\n" +
"</footer>\n" +
"    </body>\n" +
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

