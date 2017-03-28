/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signin;

import com.wrapper.spotify.Api;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SigninServlet extends HttpServlet {

    final String clientId = "7f4f5fbceb614f3ea359db2506385d0a";
    final String clientSecret = "d3f47ca920994ab196b3ef8d93314283";
    final String redirectURI = "http://localhost:31274/SpotifyPlaylists/callback";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Api api = Api.builder().clientId(clientId).clientSecret(clientSecret).redirectURI(redirectURI).build();
        request.getSession().setAttribute("spotify", api);
        
        final List<String> scopes = Arrays.asList("user-read-private", "user-read-email");
        final String state = "statetest";

        String authorizeURL = api.createAuthorizeURL(scopes, state);
        response.sendRedirect(authorizeURL);
    }

}
