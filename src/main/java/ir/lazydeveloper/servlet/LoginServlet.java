package ir.lazydeveloper.servlet;

import ir.lazydeveloper.enums.Url;
import ir.lazydeveloper.model.Accessor;
import ir.lazydeveloper.service.LoginService;
import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Login Servlet", urlPatterns = Url.LOGIN)
public class LoginServlet extends HttpServlet {
    private LoginService loginService;
    private static final Logger LOGGER = Logger.getLogger(LoginServlet.class);

    @Override
    public void init(ServletConfig config) {
        loginService = LoginService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("LOGIN --> " + req.getParameter("email"));
        try {
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            if (email == null && email.isEmpty() && password == null && password.isEmpty()) {
                resp.sendRedirect("/login.jsp");
                return;
            }
            Accessor accessor = new Accessor(email, password);

            if (loginService.oneFactorLogin(accessor)) {
                HttpSession session = req.getSession(true);
                session.setAttribute("Accessor", accessor);
                resp.sendRedirect("/index.jsp");
            } else {
                req.setAttribute("errorMessage","email or password is invalid");
                req.getRequestDispatcher("/login.jsp").include(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
