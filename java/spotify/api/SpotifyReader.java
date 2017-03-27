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

/*
import org.json.simple.JSONArray;
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
   /*  public static void main(String[] args) throws IOException, ParseException {
         
      getSpotifyURL("738wLrAtLtCtFOLvQBXOXp");   
     }
     */
/*
    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try {

           //url: https://api.spotify.com/v1/artists/1uNFoZAHBGtllmzznpCI3s
           
           
          // URL url = new URL("https://api.spotify.com/v1/artists/1uNFoZAHBGtllmzznpCI3s");//Justin Bieber
           URL url = new URL("https://api.spotify.com/v1/artists/5pKCCKE2ajJHZ9KAiaK11H"); //Rihanna
            URLConnection conn = url.openConnection();
            //BufferedReader input = new BufferedReader(new InputStreamReader(conn.getInputStream()));
           // String in = input.toString();
            
          // Object obj = url.toString();
           //Object obj = parser.parse(new FileReader("C:/Users/Aakash/Desktop/sample.json"));
           Object obj = parser.parse(new InputStreamReader(conn.getInputStream()));
//String jsonResult = UtilMethods.getJSON(this.jsonURL, null);

            JSONObject jsonObject = (JSONObject) obj;

            JSONObject external = (JSONObject)jsonObject.get("external_urls");
            ///JSONObject steps = (JSONObject)metrics.get("spotify");          


            System.out.println(external.get("spotify"));
// String loudScreaming = jsonObject.getJSONObject("external_urls").getString("spotify");
           /*
           JSONObject jsonObject = new JSONObject(jsonAsString);
JSONArray array = jsonObject.getJSONArray("locations");*/

//You should check that array.length() >= 3
/*JSONObject job = array.getJSONObject(2);
String site = job.getString("site");
           
    Object level = url.get("2");

    System.out.println(level);
  */          
            
          //  System.out.println(jsonObject);

           // String name = (String) jsonObject.get("external_urls");
         //   System.out.println(steps.toString());

            //long age = (Long) jsonObject.get("age");
           // System.out.println(age);

            // loop array
           // String msg = (String) jsonObject.get("href");
           // Iterator<String> iterator = msg.iterator();
            /*while (iterator.hasNext()) {
                System.out.println("1 "+iterator.next());
            }
 // System.out.println(""+msg+"");
        
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(SpotifyReader.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }

    */
    /*********************************
    738wLrAtLtCtFOLvQBXOXp//Major Lazer
    1uNFoZAHBGtllmzznpCI3s//Justin Bieber
    5pKCCKE2ajJHZ9KAiaK11H //Rihanna
            ************************************/
    
    /*
      JSONArray msg = (JSONArray) jsonObject.get("messages");
            Iterator<String> iterator = msg.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
    */
    
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
               // System.out.println(iterate.next());
            }
        
        return listGenre;
    }
    
    
    
    public static String getSingerName(String trackID) throws MalformedURLException, IOException, ParseException
    {
         JSONParser parser = new JSONParser();
          
          String in = "https://api.spotify.com/v1/artists/"+trackID;
          URL url = new URL(in);
                  
         
            URLConnection conn = url.openConnection();
            //BufferedReader input = new BufferedReader(new InputStreamReader(conn.getInputStream()));
           // String in = input.toString();
            
          // Object obj = url.toString();
           //Object obj = parser.parse(new FileReader("C:/Users/Aakash/Desktop/sample.json"));
           Object obj = parser.parse(new InputStreamReader(conn.getInputStream()));
//String jsonResult = UtilMethods.getJSON(this.jsonURL, null);

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
            //BufferedReader input = new BufferedReader(new InputStreamReader(conn.getInputStream()));
           // String in = input.toString();
            
          // Object obj = url.toString();
           //Object obj = parser.parse(new FileReader("C:/Users/Aakash/Desktop/sample.json"));
           Object obj = parser.parse(new InputStreamReader(conn.getInputStream()));
//String jsonResult = UtilMethods.getJSON(this.jsonURL, null);

            JSONObject jsonObject = (JSONObject) obj;
             
    
          long pop = (long)jsonObject.get("popularity");
         
            return pop;
        
    }
    
    
    public static String getSpotifyURL(String trackID) throws MalformedURLException, IOException, ParseException
    {
            JSONParser parser = new JSONParser();
            //URL url = new URL("https://play.spotify.com/album/5SyG46cGUdAVA85UNF4VVu/6Hx9gLuAKkOfoZoL79OSI1");  
          
          String in = "https://api.spotify.com/v1/artists/"+trackID;
          URL url = new URL(in);
                  
         //  URL url = new URL("https://api.spotify.com/v1/artists/5pKCCKE2ajJHZ9KAiaK11H"); //Rihanna
         
        // https://play.spotify.com/artist/738wLrAtLtCtFOLvQBXOXp
            URLConnection conn = url.openConnection();
            //BufferedReader input = new BufferedReader(new InputStreamReader(conn.getInputStream()));
           // String in = input.toString();
            
          // Object obj = url.toString();
           //Object obj = parser.parse(new FileReader("C:/Users/Aakash/Desktop/sample.json"));
           Object obj = parser.parse(new InputStreamReader(conn.getInputStream()));
//String jsonResult = UtilMethods.getJSON(this.jsonURL, null);

            JSONObject jsonObject = (JSONObject) obj;
             
            JSONObject external = (JSONObject)jsonObject.get("external_urls");
          String name = (String)jsonObject.get("name");
           ///JSONObject steps = (JSONObject)metrics.get("spotify");          
    
           // String nameout = name.toString();
            //System.out.println(name.toString());

            System.out.println(external.get("spotify"));
                 
            String surl = external.get("spotify").toString();
            return surl;
    }
    
}
