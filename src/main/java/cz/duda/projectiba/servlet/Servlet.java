package cz.duda.projectiba.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet{

    private static final String INDEX_JSP = "/index.jsp";

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String param = request.getParameter("x");
        if (param != null){
            try {
                int x = Integer.parseInt(param);
                request.setAttribute("x", x);
                request.getRequestDispatcher(INDEX_JSP).forward(request, response);
            } catch (NumberFormatException ex) {
                request.setAttribute("error", "Wrong format of param x, x should be a number!");
                request.getRequestDispatcher(INDEX_JSP).forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        } else {
            try {
                request.setAttribute("x", 1);
                request.getRequestDispatcher(INDEX_JSP).forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}