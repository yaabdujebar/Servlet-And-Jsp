import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String username = req.getParameter("username");
       String password = req.getParameter("password");
       boolean flag = (req.getParameter("rememberme")!=null?true:false);

       User user= new User(username,password,flag);
       HttpSession session = req.getSession();
       session.setAttribute("user",user);

       //set Cookies
       if(req.getParameter("rememberme")!=null){
           Cookie c = new Cookie("Name",username);
           c.setMaxAge(30*24*60*60);
           resp.addCookie(c);
       }
       else{
           Cookie c = new Cookie("Name",username);
           c.setMaxAge(0);
           resp.addCookie(c);
       }

        PrintWriter out = resp.getWriter();





            out.print("<html><head><title>ViewPage</title></head>");
            out.print("<body><p>welcome " + username);
            out.print("</p>");
            out.print("<form action='logout' method='GET'>");
            out.print("<input type='submit' value='log-out' />");
            out.print("</form></body></html>");



    }
}
