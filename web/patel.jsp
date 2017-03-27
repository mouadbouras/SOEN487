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
           <h2>Aakash's Favorite Artists</h2>
           <h3>List of Album</h3>
       </center>
        

         <% 
             String album1 = SpotifyReader.getSpotifyURL("1uNFoZAHBGtllmzznpCI3s"); //Justin Bieber
             String album2 = SpotifyReader.getSpotifyURL("738wLrAtLtCtFOLvQBXOXp"); //Major Lazer
             String album3 = SpotifyReader.getSpotifyURL("5pKCCKE2ajJHZ9KAiaK11H"); //Rihanna
             
             String album1name = SpotifyReader.getSingerName("1uNFoZAHBGtllmzznpCI3s"); //Justin Bieber
             String album2name = SpotifyReader.getSingerName("738wLrAtLtCtFOLvQBXOXp"); //Major Lazer
             String album3name = SpotifyReader.getSingerName("5pKCCKE2ajJHZ9KAiaK11H"); //Rihanna
            
             String genre1 = SpotifyReader.getGenre("1uNFoZAHBGtllmzznpCI3s"); //Justin Bieber
             String genre2 = SpotifyReader.getGenre("738wLrAtLtCtFOLvQBXOXp"); //Major Lazer
             String genre3 = SpotifyReader.getGenre("5pKCCKE2ajJHZ9KAiaK11H"); //Rihanna
             
             long pop1 = SpotifyReader.getPopularity("1uNFoZAHBGtllmzznpCI3s"); //Justin Bieber
             long pop2 = SpotifyReader.getPopularity("738wLrAtLtCtFOLvQBXOXp"); //Major Lazer
             long pop3 = SpotifyReader.getPopularity("5pKCCKE2ajJHZ9KAiaK11H"); //Rihanna


         
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
