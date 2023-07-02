import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class Contact extends HttpServlet
{
    protected void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw1=res.getWriter();
        String user_name = req.getParameter("m1");
        String phone= req.getParameter("m2");
        String email= req.getParameter("m3");
        String feedback = req.getParameter("m4");
        
         try
         {
             HttpSession ses=req.getSession();
             ses.setAttribute("id",email);
             Class.forName("oracle.jdbc.driver.OracleDriver");
            //registering type4 driver of oracle
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Nayan");
            Statement stmt = con.createStatement();
            //pw1.println("email is"+ s4);
            String q1 = "insert into feedback_1 values('"+user_name+"','"+phone+"','"+email+"','"+feedback+"')";
            ResultSet rs=stmt.executeQuery(q1);
            
           
            if (rs.next())
            {
               
                pw1.println("<html>\n" +
"    <head>\n" +
"        <title>Forget_pass_4</title>\n" +
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
"    /* forget password */\n" +
"    .forget {\n" +
"        background-color: rgb(120, 226, 225);\n" +
"        height: 70%;\n" +
"    }\n" +
"    .backtologin{\n" +
"        color: rgb(3, 48, 247);\n" +
"        margin-top: 3rem;\n" +
"        font-size: 1.5rem;\n" +
"        text-decoration: none;\n" +
"        background-color: rgb(255, 255, 255);\n" +
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
"    <header>\n" +
"        <div class=\"navbar\">\n" +
"            <h2 class = 'logo'> <span class = 'first'>Super</span> <span class = 'second'>Shopper</span></h2>\n" +
"            <ul>\n" +
"                <li><a href=\"Home.html\">Home</a></li>\n" +
"                <li><a href=\"user_login.html\">Sign in</a></li>\n" +
"                <li><a href=\"user_reg.html\">Sign up</a></li>\n" +
"                <li><a href=\"About.html\">about</a></li>\n" +
"                <li><a href=\"Contact.html\">contact</a></li>\n" +
"                <li><input type=\"text\" placeholder=\"search...\"></li>\n" +
"            </ul>\n" +
"        </div>\n" +
"    </header>\n" +
"        <form class=\"forget\">\n" +
"        <table>\n" +
"            <tr>\n" +
"            <td><font face=\"Arial\" size=\"15\" color=\"red\">\n" +
"                Thanks For Your Feedback</font></td>\n" +
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
                pw1.println("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"<head>\n" +
"    <meta charset=\"UTF-8\">\n" +
"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css\" integrity=\"sha512-1sCRPdkRXhBV2PBLUdRb4tMg1w2YPf37qatUFeS7zlBy7jJI8Lf4VHwWfZZfpXtYSLy85pkm9GaYVYMfw5BC1A==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\n" +
"    <link rel=\"stylesheet\" href=\"project2Contact.css\">\n" +
"    <title>Document</title>\n" +
"    <style>\n" +
"        * {\n" +
"    margin: 0;\n" +
"    padding: 0;\n" +
"    box-sizing: border-box;\n" +
"}\n" +
"\n" +
"html {\n" +
"    font-size: 62.5%;\n" +
"}\n" +
"\n" +
"body {\n" +
"    font-family: 'Montserrat', sans-serif;;\n" +
"}\n" +
"\n" +
"/* header styling  */\n" +
"\n" +
"header {\n" +
"    background-color: black;\n" +
"}\n" +
"\n" +
".navbar {\n" +
"    font-size: 2rem;\n" +
"    display: flex;\n" +
"    padding-left: 6rem;\n" +
"    padding-top: 2rem;\n" +
"    padding-bottom: 3rem;\n" +
"    align-items: center;\n" +
"    justify-content: space-between;\n" +
"}\n" +
"\n" +
".navbar .logo {\n" +
"    text-transform: uppercase;\n" +
"}\n" +
"\n" +
".navbar .logo .first{\n" +
"    color: red;\n" +
"}\n" +
"\n" +
".navbar .logo .second {\n" +
"    color: yellow;\n" +
"}\n" +
"\n" +
".navbar ul{\n" +
"    display: flex;\n" +
"    justify-content: space-between;\n" +
"}\n" +
"\n" +
".navbar ul li {\n" +
"   \n" +
"    \n" +
"    border-radius:6px;\n" +
"    list-style-type: none;\n" +
"    display: inline-block;\n" +
"    margin-right: 8rem;\n" +
"    border-bottom: none;\n" +
"}\n" +
".navbar ul li input{\n" +
"    border-radius:9px;\n" +
"    padding:0.6rem;\n" +
"}\n" +
"\n" +
"\n" +
".navbar ul li a {\n" +
"    text-transform: uppercase;\n" +
"    color: white;\n" +
"    font-weight: 500;\n" +
"    text-decoration: none;\n" +
"}\n" +
"\n" +
".navbar ul li a:hover {\n" +
"    color: red;\n" +
"}\n" +
"\n" +
"\n" +
"\n" +
"/* -----------contact details----------- */\n" +
"\n" +
".contact {\n" +
"    background-image:url(\"https://media.istockphoto.com/photos/3d-rendering-brick-wall-illuminated-by-neon-pink-light-from-abstract-picture-id1145590965?k=6&m=1145590965&s=170667a&w=0&h=vD8epj2MAdr-3Oqwlw9P4nmfc1ieoL9u0D3Y8i6QjZg=\");\n" +
"    background-size:cover;\n" +
"    padding: 2rem 9rem;\n" +
"    display: flex;\n" +
"    justify-content: space-evenly;\n" +
"    height: 100vh;\n" +
"}\n" +
"\n" +
".contact .details h3, .contact .details p{\n" +
"    color: white;\n" +
"}\n" +
"\n" +
".details h3 {\n" +
"    color: white;\n" +
"    text-transform: uppercase;\n" +
"    font-size: 4rem;\n" +
"    font-weight: 500;\n" +
"    display: inline;\n" +
"}\n" +
"\n" +
".left {\n" +
"    padding-right: 4rem;\n" +
"}\n" +
"\n" +
"\n" +
".contact .left i {\n" +
"    color: white;\n" +
"    display: inline;\n" +
"    padding-right: 1.4rem;\n" +
"}\n" +
"\n" +
".details p {\n" +
"    color: white;\n" +
"    font-size: 2.5rem;\n" +
"    font-weight: 200;\n" +
"}\n" +
"\n" +
".contact .left .details p {\n" +
"    margin-bottom: 2rem;\n" +
"}\n" +
"\n" +
".contact .left .photo img {\n" +
"    width: 100%;\n" +
"    height: 100%;\n" +
"}\n" +
"\n" +
".right {\n" +
"    padding-left: 2rem;\n" +
"    font-size: 1rem;\n" +
"}\n" +
"\n" +
".right h1 {\n" +
"    font-size: 4rem;\n" +
"    font-weight: 400;\n" +
"    color: whitesmoke;\n" +
"}\n" +
"\n" +
".right h1::after {\n" +
"    content: '';\n" +
"    display: block;\n" +
"    border: 3px solid white;\n" +
"    background-color: white;\n" +
"}\n" +
"\n" +
".right p {\n" +
"    font-size: 2rem;\n" +
"    color: white;\n" +
"    padding-top: 2rem;\n" +
"    padding-bottom: 1.5rem;\n" +
"}\n" +
"\n" +
".right .form label{\n" +
"    display: block;\n" +
"    color: whitesmoke;\n" +
"    font-size: 2rem;\n" +
"    padding: 0.5rem;\n" +
"}\n" +
"\n" +
"\n" +
"\n" +
".right .form label::after {\n" +
"    content: \"*\";\n" +
"    color: red;\n" +
"}\n" +
"\n" +
".right .form-group {\n" +
"    margin-bottom: 1.55rem;\n" +
"}\n" +
"\n" +
".right .form-group input {\n" +
"    padding: 0.5rem;\n" +
"    border-radius: .7rem;\n" +
"}\n" +
"\n" +
".right .form textarea {\n" +
"    width: 30rem;\n" +
"    height: 9em;\n" +
"    border-radius: 2rem;\n" +
"}\n" +
"\n" +
".right button {\n" +
"    font-size: 2rem;\n" +
"    background-color: rgb(11, 10, 59);\n" +
"    color: white;\n" +
"    text-transform: uppercase;\n" +
"    border-radius: 10px;\n" +
"    padding: 0.5rem;\n" +
"\n" +
"}\n" +
".footer{\n" +
"        background-color:#000033;\n" +
"        text-align: center;\n" +
"        padding: 2rem;\n" +
"    }\n" +
"\n" +
"    .footer i {\n" +
"        padding-left: 3rem;\n" +
"        padding-bottom: 1rem;\n" +
"        color:white;\n" +
"    }\n" +
"    .social-media-links a{\n" +
"        padding:2rem;\n" +
"        text-decoration:none;\n" +
"    }\n" +
"    .fa {\n" +
"  padding: 1rem;\n" +
"  font-size: 30px;\n" +
"  width: 50px;\n" +
"  text-align:left;\n" +
"  text-decoration:none;\n" +
"  \n" +
"}\n" +
"\n" +
"\n" +
".fa:hover {\n" +
"    opacity: 0.9;\n" +
"}\n" +
"\n" +
".fa-facebook {\n" +
"  background:#000033;\n" +
"  color:white;\n" +
"}\n" +
"\n" +
".fa-twitter {\n" +
"  background:#000033;\n" +
"  color: white;\n" +
"}\n" +
"\n" +
".fa-instagram {\n" +
"  background:#000033;\n" +
"  color: white;\n" +
"}\n" +
".footer p{\n" +
"    color:white;\n" +
"}\n" +
".map{\n" +
"    padding-left: 0.4rem;\n" +
"    padding-top:0.5rem;\n" +
"    display: flex;\n" +
"    flex-direction: row;\n" +
"}\n" +
".map iframe{\n" +
"    height: 40vh;\n" +
"    width:58vh;\n" +
"    /border-radius: 3rem;/\n" +
"    padding-left:0.4rem;\n" +
"}\n" +
".details h3{\n" +
"    font-size:2.2rem;\n" +
"}\n" +
".font a{\n" +
"    font-size:3rem;\n" +
"    color:white;\n" +
"}\n" +
".form-group h3{\n" +
"    font-size:2rem;\n" +
"    color:white;\n" +
"}\n" +
".form-group textarea{\n" +
"    border-radius:14px;\n" +
"    height:14rem;\n" +
"}\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"    </style>\n" +
"</head>\n" +
"<body>\n" +
"    <header>\n" +
"        <div class=\"navbar\">\n" +
"            <h2 class = 'logo'> <span class = 'first'>Super</span> <span class = 'second'>Shopper</span></h2>\n" +
"            <ul>\n" +
"                <li><a href=\"Home.html\">Home</a></li>\n" +
"                <li><a href=\"user_login.html\">Sign&nbsp;&nbsp;in</a></li>\n" +
"                <li><a href=\"user_reg.html\">Sign&nbsp;&nbsp;up</a></li>\n" +
"                <li><a href=\"About.html\">about</a></li>\n" +
"                <li><a href=\"Contact.html\">contact</a></li>\n" +
"                <li><input type=\"text\" placeholder=\"search...\"></li>\n" +
"            </ul>\n" +
"        </div>\n" +
"        </header>\n" +
"\n" +
"    <section class = \"contact\">\n" +
"        <div class=\"left\">\n" +
"            <div class=\"details\">\n" +
"                <i class=\"fa-solid fa-location-dot fa-4x\"></i>\n" +
"                <h3>Location:-</h3>\n" +
"                <p>Kolkata, 423, pin-243, West Bengal, India</p>\n" +
"                <div class=\"map\">\n" +
"            <iframe src=\"https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d7308.564069044391!2d86.956749!3d23.66587!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3a0270d861b6d22b%3A0xee3d107a198d3cdf!2sSouth%20City%20Mall!5e0!3m2!1sen!2sin!4v1677082467430!5m2!1sen!2sin\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>\"></iframe></div>\n" +
"\n" +
"                <i class=\"fa-solid fa-envelope fa-4x\"></i>\n" +
"                <h3>Email:-</h3>\n" +
"                <p>stoppersshop@gmail.com</p>\n" +
"\n" +
"                <i class=\"fa-solid fa-phone fa-4x\"></i>\n" +
"                <h3>Phone:-</h3>\n" +
"                <p>+9154334542</p>\n" +
"            </div>\n" +
"            <div class=\"photo\">\n" +
"                \n" +
"            </div>\n" +
"        </div>\n" +
"        <div class=\"right\">\n" +
"             <form method=\"post\" action=\"Contact\">\n" +
"                <h1>Contact Us</h1>\n" +
"                <p>Let us know about our website and give your suggestions</p>\n" +
"                 <div class=\"form-group\">\n" +
"                     <label for=\"user_name\" requi><h3>Username :</h3> </label>\n" +
"                    <input type=\"text\" name=\"m1\" id=\"username\" required>\n" +
"                </div>\n" +
"                <div class=\"form-group\">\n" +
"                    <label for=\"phone\" requi><h3>Phone : </h3></label>\n" +
"                    <input type=\"text\" name=\"m2\" id=\"phone\" required>\n" +
"                </div>\n" +
"                <div class=\"form-group\">\n" +
"                    <label for=\"email\" requi><h3>Email :</h3> </label>\n" +
"                    <input type=\"text\" name=\"m3\" id=\"email\" required>\n" +
"                </div>\n" +
"                <div class=\"form-group\">\n" +
"                    <label for=\"feedback\" requi><h3>Feedback :</h3> </label>\n" +
"                    <textarea name=\"m4\" id=\"comment\" required style=\"font-size:18pt;\" border-radius=\"2rem\"></textarea>\n" +
"                </div>\n" +
"                <button type=\"submit\" class = 'form-btn'>submit</button>\n" +
"                 <font face=\"Arial\" size=\"8\" color=\"red\">Failure</font>\n" +
"            </form>\n" +
"        </div>\n" +
"\n" +
"        \n" +
"    </section>\n" +
"    <footer class = \"footer\">\n" +
"        <div class=\"social-media-links\">\n" +
"           \n" +
"            <a href=\"https://www.facebook.com/EnUnChasquido\" <span class=\"fa-brands fa-facebook fa-4x\"></span></a>\n" +
"            <a href=\"https://www.instagram.com/EnUnChasquido\" <span class=\"fa-brands fa-instagram fa-4x\"></span></a>\n" +
"            <a href=\"https://www.twitter.com/EnUnChasquido\" <span class=\"fa-brands fa-twitter fa-4x\"></span></a>\n" +
"</div>\n" +
"        <p>Super Heros &copy; 2022, All Rights Reserved</p>\n" +
"    </footer>\n" +
"\n" +
"\n" +
"    \n" +
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