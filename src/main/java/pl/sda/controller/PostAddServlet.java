package pl.sda.controller;

import pl.sda.model.User;
import pl.sda.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "postAddServlet", urlPatterns = "/addPost")
public class PostAddServlet extends HttpServlet {

    PostService postService = PostService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String postContent = req.getParameter("postContent");
        User user = (User) req.getSession().getAttribute("user");

        postService.registerPost(name,postContent,user);
        req.getRequestDispatcher("/").forward(req, resp);
    }
}
