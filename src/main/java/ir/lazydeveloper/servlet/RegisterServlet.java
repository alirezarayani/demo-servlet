package ir.lazydeveloper.servlet;

import ir.lazydeveloper.common.util.ToolsDate;
import ir.lazydeveloper.common.util.ToolsValidator;
import ir.lazydeveloper.enums.Url;
import ir.lazydeveloper.model.Accessor;
import ir.lazydeveloper.service.RegisterService;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@WebServlet(name = "Register Servlet", urlPatterns = Url.REGISTER)
public class RegisterServlet extends HttpServlet {

    private RegisterService registerService;

    @Override
    public void init(ServletConfig config) {
        registerService = RegisterService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            if (ToolsValidator.isEmailValidate(email) && ToolsValidator.calcPasswordComplexity(password) == 4) {
                if (!registerService.isEmailExists(password)) {
                    Accessor accessor = new Accessor(email, password);
                    password = BCrypt.hashpw(password, BCrypt.gensalt());
                    accessor.setPassword(password);
                    registerService.save(accessor);
                    HttpSession session = req.getSession(true);
                    session.setAttribute("Accessor", accessor);
                    resp.sendRedirect("/index.jsp");
                } else {
                    resp.getWriter().println("<p style=\"color: red\">Email address is exists</p>");
                    req.getRequestDispatcher("/register.jsp").include(req, resp);
                }
            } else {
                resp.getWriter().println("<p style=\"color: red\">Email or password are invalid</p>");
                req.getRequestDispatcher("/register.jsp").include(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}



