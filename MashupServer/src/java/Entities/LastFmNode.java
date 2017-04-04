/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;
import de.umass.lastfm.Caller;
import de.umass.lastfm.PaginatedResult;
import de.umass.lastfm.Track;
import de.umass.lastfm.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mouadbouras
 */
 @XmlRootElement
public class LastFmNode {
    private final String key = "a16cf686d50c73e4d3798ab3e8f85d4a"; //this is the key used in the Last.fm API examples

    public String user ;
    public String displayName;
    public String profileImage;    
    public String scrobles ;
    public String artists ;
    public List<Song> songs; 
    
    public LastFmNode(){        
        user = "";
        displayName="";
        profileImage="";    
        scrobles ="";
        artists =  "";
        List<Song> songs;
        songs = new ArrayList<Song> ();
        songs.add(new Song());
    }
    
    public void getMusic() {
        if (user == "") return;
        System.out.println("******* username = " + user);
        Caller.getInstance().setUserAgent("");
        
        User current = User.getInfo(user,key);
        //user = current.getUrl();
        if (current == null) return;
        displayName = current.getUrl();
        profileImage = current.getImageURL();
        scrobles = current.getPlaycount()+"";
        profileImage = current.getImageURL();
        List<Song> songz = new ArrayList<Song>();


        
        PaginatedResult<Track> history = User.getRecentTracks(user,key);
        ArrayList<Track> tr = (ArrayList) history.getPageResults();
        
        for(int i = 0 ; i < tr.size() ; i++)
        {
            if(tr!=null)               
            songz.add(new Song(tr.get(i).getName() , (tr.get(i).getPlayedWhen()==null ? " Now " :  tr.get(i).getPlayedWhen() + "") ,tr.get(i).getArtist(), tr.get(i).getAlbum() ));             
           // songz.add(new Song());
        }
        
        
        songs = songz;

        
    }
        
    
//     public static void main(String args[]){
//        Caller.getInstance().setUserAgent("tst");
//        String key = "a16cf686d50c73e4d3798ab3e8f85d4a"; //this is the key used in the Last.fm API examples
//        String user = "mouadbouras";
//        PaginatedResult<Track> history = User.getRecentTracks(user,key);
//        ArrayList<Track> tr = (ArrayList) history.getPageResults();
//        
//        User current = User.getInfo(user,key);
//        System.out.println(current.getName());
//        System.out.println(current.getUrl());
//        System.out.println(current.getPlaycount());
//        System.out.println(current.getImageURL());
//
//
//        
//        for(int i = 0 ; i < tr.size() ; i++)
//        {
//            System.out.println( (tr.get(i).getPlayedWhen()==null ? " Now " :  tr.get(i).getPlayedWhen())  + " | " + 
//                                tr.get(i).getName() + " | " +
//                                tr.get(i).getArtist() + " | " +
//                                tr.get(i).getAlbum() + " | " + 
//                                tr.get(i).getAlbumMbid());
//
//        }
//        
//    }
}
