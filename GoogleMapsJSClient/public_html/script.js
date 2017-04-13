/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


        var map;
        var infowindow;
        var markers = []; 
        $('#success').hide();
        $('#error').hide();
        
//            [{ name: "Mouad Bouras" , label : "B" , lat : 45.5093356 , lng : -73.677426, twitter : "mouadbouras" , lastFm:"mouadbouras"} ,
//                      { name: "Concordia " , label : "S" , lat : 45.492261 , lng : -73.5783127, twitter :"concordia"  , lastFm:""},
//                      { name: "Sean Canlas" , label : "G" , lat : 45.4609075 , lng : -73.6278422, twitter :"seancanlas" , lastFm:""},
//                      { name: "Trisha Dimayuga" , label : "D" , lat: 45.4729346, lng: -73.6552988, twitter :"trishapoynter"  , lastFm:""},
//                      { name: "Mike Cabana" , label:"C"   , lat: 45.604174, lng: -73.6724567, twitter :"mikecabana" , lastFm:""}, 
//                      { name: "Martin Nafekh" , label:"N"   , lat: 45.4842901, lng: -73.8476348, twitter :""  , lastFm:"cynykul"}, 
//                      {name: "Aakash Patel" , label:"P"   , lat: 45.5709407, lng: -73.7029947, twitter : "" , lastFm:""}]; 
        
        function initMap() {
            infowindow = new google.maps.InfoWindow({maxWidth: 400});
            map = new google.maps.Map(document.getElementById('map'), {
              center: {lat: 45.5425158, lng: -73.6378987},
              zoom: 11
            });

            map.addListener('click', function(event) {
                var latitude = event.latLng.lat();
                var longitude = event.latLng.lng();
                
                infowindow.setPosition(event.latLng);
                infowindow.setContent("<div class='container-fluid'><h5>New Marker : </h5>" +
                                      "" +
                                      "<div class='row' style='width:245px; margin-top:5px'><div class='col-xs-4' >Name :</div><div class='col-xs-8' style='margin-top:5px'> <input id='markerName' style='width:132px' type='text'> </div></div>" +
                                      "<div class='row' style='width:245px;margin-top:5px'><div class='col-xs-4' >Twitter :</div><div class='col-xs-8' style='margin-top:5px'> <input id='markerTwitter' style='width:132px' type='text'></div> </div>" +
                                      "<div class='row' style='width:245px; margin-top:5px'><div class='col-xs-4' >LastFm :</div><div class='col-xs-8' style='margin-top:5px'> <input id='markerlastFm' style='width:132px' type='text'> </div></div>" + 
                                      "<div class='row' style='width:245px; margin-top:5px'><div class='col-xs-12 text-right'><button id='markerButton' type='button' class='btn btn-default btn-sm'> Add </button></div></div>" +
                                      "</div>");
                infowindow.open(map);
                
                $('#markerButton').click(function(){
                var $name = $('#markerName').val();
                var $twitter = $('#markerTwitter').val();
                var $lastfm = $('#markerlastFm').val();
                console.log($name + $twitter +$lastfm );
                var marker = { name: $name , 
                               label : $name.trim().charAt(0).toUpperCase() , 
                               lat : latitude , lng : longitude, 
                               twitter : $twitter , lastfm : $lastfm };
                
                if ($name.trim() == ''|| $twitter.trim() == '' || $lastfm.trim() =='' )
                {                
                    $('#error').fadeIn();
                   setTimeout(function(){
                          $('#error').fadeOut();
                         },2000);   
                    return;
                }
                $.ajax({
                url: 'https://soen487-server.herokuapp.com/webresources/mashedservice/addUser/' + 
                      $name +'/'+  $name.trim().charAt(0).toUpperCase() + '/' + latitude + '/' + longitude+ '/' + $twitter + '/' + $lastfm
                ,
                type: 'POST',
                success: function(data) { 
                    $('#success').fadeIn();
                         setTimeout(function(){
                          $('#success').fadeOut();
                         },2000);                    
                    placeMarker( marker );          
                    infowindow.close();
                },
                error:  function(data) { 
                    $('#error').fadeIn();
                   setTimeout(function(){
                          $('#error').fadeOut();
                         },2000);                      
                }
            }); 
                });


            
            
            });

            function placeMarker( mymarker ) {
                var marker = new google.maps.Marker({
                    position: {lat: parseFloat(mymarker.lat), lng : parseFloat(mymarker.lng)},
                    map: map,
                    label: mymarker.label,                 
                });

                marker.addListener('click', function() {
                    getUserTweets(mymarker.twitter, mymarker.lastfm);
                });  
                
                marker.addListener('mouseover', function() {
                    infowindow.setContent("<h5>" + mymarker.name + "</h5>");                    
                    infowindow.open(map, (this));
                });    
                marker.addListener('mouseout', function() {
                    infowindow.setContent();
                    infowindow.close();
                });                     
                
            }
            
              $.ajax({
                url: 'https://soen487-server.herokuapp.com/webresources/mashedservice/getUsers',
                type: 'GET',
                dataType: "json",
                processData: false,
                beforeSend: function(){
                    $('.grey-spinner').show();
                },
                complete: function(){
                    $('.grey-spinner').hide();
                },                
                success: function(data) { 
                    for(var i = 0 ; i < data.length ; i++)
                    {
                        placeMarker( data[i] );
                    }
                },
                error:  function(data) { 
                    $("#twitter").html("<div class='user-info'><h2>Nothing found</h2></div>");
                }
            }); 


        }
        
        function getUserTweets(twitterName,lastFm)
        {
            $("#twitter").html("");
            $("#lastFm").html("");                
            console.log(lastFm);
            $.ajax({
                url: 'https://soen487-server.herokuapp.com/webresources/mashedservice/twitter/'+twitterName,
                type: 'GET',
                dataType: "json",
                processData: false,
                beforeSend: function(){
                    $('.blue-spinner').show();
                },
                complete: function(){
                    $('.blue-spinner').hide();
                },
                success: function(data) { 
                    
                    console.log(data); 
                    var output = "<div class='user-info'><h3>" + data.username + "</h3>" + 
                                 "<h3><small>" + data.description + "</small></h3></div>";
                    for(var i = 0 ; i < data.tweets.length ; i++)
                    {
                        output += "<div class='tweet'><p>" + data.tweets[i].text + 
                                    "<br><br>" + data.tweets[i].date + 
                                    " Likes : " + data.tweets[i].likes + 
                                    " Retweets : " + data.tweets[i].retweets +  
                                "</p></div>";
                    }
                         console.log(data.length);
                    $("#twitter").html(output);
                },
                error:  function(data) { 
                    $("#twitter").html("<div class='user-info'><h2>Nothing found</h2></div>");
                }
            }); 
            
            $.ajax({
                url: 'https://soen487-server.herokuapp.com/webresources/mashedservice/lastfm/'+lastFm,
                type: 'GET',
                dataType: "json",
                processData: false,
                beforeSend: function(){
                    $('.red-spinner').show();
                },
                complete: function(){
                    $('.red-spinner').hide();
                },                
                success: function(data) { 
                    if(data.displayName == ""){
                        $("#lastFm").html("<div class='user-info'><h2>Nothing found</h2></div>"); 
                        return;
                    }
                    var output = "<div class='user-info'><h3>" + data.user + "</h3> <img class='LastFmImg' src='" + data.profileImage + "' alt='Profile' >" + 
                                 "<h3><small>" + data.displayName + "</small></h3>\n\
                                  <h3><small>Scrobles : " + data.scrobles + "</small></h3></div>";
                    
                    if(data.songs != undefined){
                        for(var i = 0 ; i < data.songs.length ; i++)
                        {
                            output += "<div class='tweet'><p>" + data.songs[i].name + 
                                        " - " + data.songs[i].artist + 
                                        " <br> " + data.songs[i].album + 
                                        " <br><br>" + data.songs[i].date +                                     
                                    "</p></div>";
                        }
                    }else{
                        output += "<div class='tweet'><p>No Songs Found!</p></div>";
                    }
                    $("#lastFm").html(output);                    

                },
                error:  function(data) { 
                    $("#lastFm").html("<div class='user-info'><h2>Nothing found</h2></div>");                   

                }
                  
                
            });             
            
        }        
        
var $loading = $('.spinner').hide();
//$(document)
//  .ajaxStart(function () {
//    $loading.show();
//  })
//  .ajaxStop(function () {
//    $loading.hide();
//  });