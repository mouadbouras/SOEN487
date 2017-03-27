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
           <h2>Mike's Favorite Artists</h2>
           <h3>List of Album</h3>
       </center>
        

         <% 
             String album1 = SpotifyReader.getSpotifyURL("4dpARuHxo51G3z768sgnrY"); //Ed Sheeran 
             String album2 = SpotifyReader.getSpotifyURL("6VuMaDnrHyPL1p4EHjYLi7"); //Charlie Puth
             String album3 = SpotifyReader.getSpotifyURL("1Xyo4u8uXC1ZmMpatF05PJ"); //The Weekend
             
             String album1name = SpotifyReader.getSingerName("4dpARuHxo51G3z768sgnrY"); ///Ed Sheeran
             String album2name = SpotifyReader.getSingerName("6VuMaDnrHyPL1p4EHjYLi7"); //Charlie Puth
             String album3name = SpotifyReader.getSingerName("1Xyo4u8uXC1ZmMpatF05PJ"); //The Weekend
            
             String genre1 = SpotifyReader.getGenre("4dpARuHxo51G3z768sgnrY"); ///Ed Sheeran 
             String genre2 = SpotifyReader.getGenre("6VuMaDnrHyPL1p4EHjYLi7"); //Charlie Puth
             String genre3 = SpotifyReader.getGenre("5pKCCKE2ajJHZ9KAiaK11H"); //The Weekend
             
             long pop1 = SpotifyReader.getPopularity("4dpARuHxo51G3z768sgnrY"); ///Ed Sheeran 
             long pop2 = SpotifyReader.getPopularity("6VuMaDnrHyPL1p4EHjYLi7"); //Charlie Puth
             long pop3 = SpotifyReader.getPopularity("1Xyo4u8uXC1ZmMpatF05PJ"); //The Weekend


         
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
