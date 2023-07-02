import java.io.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.*;//For getting the generic servlet class
import javax.servlet.http.*;//For getting the HttpServlet class
public class user_login extends HttpServlet
{
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw1=res.getWriter();
        String nm1=req.getParameter("n1");
        String nm2=req.getParameter("n2");
       // pw1.println("<html><body bgcolor=skyblue>Welcome "+nm1+"<br> Enter your password: "+nm2+"<br> Address: "+nm3+"<br> Email: "+nm4+"<br> Security Question: "+nm5+"<br> Ans"+nm6+"<br> Hobbies: "+nm7+"</body></html>");//response from servlet
        try
        {
          HttpSession ses=req.getSession();
          ses.setAttribute("mail",nm1);
          Class.forName("oracle.jdbc.driver.OracleDriver");
          Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Nayan");
          Statement stmt=con.createStatement();
          String q1="Select * from customer where id='"+nm1+"' and password='"+nm2+"'";
          ResultSet rs=stmt.executeQuery(q1);
          if(rs.next())
           {
           pw1.println("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"<head>\n" +
"    <meta charset=\"UTF-8\">\n" +
"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    <title>Document</title>\n" +
"    <style>\n" +
"    /* Header styling */\n" +
"        \n" +
"    * {\n" +
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
"        font-family: 'Arial', sans-serif;;\n" +
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
"        list-style-type: none;\n" +
"        display: inline-block;\n" +
"        margin-right: 8rem;\n" +
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
"    /hero styling/\n" +
"\n" +
"    .heros {\n" +
"        background-color: whitesmoke;\n" +
"        padding: 10rem 19rem;\n" +
"    }\n" +
"\n" +
"    .heros .main-hero {\n" +
"        display: flex;\n" +
"        background-color: rgb(255, 255, 255);\n" +
"        margin-bottom: 6rem;\n" +
"    }\n" +
"\n" +
"    .heros .text {\n" +
"        display: flex;\n" +
"        font-size: medium;\n" +
"        align-items:center;\n" +
"        margin-left: 7rem;\n" +
"    }\n" +
"    .heros .text a {\n" +
"        color: black;\n" +
"        text-decoration: none;\n" +
"    }\n" +
"\n" +
"    .hero-image img{\n" +
"        height: 300px;\n" +
"        width: 100%;\n" +
"        background-size: cover;\n" +
"        border-radius: 2rem;\n" +
"    }\n" +
"\n" +
"    .addtocart input {\n" +
"        font-size: 2rem;\n" +
"        background-color: #C0EEC0;\n" +
"        border-radius: 2rem;\n" +
"        color: white;\n" +
"        padding: 1rem;\n" +
"        margin-top: 15rem;\n" +
"        margin-left: 5rem;\n" +
"    }\n" +
"    .addtocart input:hover {\n" +
"        color: yellow;\n" +
"    }\n" +
"\n" +
"    form \n" +
"\n" +
"    /* footer styling */\n" +
"    \n" +
"\n" +
"    .footer{\n" +
"        background-color: rgb(52, 3, 3);\n" +
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
"    </style>\n" +
"</head>\n" +
"\n" +
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
"           </ul>\n" +
"        </div>\n" +
"    </header>\n" +
"\n" +
"    <section class = 'heros'>\n" +
"\n" +
"        <form method=\"post\" action=\"Add_to_cart\">\n" +
"            <div class =\"main-hero\" >\n" +
"                <div class ='hero-image'>\n" +
"                    <img src=\"samsungGalaxyf04.jpg\" alt=\"samsungGalaxyf04\">\n" +
"                </div>\n" +
"                <div class=\"text\">\n" +
"                    <a href=\"\"><h2 class ='make-subHeading'>SAMSUNG Galaxy F04 (Opal Green, 64 GB)  (4 GB RAM)</h2> <br></a>\n" +
"                    <h2><br><br>Rs.25000<br></h2>\n" +
"                </div>\n" +
"                <div class=\"addtocart\">\n" +
"                    <input type=\"hidden\" name=\"cart\" value=\"4\">\n" +
"                    <input type=\"submit\" value=\"Add to Cart\">\n" +
"                </div>\n" +
"            </div>\n" +
"            \n" +
"        </form>\n" +
"        \n" +
"        <form method=\"post\" action=\"Add_to_cart\">\n" +
"            <div class =\"main-hero\" >\n" +
"                <div class ='hero-image'>\n" +
"                    <img src=\"pocom4pro.jpg\" alt=\"superman\">\n" +
"                 </div>\n" +
"                <div class=\"text\">\n" +
"                    <a href=\"\"><h2 class ='make-subHeading'>POCO M4 PRO 5G (Opal Green, 64 GB)  (4 GB RAM)</h2> <br></a>\n" +
"                    <h2><br><br>Rs.20000<br></h2>\n" +
"                </div>\n" +
"                <div class=\"addtocart\">\n" +
"                    <input type=\"hidden\" name=\"cart\" value=\"3\">\n" +
"                    <input type=\"submit\" value=\"Add to Cart\">\n" +
"                </div>\n" +
"            </div>\n" +
"        </form>\n" +
"        \n" +
"        <form method=\"post\" action=\"Add_to_cart\">\n" +
"            <div class = \"main-hero\" >\n" +
"                <div class ='hero-image'>\n" +
"                    <img src=\"samsungGalaxyf13.jpg\" alt=\"ironman\">\n" +
"                </div>\n" +
"                <div class=\"text\">\n" +
"                    <a href=\"\"><h2 class ='make-subHeading'>SAMSUNG Galaxy F13 (Nightsky Green, 64 GB)  (4 GB RAM)</h2> <br></a>\n" +
"                    <h2><br><br>Rs.79000<br></h2>\n" +
"                </div>\n" +
"                <div class=\"addtocart\">\n" +
"                    <input type=\"hidden\" name=\"cart\" value=\"5\">\n" +
"                    <input type=\"submit\" value=\"Add to Cart\">\n" +
"                </div>\n" +
"            </div>\n" +
"        </form>\n" +
"        \n" +
"        <form method=\"post\" action=\"Add_to_cart\">\n" +
"        <div class = \"main-hero\" >\n" +
"            <div class = 'hero-image'>\n" +
"                <img src=\"iPhone14.jpg\" alt=\"thor\">\n" +
"            </div>\n" +
"            <div class=\"text\">\n" +
"                <a href=\"\"><h2 class = 'make-subHeading'>APPLE iPhone 14 (Starlight, 128 GB)</h2> <br></a>\n" +
"                <h2><br><br>Rs.81999<br></h2>\n" +
"            </div>\n" +
"            <div class=\"addtocart\">\n" +
"                <input type=\"hidden\" name=\"cart\" value=\"1\">\n" +
"                <input type=\"submit\" value=\"Add to Cart\">\n" +
"            </div>\n" +
"        </div>\n" +
"        </form>\n" +
"        \n" +
"        <form method=\"post\" action=\"Add_to_cart\">\n" +
"        <div class = \"main-hero\" >\n" +
"            <div class = 'hero-image'>\n" +
"                <img src=\"iphone11.jpg\" alt=\"captainarmerica\">\n" +
"            </div>\n" +
"            <div class=\"text\">\n" +
"                <a href=\"\"><h2 class = 'make-subHeading'>APPLE iPhone 11 (White, 128 GB)</h2> <br></a>\n" +
"                <h2><br><br>Rs.71000<br></h2>\n" +
"            </div>\n" +
"            <div class=\"addtocart\">\n" +
"                <input type=\"hidden\" name=\"cart\" value=\"2\">\n" +
"                <input type=\"submit\" value=\"Add to Cart\">\n" +
"            </div>\n" +
"        </div>\n" +
"        </form>\n" +
"\n" +
"        <form method=\"post\" action=\"Add_to_cart\">\n" +
"        <div class =\"main-hero\" >\n" +
"            <div class ='hero-image'>\n" +
"                <img src=\"Oneplus10pro.jpg\" alt=\"saktiman\">\n" +
"             </div>\n" +
"            <div class=\"text\">\n" +
"                <a href=\"\"><h2 class ='make-subHeading'>OnePlus 10 Pro 5G (Emerald Forest, 256 GB)  (12 GB RAM)</h2> <br></a>\n" +
"                <h2><br><br>Rs.65999<br></h2>\n" +
"            </div>\n" +
"            <div class=\"addtocart\">\n" +
"                <input type=\"hidden\" name=\"cart\" value=\"12\">\n" +
"                <input type=\"submit\" value=\"Add to Cart\">\n" +
"            </div>\n" +
"        </div>\n" +
"        </form>\n" +
"        \n" +
"        <form method=\"post\" action=\"Add_to_cart\" >\n" +
"        <div class =\"main-hero\" >\n" +
"            <div class ='hero-image'>\n" +
"                <img src=\"OppoReno8.jpg\" alt=\"redmail\">\n" +
"             </div>\n" +
"            <div class=\"text\">\n" +
"                <a href=\"\"><h2 class ='make-subHeading'>OPPO RENO8 5G (Shimmer Gold, 128 GB)  (4 GB RAM)</h2> <br></a>\n" +
"                <h2><br><br>Rs.25000<br></h2>\n" +
"            </div>\n" +
"            <div class=\"addtocart\">\n" +
"                <input type=\"hidden\" name=\"cart\" value=\"11\">\n" +
"                <input type=\"submit\" value=\"Add to Cart\">\n" +
"            </div>\n" +
"        </div>\n" +
"        </form>\n" +
"        \n" +
"        <form method=\"post\" action=\"Add_to_cart\">\n" +
"        <div class =\"main-hero\" >\n" +
"            <div class ='hero-image'>\n" +
"                <img src=\"NokiaG21.jpg\" alt=\"hotstar\">\n" +
"             </div>\n" +
"            <div class=\"text\">\n" +
"                <a href=\"\"><h2 class ='make-subHeading'>NOKIA G21 (Dual SIM, 128 GB)  (6 GB RAM)</h2> <br></a>\n" +
"                <h2><br><br>Rs.20000<br></h2>\n" +
"            </div>\n" +
"            <div class=\"addtocart\">\n" +
"                <input type=\"hidden\" name=\"cart\" value=\"23\">\n" +
"                <input type=\"submit\" value=\"Add to Cart\">\n" +
"            </div>\n" +
"        </div>\n" +
"        </form>\n" +
"        \n" +
"        <form method=\"post\" action=\"Add_to_cart\">\n" +
"        <div class =\"main-hero\" >\n" +
"            <div class ='hero-image'>\n" +
"                <img src=\"Lenovo_Z2.jpg\" alt=\"rediffmail\">\n" +
"             </div>\n" +
"            <div class=\"text\">\n" +
"                <a href=\"\"><h2 class ='make-subHeading'>LENOVO Z2 PLUS(Black, 64 GB)  (4 GB RAM)</h2> <br></a>\n" +
"                <h2><br><br>Rs.15000<br></h2>\n" +
"            </div>\n" +
"            <div class=\"addtocart\">\n" +
"                <input type=\"hidden\" name=\"cart\" value=\"31\">\n" +
"                <input type=\"submit\" value=\"Add to Cart\">\n" +
"            </div>\n" +
"        </div>\n" +
"        </form>\n" +
"        \n" +
"        <form method=\"post\" action=\"Add_to_cart\">\n" +
"        <div class = \"main-hero\" >\n" +
"        <div class ='hero-image'>\n" +
"            <img src=\"samsungGalaxyA14.jpg\" alt=\"google\">\n" +
"        </div>\n" +
"        <div class=\"text\">\n" +
"            <a href=\"\"><h2 class ='make-subHeading'>SAMSUNG Galaxy A14 (Black, 64 GB)  (4 GB RAM)</h2> <br></a>\n" +
"            <h2><br><br>Rs.18199<br></h2>\n" +
"        </div>\n" +
"        <div class=\"addtocart\">\n" +
"            <input type=\"hidden\" name=\"cart\" value=\"13\">\n" +
"            <input type=\"submit\" value=\"Add to Cart\">\n" +
"        </div>\n" +
"        </div>\n" +
"        </form>\n" +
"        \n" +
"        <form method=\"post\" action=\"Add_to_cart\">\n" +
"        <div class = \"main-hero\" >\n" +
"        <div class ='hero-image'>\n" +
"            <img src=\"Asus6z.jpg\" alt=\"instagram\">\n" +
"        </div>\n" +
"        <div class=\"text\">\n" +
"            <a href=\"\"><h2 class ='make-subHeading'>ASUS 6Z(Silver, 64 GB)  (6 GB RAM)</h2> <br></a>\n" +
"            <h2><br><br>Rs.30000<br></h2>\n" +
"        </div>\n" +
"        <div class=\"addtocart\">\n" +
"            <input type=\"hidden\" name=\"cart\" value=\"29\">\n" +
"            <input type=\"submit\" value=\"Add to Cart\">\n" +
"        </div>\n" +
"        </div>\n" +
"        </form>\n" +
"        \n" +
"        <form method=\"post\" action=\"Add_to_cart\">\n" +
"        <div class = \"main-hero\" >\n" +
"        <div class ='hero-image'>\n" +
"            <img src=\"redminote8.jpg\" alt=\"facebook\">\n" +
"        </div>\n" +
"        <div class=\"text\">\n" +
"            <a href=\"\"><h2 class ='make-subHeading'>REDMI NOTE 8 PRO(Halo White, 128 GB) (6GB RAM)</h2> <br></a>\n" +
"            <h2><br><br>Rs.12000<br></h2>\n" +
"        </div>\n" +
"        <div class=\"addtocart\">\n" +
"            <input type=\"hidden\" name=\"cart\" value=\"19\">\n" +
"            <input type=\"submit\" value=\"Add to Cart\">\n" +
"        </div>\n" +
"        </div>\n" +
"        </form>\n" +
"    </section>\n" +
"\n" +
"\n" +
"\n" +
"    <footer class = \"footer\">\n" +
"        <div class=\"social-media-links\">\n" +
"            <i class=\"fa-brands fa-facebook fa-4x\"></i>\n" +
"            <i class=\"fa-brands fa-twitter fa-4x\"></i>\n" +
"            <i class=\"fa-brands fa-instagram fa-4x\"></i>\n" +
"        </div>\n" +
"        <p>Super Shopper &copy; 2023, All Rights Reserved</p>\n" +
"    </footer>\n" +
"\n" +
"</body>\n" +
"</html>");
       }
          else
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
"        color: #C0EEC0;\n" +
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
"<form method=\"post\" action=\"user_login\" class=\"loginform\">\n" +
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
"    <tr>\n"+
"     <font face=\"Arial\" size=\"6\" color=\"red\">Invalid Credentials</font>\n" +
"     </tr>\n"+
"    </table>\n" +
"    <br>\n" +
"    <a href=\"user_forget_pass_1.html\" class=\"forgetPass\">Forget Password?</a>\n" +
"</form>\n" +
"\n" +
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
"</html>");}
    }
        catch(Exception e)
        {
            pw1.println(e);
        }
    }
}