/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import twitter4j.User;

/**
 *
 * @author Mouad
 */
 @XmlRootElement
public class TwitterNode {
    public String username ;
    public String description ;
    public List<Tweet> tweets; 

    public TwitterNode(){
        username ="";
        description ="";
        tweets = new ArrayList<Tweet> ();
        tweets.add(new Tweet());
    }
    
    public void getFeed() {
        if (username == "") return;
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("9nXYodn5suyXQSCR02p9BaeaI")
                .setOAuthConsumerSecret("vOftblWaqEgtmcl06Z8TFVuF9Xnfu8uW4ABORAlhaHyn3QpVUR")
                .setOAuthAccessToken("261778164-WdPpywEoWjP51ZuPE7hFNMEXKLyIYVxAerwHt5i7")
                .setOAuthAccessTokenSecret("N43J3u4MByDQaMaXIvuXnXPofR6HDxjWZBIot0sGmwVfp");
        Twitter twitter = new TwitterFactory(cb.build()).getInstance();

        try {
            List<Status> statuses;
            Paging paging = new Paging(1, 10);
            statuses = twitter.getUserTimeline(username, paging);
            
            List<Tweet> tweets = new ArrayList<Tweet>();
            
            for(Status status : statuses) {
                Tweet tweet = new Tweet();
                tweet.setDate(status.getCreatedAt().toString());
                tweet.setLikes(status.getFavoriteCount()+"");
                tweet.setRetweets(status.getRetweetCount()+"");
                tweet.setText(status.getText());
                tweets.add(tweet);
            }
            this.tweets = tweets;
            User tuser = twitter.showUser(username);
            description = tuser.getDescription();
            

        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
            //System.exit(-1);
        }
        }
    
    
}
