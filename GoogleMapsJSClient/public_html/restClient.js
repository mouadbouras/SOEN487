///* 
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//$(document).ready(function(){
//    $.ajax({
//        url: 'http://localhost:8080/A2Q2WebService/webresources/generic/getTemperature',
//        type: 'GET',
//        //data: '',
//        dataType: "text",
//        processData: false,
//        success: function(data) { 
//            $("#spanTmpToday").html(data);
//            //console.log(data); 
//        }
//    }); 
//    
//    $("#btnSetTmp").click(function (){                
//        //Updating today's temperature
//        $.ajax({
//            url: 'http://localhost:8080/A2Q2WebService/webresources/generic/getTemperature',
//            type: 'GET',
//            //data: '',
//            dataType: "text",
//            processData: false,
//            success: function(data) { 
//                $("#spanTmpToday").html(data);
//                //console.log(data); 
//            }
//        }); 
//        
//        //Setting new temperature        
//        var input = $("#txtSetTemp").val();
//        $.ajax({
//            url: 'http://localhost:8080/A2Q2WebService/webresources/generic/' + input,
//            type: 'PUT',
//            //data: '', 
//            dataType: "XML",
//            processData: false,
//            success: function(data) { 
//                $("#divNewTemp").html("<h4>Today's temperature is  " + input + "!</h4>");                
//            },
//            error: function(data) { 
//                $("#divNewTemp").html("<h4>An Error Occured!</h4>");
//            }
//        });              
//                
//    });
//
//    
//       
//    
//
//    
//});// Document.ready
//
