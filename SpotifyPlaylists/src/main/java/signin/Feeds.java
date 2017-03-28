/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signin;

import com.wrapper.spotify.Api;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Martin
 */
@WebServlet(name = "Feeds", urlPatterns = {"/Feeds"})
public class Feeds extends HttpServlet {
    
    final String clientId = "7f4f5fbceb614f3ea359db2506385d0a";
    final String clientSecret = "d3f47ca920994ab196b3ef8d93314283";
    String redirectURI;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        StringBuffer callback = request.getRequestURL();
        int index = callback.lastIndexOf("/");
        callback.replace(index, callback.length(), "").append("/callback");
        redirectURI = callback.toString();
        System.out.println("redirectURI=" + redirectURI);
        
        Api api = Api.builder().clientId(clientId).clientSecret(clientSecret).redirectURI(redirectURI).build();
        
        final List<String> scopes = Arrays.asList("user-read-private", "user-read-email");
        final String state = "statetest";
        
        String authorizeURL = api.createAuthorizeURL(scopes, state);
        
        response.sendRedirect(authorizeURL);
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
