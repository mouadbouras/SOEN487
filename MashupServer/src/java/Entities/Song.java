/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author mouadbouras
 */
public class Song {
    public String name;
    public String artist;
    public String album;
    public String date;
    
    public Song(){
        name = "";
        date= "";
        artist= "";
        album= "";        
    }

    public Song(String name , String date, String artist, String album )
    {
        this.name = name;
        this.date= date;
        this.artist= artist;
        this.album= album;        
    }    

    public String getText() {
        return name;
    }

    public void setText(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

}