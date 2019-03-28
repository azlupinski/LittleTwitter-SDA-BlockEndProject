package pl.sda.filter;

import pl.sda.model.Post;
import pl.sda.model.User;
import pl.sda.service.PostService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "userPostValid", servletNames = {"deletePost"})
public class UserPostValidSystem implements Filter {
    PostService postService = PostService.getInstance();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();

        User user = (User) session.getAttribute("user");
        String postId = req.getParameter("postId");

        Post post = postService.getPostById(postId);

        if (post.getUser().equals(user)){
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else {
            servletResponse.getWriter().println("Nie masz uprawnień");
        }

    }
}
