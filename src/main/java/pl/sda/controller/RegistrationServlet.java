package pl.sda.controller;

import pl.sda.service.RegistrationService;
import pl.sda.util.Message;
import pl.sda.util.ValidationError;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "registration", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {

    private RegistrationService registrationService = RegistrationService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null) {
            req.getRequestDispatcher("/registration.jsp").forward(req, resp);
        } else {
            req.setAttribute("message", Message.error("Błąd!"));
            req.getRequestDispatcher("/indexen.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String repeatPassword = req.getParameter("repeatPassword");

        Optional<ValidationError> error = registrationService.validateUserData(login, password, repeatPassword);

        if (!error.isPresent()) {
            registrationService.registerUser(login, password);
            req.setAttribute("message", Message.success("Twoje konto zostało zarejestrowane, możesz się zalogować!"));
            req.getRequestDispatcher("/indexen.jsp").forward(req, resp);
        } else {
            req.setAttribute("message", Message.error(error.get().getErrorMsg()));
            req.getRequestDispatcher("/registration.jsp").forward(req, resp);
        }

    }

}
