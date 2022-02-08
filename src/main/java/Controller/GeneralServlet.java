package Controller;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "GeneralServlet", value = "/General")
public class GeneralServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String home = request.getParameter("home");
        String features = request.getParameter("features");
        String aboutUs = request.getParameter("aboutus");
        if (home != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/redirect.jsp");
            dispatcher.forward(request, response);
        }
        if (features != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/features.jsp");
            dispatcher.forward(request, response);
        }
        if (aboutUs != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/aboutUs.jsp");
            dispatcher.forward(request, response);
        }
    }
}