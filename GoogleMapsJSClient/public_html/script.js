/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


        var map;
        
        var markers =[{ name: "Mouad Bouras" , label : "B" , lat : 45.5093356 , lng : -73.677426, twitter : "mouadbouras" , spotify:"mouadbouras"} ,
                      { name: "Concordia " , label : "S" , lat : 45.492261 , lng : -73.5783127, twitter :"concordia"  , spotify:""},
                      { name: "Sean Canlas" , label : "G" , lat : 45.4609075 , lng : -73.6278422, twitter :"seancanlas" , spotify:""},
                      {name: "Trisha Dimayuga" , label : "D" , lat: 45.4729346, lng: -73.6552988, twitter :"trishapoynter"  , spotify:""},
                      { name: "Mike Cabana" , label:"C"   , lat: 45.604174, lng: -73.6724567, twitter :"mikecabana" , spotify:""}, 
                      { name: "Martin Nafekh" , label:"N"   , lat: 45.4842901, lng: -73.8476348, twitter :""  , spotify:""}, 
                      {name: "Aakash Patel" , label:"P"   , lat: 45.5709407, lng: -73.7029947, twitter : "" , spotify:""}]; 
        
        function initMap() {
            var infowindow = new google.maps.InfoWindow();
            map = new google.maps.Map(document.getElementById('map'), {
              center: {lat: 45.5425158, lng: -73.6378987},
              zoom: 11
            });
            
            map.addListener('click', function(event) {
                var latitude = event.latLng.lat();
                var longitude = event.latLng.lng();
                
                infowindow.setPosition(event.latLng);
                infowindow.setContent("<h5>New Marker : </h5>" +
                                      "" +
                                      "<div class='row' style='width:245px; margin-top:5px'><div class='col-xs-4' >Name :</div><div class='col-xs-8' style='margin-top:5px'> <input id='markerName' style='width:132px' type='text'> </div></div>" +
                                      "<div class='row' style='width:245px;margin-top:5px'><div class='col-xs-4' >Twitter :</div><div class='col-xs-8' style='margin-top:5px'> <input id='markerTwitter' style='width:132px' type='text'></div> </div>" +
                                      "<div class='row' style='width:245px; margin-top:5px'><div class='col-xs-4' >Spotify :</div><div class='col-xs-8' style='margin-top:5px'> <input id='markerSpotify' style='width:132px' type='text'> </div></div>" + 
                                      "<div class='row' style='width:245px; margin-top:5px'><div class='col-xs-12 text-right'><button id='markerButton' type='button' class='btn btn-default btn-sm'> Add </button></div></div>" +
                                      "");
                infowindow.open(map);
                
                $('#markerButton').click(function(){

                var marker = { name: $('#markerName').val() , 
                               label : $('#markerName').val().trim().charAt(0).toUpperCase() , 
                               lat : latitude , lng : longitude, 
                               twitter : $('#markerTwitter').val() , spotify : $('#markerSpotify').val()};
                placeMarker( marker );          
                infowindow.close();


                });

                

                
                
          });

          


            function placeMarker( mymarker ) {
                var marker = new google.maps.Marker({
                    position: {lat: mymarker.lat, lng : mymarker.lng},
                    map: map,
                    label: mymarker.label,                 
                });

                marker.addListener('click', function() {
                    getUserTweets(mymarker.twitter);
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

            for(var i = 0 ; i < markers.length ; i++)
            {
                placeMarker( markers[i] );
            }
        }
        
        function getUserTweets(twitterName)
        {
            console.log(twitterName);
            $.ajax({
                url: 'https://arcane-wave-75994.herokuapp.com/webresources/mashedservice/'+twitterName +'/spotify',
                type: 'GET',
                dataType: "json",
                processData: false,
                success: function(data) { 
                    
                    console.log(data["twiits"]); 
                    var output = "<div class='user-info'><h3>" + data.twiits.username + "</h3>" + 
                                 "<h3><small>" + data.twiits.description + "</small></h3></div>";
                    for(var i = 0 ; i < data.twiits.tweets.length ; i++)
                    {
                        output += "<div class='tweet'><p>" + data.twiits.tweets[i].text + 
                                    "<br><br>" + data.twiits.tweets[i].date + 
                                    " Likes : " + data.twiits.tweets[i].likes + 
                                    " Retweets : " + data.twiits.tweets[i].retweets +  
                                "</p></div>";
                    }
                         console.log(data.twiits.length);
                    $("#twitter").html(output);
                },
                error:  function(data) { 
                    $("#twitter").html("<div class='user-info'><h2>Nothing found</h2></div>");

                }
                  
                
            }); 
            
        }        
$(function() {            


});
