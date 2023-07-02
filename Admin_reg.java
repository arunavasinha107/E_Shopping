import java.io.*;
import java.sql.*;
import javax.servlet.*;//For getting the generic servlet class
import javax.servlet.http.*;//For getting the HttpServlet class
public class Admin_reg extends HttpServlet
{
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw1=res.getWriter();
        String nm1=req.getParameter("n1");
        String nm2=req.getParameter("n2");
        String nm3=req.getParameter("n3");
        String nm4=req.getParameter("n4");
        String nm5=req.getParameter("n5");
        String nm6=req.getParameter("n6");
        String nm7=req.getParameter("n7");
        // pw1.println("<html><body bgcolor=skyblue>Welcome "+nm1+"<br> Enter your password: "+nm2+"<br> Address: "+nm3+"<br> Email: "+nm4+"<br> Security Question: "+nm5+"<br> Ans"+nm6+"<br> Hobbies: "+nm7+"</body></html>");//response from servlet
        try
        {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Nayan");
           Statement stmt=con.createStatement();
           String q1="insert into admin values('"+nm1+"','"+nm2+"','"+nm3+"','"+nm4+"','"+nm5+"','"+nm6+"','"+nm7+"')";
           int x=stmt.executeUpdate(q1);
           if(x>0)
           {
            pw1.println("<html>\n" +
"<head>\n" +
"    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css\" integrity=\"sha512-1sCRPdkRXhBV2PBLUdRb4tMg1w2YPf37qatUFeS7zlBy7jJI8Lf4VHwWfZZfpXtYSLy85pkm9GaYVYMfw5BC1A==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\n" +
"    <style>\n" +
"        \n" +
"    *{\n" +
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
"    /* login form styling*/\n" +
"\n" +
"    .loginform {\n" +
"        background-color: #C0EEC0;\n" +
"        height: 86%;\n" +
"        padding-left: 30%;\n" +
"        padding-top: 7em;\n" +
"    }\n" +
"    .forgetPass{\n" +
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
"    .loginform tr {\n" +
"        color: black;\n" +
"        font-family: 'Courier New', Courier, monospace;\n" +
"        font-size: 3rem;\n" +
"        font-weight: 550;\n" +
"        padding: 1.5rem;\n" +
"    }\n" +
"\n" +
"    .loginform td {\n" +
"        padding: 1.5rem;\n" +
"    }\n" +
"\n" +
"    .loginform tr td .submit{\n" +
"        background-color: rgb(22, 141, 232);\n" +
"        padding: 1rem;\n" +
"        font-family: 'Courier New', Courier, monospace;\n" +
"        color: white;\n" +
"        font-size: 1.7rem;\n" +
"        font-weight: 900;\n" +
"    }\n" +
"\n" +
"    .loginform td input {\n" +
"        border-radius: 2rem;\n" +
"        padding: 1rem;\n" +
"    }\n" +
"\n" +
"    </style>\n" +
"    <title>Login</title>\n" +
"</head>\n" +
"<body >\n" +
"\n" +
"<form method=\"post\" action=\"Admin_login\" class=\"loginform\">\n" +
"    <table >\n" +
"    <tr>\n" +
"    <td>Email id:</td>\n" +
"    <td><input type=\"text\" name=\"n1\"\n" +
"    placeholder=\"Type your Email id\"></td>\n" +
"    </tr>\n" +
"    <tr>\n" +
"    <td>Password:</td>\n" +
"    <td><input type=\"password\" name=\"n2\" placeholder=\"Type your password\"></td>\n" +
"    </tr>\n" +
"    <tr><td><input type=\"submit\" value=\"Sign in\"></td>\n" +
"    </tr>\n" +
"    </table>\n" +
"    <br>\n" +
"    <a href=\"Admin_forget_pass_1.html\" class=\"forgetPass\">Forget Password?</a>\n" +
"    </form>\n" +
"<footer class = \"footer\">\n" +
"    <div class=\"social-media-links\">\n" +
"        <i class=\"fa-brands fa-facebook fa-4x\"></i>\n" +
"        <i class=\"fa-brands fa-twitter fa-4x\"></i>\n" +
"        <i class=\"fa-brands fa-instagram fa-4x\"></i>\n" +
"    </div>\n" +
"    <p>Super Shopper &copy; 2023, All Rights Reserved</p>\n" +
"</footer>\n" +
"\n" +
"</body>\n" +
"</html>");
         }
          else
         {
            pw1.println("<html>\n" +
"<head><title>Registration</title>\n" +
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
"    /* user registration */\n" +
"    .reg {\n" +
"        background-color: #C0EEC0;\n" +
"        padding-left: 8rem;\n" +
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

"<form method=\"post\" action=\"Admin_reg\" class=\"reg\">\n" +
"<table>\n" +
"<tr>\n" +
"<td>Email:</td>\n" +
"<td><input type=\"text\" name=\"n1\" placeholder=\"Type your Email\">\n" +
"</td>\n" +
"</tr>\n" +
"<tr>\n" +
"<td>Name:</td>\n" +
"<td><input type=\"text\" name=\"n2\"\n" +
"placeholder=\"Type your Name\"></td>\n" +
"</tr>\n" +
"<tr>\n" +
"<td>Password:</td>\n" +
"<td><input type=\"password\" name=\"n3\"\n" +
"placeholder=\"Type your Password\"></td>\n" +
"</tr>\n" +
"<tr>\n" +
"<td>Qualification:</td>\n" +
"<td><input type=\"text\" name=\"n4\"\n" + 
"placeholder=\"Enter your qualification\"></td>\n" +
"</tr>\n" +
"<tr>\n" +
"<td>Contact No:</td>\n" +
"<td><input type=\"text\" name=\"n5\">\n" +
"</td>\n" +
"</tr>\n" +
"<tr><td><input type=\"submit\" value=\"submit\"></td>\n" +
"</tr>\n" +
"<tr>\n"+
"<font face=\"Arial\" size=\"6\" color=\"red\">FAILURE</font>\n" +
"</tr>\n"+
"</table>\n" +
"</form>\n" +
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
        catch(Exception e){
              pw1.println(e);
         }
    }
}