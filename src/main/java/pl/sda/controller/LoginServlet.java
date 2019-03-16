package pl.sda.controller;

import pl.sda.model.User;
import pl.sda.service.UserService;
import pl.sda.util.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private UserService userService = UserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PrintWriter writer = resp.getWriter();

        if (session.getAttribute("user") == null) {
            String login = req.getParameter("login");
            String password = req.getParameter("password");

            Optional<User> optUser = userService.loginUser(login, password);

            if (optUser.isPresent()) {
                session.setAttribute("user", optUser.get());
                req.setAttribute("message", Message.success("Zostałeś poprawnie zalogowany!"));
            } else {
                req.setAttribute("message", Message.error("Niepoprawne dane logowania!"));
            }
        } else {
            req.setAttribute("message", Message.error("Coś poszło nie tak, wygląda na to, że jesteś już zalogowany!"));
        }

        req.getRequestDispatcher("/").forward(req, resp);
    }
}
