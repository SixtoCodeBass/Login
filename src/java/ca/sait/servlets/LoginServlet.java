package ca.sait.servlets;

import ca.servlets.models.User;
import ca.sait.services.AccountService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author SixtoDev
 */
public class LoginServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             String username = (String) request.getSession().getAttribute("username");
        
        if (username != null) {
          
             response.sendRedirect("home");
             return;

        
    }
        this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AccountService account = new AccountService();
        User user = account.login(username, password);

        if (user != null) {
            // User is no null
            //Store the username in session

            request.getSession().setAttribute("username", username);

            // Redirect to the home page
             response.sendRedirect("home");
            return;

        } else {
            //User is null
            // Display an error message in login.jsp
            String message = "Username or Password is invalid";
            request.getSession().setAttribute("message", message);

        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    
    }

}
