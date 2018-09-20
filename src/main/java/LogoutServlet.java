import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        System.out.println("before destroying:"+session.getAttribute("user").toString());



        if(session!=null){
            session.invalidate();
        }
        //System.out.println("After destroying:"+session.getAttribute("user").toString());
//        RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
//        rd.forward(req,resp);
        resp.sendRedirect("login.jsp");
    }
}
