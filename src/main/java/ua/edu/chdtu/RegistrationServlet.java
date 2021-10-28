package ua.edu.chdtu;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher view = req.getRequestDispatcher("static/index.html");
        view.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf8"); // кирилица
        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String status = req.getParameter("status");
        String password = req.getParameter("password");
        resp.getWriter().write("JSON: " + convertDataToJSON(fullName, email, phone, status, password));
    }

    private String convertDataToJSON(String fullName, String email, String phone, String status, String password) {
        return "{ <p>\"fullName\": \"" + fullName +
                    "\",</p><p>\n \"email\": \"" + email +
                    "\",</p><p>\n \"phone\": \"" + phone +
                    "\",</p><p>\n \"status\": \"" + status +
                    "\",</p><p>\n \"password\": \"" + password +
                    "\"</p><p>" +
                " } ";
    }

}
