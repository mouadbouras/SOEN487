<%-- 
    Document   : aakash
    Created on : 25-Mar-2017, 8:04:11 PM
    Author     : Aakash
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="spotify.api.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spotify - List of Favorite Artist</title>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
    </head>
    <body>
       <center>  
           <h2>Sean's Favorite Artists</h2>
           <h3>List of Album</h3>
       </center>
        

         <% 
             String album1 = SpotifyReader.getSpotifyURL("4Rxn7Im3LGfyRkY2FlHhWi"); //Nick Jonas
             String album2 = SpotifyReader.getSpotifyURL("5WUlDfRSoLAfcVSX1WnrxN"); //Sia 
             String album3 = SpotifyReader.getSpotifyURL("66CXWjxzNUsdJxJ2JdwvnR"); //Ariana Grande
             
             String album1name = SpotifyReader.getSingerName("4Rxn7Im3LGfyRkY2FlHhWi"); //Nick Jonas
             String album2name = SpotifyReader.getSingerName("5WUlDfRSoLAfcVSX1WnrxN"); //Sia 
             String album3name = SpotifyReader.getSingerName("66CXWjxzNUsdJxJ2JdwvnR");  //Ariana Grande
            
             String genre1 = SpotifyReader.getGenre("4Rxn7Im3LGfyRkY2FlHhWi"); //Nick Jonas
             String genre2 = SpotifyReader.getGenre("5WUlDfRSoLAfcVSX1WnrxN"); //Sia 
             String genre3 = SpotifyReader.getGenre("66CXWjxzNUsdJxJ2JdwvnR");  //Ariana Grande
             
             long pop1 = SpotifyReader.getPopularity("4Rxn7Im3LGfyRkY2FlHhWi"); //Nick Jonas
             long pop2 = SpotifyReader.getPopularity("5WUlDfRSoLAfcVSX1WnrxN"); //Sia 
             long pop3 = SpotifyReader.getPopularity("66CXWjxzNUsdJxJ2JdwvnR");  //Ariana Grande

         
         %>
   
            
     
 <table class="table">
   <thead>
  <tr>
        <th>Artist Name</th>
        <th>Music Genre</th>
        <th>Popularity Level</th>
        <th>Artist Page</th>
       </tr>
    </thead>
    
<tbody>

      <% 
               out.write("<tr>"
                       + "<td><font color='purple'>"
                       + album1name
                       +"</font></td>"
                        + "<td><i>"
                       + genre1
                       +"</i></td>"
                        + "<td>"
                       + pop1
                       +"</td>"
                        + "<td>"
                       + "<a href="+album1+" class='btn btn-info' role='button' target='_blank'>Go to Spotify!</a>"
                       +"</td>"
                       );

                out.write("<tr>"
                       + "<td><font color='purple'>"
                       + album2name
                       +"</font></td>"
                        + "<td><i>"
                       + genre2
                       +"</i></td>"
                        + "<td>"
                       + pop2
                       +"</td>"
                        + "<td>"
                       + "<a href="+album2+" class='btn btn-info' role='button' target='_blank'>Go to Spotify!</a>"
                       +"</td>"
                       );
 
                out.write("<tr>"
                         + "<td><font color='purple'>"
                       + album3name
                       +"</font></td>"
                        + "<td><i>"
                       + genre3
                       +"</i></td>"                  
                        + "<td>"
                       + pop3
                       +"</td>"
                        + "<td>"
                       + "<a href="+album3+" class='btn btn-info' role='button' target='_blank'>Go to Spotify!</a>"
                       +"</td>"
                       );
      
      
      
      
      %>  
     
      
    </tbody>
    
    
    
    
    
    
    
    
  </table>
      
    </body>
</html>
