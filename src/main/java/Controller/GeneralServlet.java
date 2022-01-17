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
       String features = request.getParameter("features");
       String aboutUs = request.getParameter("aboutUs");
       if(features!= null){
           RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/features.jsp");
           dispatcher.forward(request,response);
       }
       if(aboutUs!= null) {
           RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/aboutUs.jsp");
           dispatcher.forward(request, response);
       }





                /*authorize(request.getSession(false));
                case "/piattaforma":
                case "/recensione":
                case "/videogioco":
                case "/extraPage":
                case "/ricerca":*/
            }


  /*  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
            {
                try {
                    String path = getPath(request);
                    switch (path) {
                        case "/create":
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }*/
}