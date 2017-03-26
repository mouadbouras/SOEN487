/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mouad
 */
 @XmlRootElement
public class MashedNode {
    public TwitterNode twiits;
    public String spotifyNode;
    
    public MashedNode(){
        twiits = new TwitterNode();
    };
    
    public void LoadData(String twitter, String spotify){
        
        
        twiits.username = twitter;
        twiits.description = "";

        if (twitter == "") return;
        twiits.getFeed();  
        
    }
    

}
