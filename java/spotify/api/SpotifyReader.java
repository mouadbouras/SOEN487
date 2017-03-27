package spotify.api;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aakash
 */


import java.io.BufferedReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SpotifyReader {
   
    
    public static String getGenre(String trackID) throws MalformedURLException, IOException, ParseException
    {
        String listGenre = "";
        JSONParser parser = new JSONParser();
          
          String in = "https://api.spotify.com/v1/artists/"+trackID;
          URL url = new URL(in);
         
          URLConnection conn = url.openConnection();
          
          Object obj = parser.parse(new InputStreamReader(conn.getInputStream()));
          JSONObject jsonObject = (JSONObject) obj;
          
          JSONArray genre = (JSONArray) jsonObject.get("genres");
            Iterator<String> iterate = genre.iterator();
            while (iterate.hasNext()) {
                listGenre += iterate.next() +" | ";
             
            }
        
        return listGenre;
    }
    
    
    
    public static String getSingerName(String trackID) throws MalformedURLException, IOException, ParseException
    {
         JSONParser parser = new JSONParser();
          
          String in = "https://api.spotify.com/v1/artists/"+trackID;
          URL url = new URL(in);
                  
         
            URLConnection conn = url.openConnection();
           
           Object obj = parser.parse(new InputStreamReader(conn.getInputStream()));

            JSONObject jsonObject = (JSONObject) obj;
             
    
          String name = (String)jsonObject.get("name");
         
            return name;
        
    }
  
    public static long getPopularity(String trackID) throws MalformedURLException, IOException, ParseException
    {
         JSONParser parser = new JSONParser();
          
          String in = "https://api.spotify.com/v1/artists/"+trackID;
          URL url = new URL(in);
                  
         
            URLConnection conn = url.openConnection();
          
           Object obj = parser.parse(new InputStreamReader(conn.getInputStream()));

            JSONObject jsonObject = (JSONObject) obj;
             
    
          long pop = (long)jsonObject.get("popularity");
         
            return pop;
        
    }
    
    
    public static String getSpotifyURL(String trackID) throws MalformedURLException, IOException, ParseException
    {
            JSONParser parser = new JSONParser();
           
          
          String in = "https://api.spotify.com/v1/artists/"+trackID;
          URL url = new URL(in);
                  
         
         
        
            URLConnection conn = url.openConnection();
         
           Object obj = parser.parse(new InputStreamReader(conn.getInputStream()));


            JSONObject jsonObject = (JSONObject) obj;
             
            JSONObject external = (JSONObject)jsonObject.get("external_urls");
          String name = (String)jsonObject.get("name");
          
            System.out.println(external.get("spotify"));
                 
            String surl = external.get("spotify").toString();
            return surl;
    }
    
}
