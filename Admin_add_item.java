import java.io.*;
import java.sql.*;
import javax.servlet.*;//For getting the generic servlet class
import javax.servlet.http.*;//For getting the HttpServlet class
public class Admin_add_item extends HttpServlet
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
        // pw1.println("<html><body bgcolor=skyblue>Welcome "+nm1+"<br> Enter your password: "+nm2+"<br> Address: "+nm3+"<br> Email: "+nm4+"<br> Security Question: "+nm5+"<br> Ans"+nm6+"<br> Hobbies: "+nm7+"</body></html>");//response from servlet
        try
        {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Nayan");
           Statement stmt=con.createStatement();
           String q1="insert into product values('"+nm1+"','"+nm2+"','"+nm3+"','"+nm4+"')";
           int x=stmt.executeUpdate(q1);
           if(x>0)
           {
            pw1.println("<html>\n" +
"    <head>\n" +
"        <title>Add_Update_Delete</title>\n" +
"       <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css\" integrity=\"sha512-1sCRPdkRXhBV2PBLUdRb4tMg1w2YPf37qatUFeS7zlBy7jJI8Lf4VHwWfZZfpXtYSLy85pkm9GaYVYMfw5BC1A==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\n" +
"  <style>\n" +
"        /* Header styling */\n" +
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
"    header {\n" +
"        background-color: black;\n" +
"    }\n" +
"\n" +
"    .navbar {\n" +
"        font-size: 2rem;\n" +
"        display: flex;\n" +
"        padding-left: 6rem;\n" +
"        padding-top: 2rem;\n" +
"        padding-bottom: 3rem;\n" +
"        align-items: center;\n" +
"        justify-content: space-between;\n" +
"    }\n" +
"\n" +
"    .navbar .logo {\n" +
"        text-transform: uppercase;\n" +
"    }\n" +
"\n" +
"    .navbar .logo .first{\n" +
"        color: red;\n" +
"    }\n" +
"\n" +
"    .navbar .logo .second {\n" +
"        color: yellow;\n" +
"    }\n" +
"\n" +
"    .navbar ul{\n" +
"        display: flex;\n" +
"        justify-content: space-between;\n" +
"    }\n" +
"\n" +
"    .navbar ul li {\n" +
"        border: 2px soid white;\n" +
"        list-style-type: none;\n" +
"        display: inline-block;\n" +
"        margin-right: 8rem;\n" +
"        border-bottom: none;\n" +
"    }\n" +
"\n" +
"    .navbar ul li a {\n" +
"        text-transform: uppercase;\n" +
"        color: white;\n" +
"        font-weight: 500;\n" +
"        text-decoration: none;\n" +
"    }\n" +
"\n" +
"    .navbar ul li input {\n" +
"        padding: 0.5rem;\n" +
"        border-radius: 1em;\n" +
"    }\n" +
"\n" +
"    .navbar ul li a:hover {\n" +
"        color: red;\n" +
"    }\n" +
"\n" +
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
"    /*add,update and delete operation*/\n" +
"    .add_update_delete {\n" +
"        background-color: #C0EEC0;\n" +
"        display:flex;\n" +
"        height: 70%;\n" +
"    }\n" +
"    .Add_item{\n" +
"        color: rgb(3, 48, 247);\n" +
"        margin-top: 3rem;\n" +
"        font-size: 1.5rem;\n" +
"        text-decoration: none;\n" +
"        background-color: #C0EEC0;\n" +
"        border-style: solid;\n" +
"        border-color: red;\n" +
"        margin-top: 4rem;\n" +
"        margin-left: 50rem;\n" +
"        padding: 0.5rem;\n" +
"        border-radius: 2rem;\n" +
"        text-align: center;\n" +
"    }\n" +
"    .Update_item{\n" +
"        color: rgb(3, 48, 247);\n" +
"        margin-top: 3rem;\n" +
"        font-size: 1.5rem;\n" +
"        text-decoration: none;\n" +
"        background-color: #C0EEC0;\n" +
"        border-style: solid;\n" +
"        border-color: red;\n" +
"        margin-top: 4rem;\n" +
"        margin-left: 50rem;\n" +
"        padding: 0.5rem;\n" +
"        border-radius: 2rem;\n" +
"    }\n" +
"    .Multiple_update{\n" +
"        color: rgb(3, 48, 247);\n" +
"        margin-top: 3rem;\n" +
"        font-size: 1.5rem;\n" +
"        text-decoration: none;\n" +
"        background-color: #C0EEC0;\n" +
"        border-style: solid;\n" +
"        border-color: red;\n" +
"        margin-top: 4rem;\n" +
"        margin-left: 50rem;\n" +
"        padding: 0.5rem;\n" +
"        border-radius: 2rem;\n" +
"    }\n" +
"    .Delete_item{\n" +
"        color: rgb(3, 48, 247);\n" +
"        margin-top: 3rem;\n" +
"        font-size: 1.5rem;\n" +
"        text-decoration: none;\n" +
"        background-color: #C0EEC0;\n" +
"        border-style: solid;\n" +
"        border-color: red;\n" +
"        margin-top: 4rem;\n" +
"        margin-left: 50rem;\n" +
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
"    <header>\n" +
"        <div class=\"navbar\">\n" +
"            <h2 class = 'logo'> <span class = 'first'>Super</span> <span class = 'second'>Shopper</span></h2>\n" +
"            <ul>\n" +
"                <li><a href=\"Home.html\">Home</a></li>\n" +
"                <li><a href=\"About.html\">about</a></li>\n" +
"                <li><a href=\"Contact.html\">contact</a></li>\n" +
"                <li><a href=\"Admin_login.html\">log out</a></li>\n" +
"            </ul>\n" +
"        </div>\n" +
"    </header>\n" +
"        <form class=\"add_update_delete\">\n" +
"        <table>\n" +
"        <tr>\n" +
"            <td><a href=\"Admin_add_item.html\" class=\"Add_item\"><font face=\"Arial\" size=\"5\" color=\"blue\">Add an Item</font></a></td>\n" +
"        </tr>\n" +
"        <br>\n" +
"        <tr>\n" +
"            <td><a href=\"Admin_update_item.html\" class=\"Update_item\"><font face=\"Arial\" size=\"5\" color=\"blue\">Update an Item</font></a></td>\n" +
"        </tr>\n" +
"        <br>\n" +
"        <tr>\n" +
"            <td><a href=\"Admin_multiple_update.html\" class=\"Multiple_update\"><font face=\"Arial\" size=\"5\" color=\"blue\">Multiple Update on an Item</font></a></td>\n" +
"        </tr>\n" +
"        <br>\n" +
"        <tr>\n" +
"            <td><a href=\"Admin_delete_item.html\" class=\"Delete_item\"><font face=\"Arial\" size=\"5\" color=\"blue\">Delete an Item</font></a></td>\n" +
"        </tr>\n" +
"        <tr>\n"+
"        <font face=\"Arial\" size=\"6\" color=\"red\">Inserted Successfully</font>\n" +
"        </tr>\n"+
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
"<head><title>Add Item</title>\n" +
"<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css\" integrity=\"sha512-1sCRPdkRXhBV2PBLUdRb4tMg1w2YPf37qatUFeS7zlBy7jJI8Lf4VHwWfZZfpXtYSLy85pkm9GaYVYMfw5BC1A==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\n" +
"<style>\n" +
"        /* Header styling */\n" +
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
"        font-family: 'Montserrat', sans-serif;;\n" +
"    }        \n" +
"    header {\n" +
"        background-color: black;\n" +
"    }\n" +
"\n" +
"    .navbar {\n" +
"        font-size: 2rem;\n" +
"        display: flex;\n" +
"        padding-left: 6rem;\n" +
"        padding-top: 2rem;\n" +
"        padding-bottom: 3rem;\n" +
"        align-items: center;\n" +
"        justify-content: space-between;\n" +
"    }\n" +
"\n" +
"    .navbar .logo {\n" +
"        text-transform: uppercase;\n" +
"    }\n" +
"\n" +
"    .navbar .logo .first{\n" +
"        color: red;\n" +
"    }\n" +
"\n" +
"    .navbar .logo .second {\n" +
"        color: yellow;\n" +
"    }\n" +
"\n" +
"    .navbar ul{\n" +
"        display: flex;\n" +
"        justify-content: space-between;\n" +
"    }\n" +
"\n" +
"    .navbar ul li {\n" +
"        border: 2px soid white;\n" +
"        list-style-type: none;\n" +
"        display: inline-block;\n" +
"        margin-right: 8rem;\n" +
"        border-bottom: none;\n" +
"    }\n" +
"\n" +
"    .navbar ul li a {\n" +
"        text-transform: uppercase;\n" +
"        color: white;\n" +
"        font-weight: 500;\n" +
"        text-decoration: none;\n" +
"    }\n" +
"\n" +
"    .navbar ul li input {\n" +
"        padding: 0.5rem;\n" +
"        border-radius: 1em;\n" +
"    }\n" +
"\n" +
"    .navbar ul li a:hover {\n" +
"        color: red;\n" +
"    }\n" +
"\n" +
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
"    /* add items  */\n" +
"    .add {\n" +
"        background-color: #C0EEC0;\n" +
"        padding-left: 8rem;\n" +
"        height: 75%;\n" +
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
"    <header>\n" +
"        <div class=\"navbar\">\n" +
"            <h2 class = 'logo'> <span class = 'first'>Super</span> <span class = 'second'>Shopper</span></h2>\n" +
"            <ul>\n" +
"                <li><a href=\"Home.html\">Home</a></li>\n" +
"                <li><a href=\"About.html\">about</a></li>\n" +
"                <li><a href=\"Contact.html\">contact</a></li>\n" +
"                <li><a href=\"Admin_login.html\">log out</a></li>\n" +
"            </ul>\n" +
"        </div>\n" +
"    </header>\n" +
"<form method=\"post\" action=\"Admin_add_item\" class=\"add\">\n" +
"<table border =\"0\" width=\"50%\">\n" +
"<tr>\n" +
"<td>Product Id:</td>\n" +
"<td><input type=\"text\" name=\"n1\"\n" +
"placeholder=\"Type product id\"></td>\n" +
"</tr>\n" +
"<tr>\n" +
"<td>Product Name:</td>\n" +
"<td><input type=\"text\" name=\"n2\" placeholder=\"Type product name\"></td>\n" +
"</tr>\n" +
"<tr>\n" +
"<td>Product Price:</td>\n" +
"<td><input type=\"text\" name=\"n3\" placeholder=\"Type product price\"></td>\n" +
"</tr>\n" +
"<tr><td><input type=\"submit\" value=\"sign in\"></td>\n" +
"</tr>\n" +
"<tr>\n"+
"<font face=\"Arial\" size=\"6\" color=\"red\">Insertion Failure</font>\n" +
"</tr>\n"+
"</table>\n" +
"</form>\n" +
"    <footer class = \"footer\">\n" +
"    <div class=\"social-media-links\">\n" +
"        <i class=\"fa-brands fa-facebook fa-4x\"></i>\n" +
"        <i class=\"fa-brands fa-twitter fa-4x\"></i>\n" +
"        <i class=\"fa-brands fa-instagram fa-4x\"></i>\n" +
"    </div>\n" +
"    <p>Super Shopper &copy; 2023, All Rights Reserved</p>\n" +
"    </footer>\n" +
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