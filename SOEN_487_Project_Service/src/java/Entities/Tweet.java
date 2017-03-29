/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author Mouad
 */
@XmlRootElement
public class Tweet {
    public String text;
    public String date;
    public String retweets;
    public String likes;
    
    public Tweet(){
        text = "";
        date= "";
        retweets= "";
        likes= "";        
    }

    public Tweet(String text , String date, String retweets, String likes )
    {
        this.text = text;
        this.date= date;
        this.retweets= retweets;
        this.likes= likes;        
    }    

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRetweets() {
        return retweets;
    }

    public void setRetweets(String retweets) {
        this.retweets = retweets;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

}