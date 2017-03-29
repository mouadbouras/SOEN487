<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
        <link rel="stylesheet" href="bootstrap.min.css">
        <link rel="stylesheet" href="style.css">

    <title>Simple Map</title>
    <meta name="viewport" content="initial-scale=1.0">
    <meta charset="utf-8">

  </head>
  <body>
    <div class="container-fluid w-bg">
        <div class="row text-center ">
            <div class="col-xs-3 ">
                <img class="logo" src="img/twitter.png" alt="Twitter" >
            </div>
            <div class="col-xs-6">
                <img class="logo" src="img/google.png" alt="google" >
            </div>
            <div class="col-xs-3">
                 <img class="logo spotify-logo" src="img/spotify.png" alt="Twitter" >
            </div>
        </div>         
    </div>
      
      <div class="container-fluid" id="main-content">
          <div class="row">
              <div class="col-xs-3">
                  <div id="twitter">
                    </div>
              </div>
              <div class="col-xs-6">
                  <div id="map"></div> 
                  <div>
                    <tag:notloggedin>
                        <a href="signin">Sign in to tweet</a>
                    </tag:notloggedin>
                    <tag:loggedin>
                        <h4>Welcome ${twitter.screenName} (${twitter.id})</h4>
                        <form action="./post" method="post">
                            <textarea cols="50" rows="2" name="text" maxlength="140"></textarea><br>
                            <input type="submit" name="post" value="update"/>
                        </form>
                        <br><br><a href="./logout">logout</a>
                    </tag:loggedin>
                  </div>
              </div>
              
              <div class="col-xs-3">
                  <div id="sporify">
                    </div>                  
              </div>

              
          </div>         
      </div>
  

<!--  <div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

     Modal content
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title"></h4>
      </div>
      <div class="modal-body text-center">
        <p>I C U  ( ͡° ͜ʖ ͡°) </p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>-->
      
    <script src='jquery.js'></script>
    <script src="bootstrap.min.js"></script>        
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyANpWlWG21MsG9WRqutzl1Qieohp8BJpwY&callback=initMap" async defer></script>
    <script src='script.js'></script>
  </body>
</html>