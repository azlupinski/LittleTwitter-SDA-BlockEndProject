package pl.sda.controller;

import pl.sda.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "deletePost", urlPatterns = "/deletePost")
public class DeletePostServlet extends HttpServlet {

    private PostService postService = PostService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        HttpSession session = req.getSession();

        Long postId = Long.valueOf(req.getParameter("postId")) ;
        postService.deletePost(postId);

        req.getRequestDispatcher("/").forward(req,resp);

    }
}
