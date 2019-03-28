package pl.sda.filter;

import pl.sda.model.User;
import pl.sda.model.enimeration.Role;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "authority", urlPatterns = {"/addPost"})
public class AuthorityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        System.out.println("przeszło do  filtra");

        User user = (User) session.getAttribute("user");

        if (user != null && (Role.USER.equals(user.getRole()) || Role.ADMIN.equals(user.getRole()))) {

            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletResponse.getWriter().println("Nie masz uprawnień");
        }

    }
}
