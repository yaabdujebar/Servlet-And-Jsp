import javax.servlet.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class AuthFilter implements Filter {
    List<User> users = new ArrayList<>();


    @Override
    public void init(FilterConfig argo) throws ServletException {
        users = new UserDB().getUserDBS();
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");



        PrintWriter out = resp.getWriter();
        boolean flag = false;
        if(username!=null) {
            for (User u : users) {
                if (username.equals(u.getUserName()) && password.equals(u.getPassword())) {

                    filterChain.doFilter(req, resp);
                    flag = true;
                    break;
                }
            }
        }
        if(!flag){
          // out.print("wrong user name/password");
            RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
            dispatcher.forward(req,resp);



        }
    }

    @Override
    public void destroy() {

    }
}
