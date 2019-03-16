package pl.sda.controller;

import pl.sda.model.Post;
import pl.sda.service.PostService;
import pl.sda.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "posts", urlPatterns = "/")
public class PostsServlet extends HttpServlet {

    private PostService postService = PostService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        List<Post> posts = postService.getPosts();


        req.setAttribute("posts", posts);

        req.getRequestDispatcher("/indexen.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Post> posts = postService.getPosts();


        req.setAttribute("posts", posts);

        req.getRequestDispatcher("/indexen.jsp").forward(req, resp);
    }
}
