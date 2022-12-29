package ir.lazydeveloper.filtter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AuthenticationFilter implements Filter {
    List<String> publicUrlList;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        publicUrlList = new ArrayList<>();
        publicUrlList.add("/");
        publicUrlList.add("/login");
        publicUrlList.add("/logout");
        publicUrlList.add("/register");
        publicUrlList.add("/index.jsp");
        publicUrlList.add("/login.jsp");
        publicUrlList.add("/register.jsp");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        Object accessor = session.getAttribute("Accessor");
        String requestURI = req.getRequestURI();
        if (publicUrlList.contains(requestURI) || accessor != null) {
            chain.doFilter(request, response);
        }else {
            res.sendRedirect("/index.jsp");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
