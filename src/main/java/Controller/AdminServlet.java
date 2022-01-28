package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminServlet", value = "/admin/*")

public class AdminServlet extends Controllo {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String path = getPath(request);
            switch (path) {
                case "/admin":
                    request.getRequestDispatcher("/WEB-INF/views/admin/secret.jsp").forward(request, response);
                    break;
                default:
                    break;
            }

        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String path = getPath(request);
            switch (path) {
                case "/login":
                    request.getRequestDispatcher("/WEB-INF/views/admin/secret.jsp").forward(request, response);
                    break;
                default:
                    break;
            }

        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

}