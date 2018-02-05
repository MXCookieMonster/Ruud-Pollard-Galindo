/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thecityofaaron;

import thecityofaaron.model.ListItem;
import thecityofaaron.model.Player;
import thecityofaaron.model.TeamMember;
import thecityofaaron.model.Location;
import thecityofaaron.model.CropData;

/**
 *
 * @author Tyden R
 */
public class MainClass {
    
    //Main
    public static void main(String[] args) {
        
        //Player Class
        Player playerOne = new Player();
        playerOne.setName("Fred Flintstone");
        String playerOneName = playerOne.getName();
        
        System.out.println(playerOne.toString());
        
        //ListItem Class
        ListItem item = new ListItem();
        item.setName("Hammer");
        ListItem number = new ListItem();
        number.setQuantity(1);
        
        System.out.println(item.toString());
        
        //Team member enum
        System.out.println(TeamMember.Tyden.getName());
        System.out.println(TeamMember.Tyden.getTitle());
        System.out.println(TeamMember.Josafat.getName());
        System.out.println(TeamMember.Josafat.getTitle());
        System.out.println(TeamMember.Roger.getName());
        System.out.println(TeamMember.Roger.getTitle());
        
        //Location Class
        Location locationOne = new Location();
        
        locationOne.setDescription("Test description");
        locationOne.setSymbol("Test Symbol");
        
        String locationOneDescription = locationOne.getDescription();
        String locationOneSymbol = locationOne.getSymbol();
        
        System.out.println(locationOneDescription);
        System.out.println(locationOneSymbol);
        System.out.println(locationOne.toString());
        
        //Crop Data Class
        CropData cdatapOne = new CropData();
        
        cdatapOne.setYear(1);
        int year = cdatapOne.getYear();
        System.out.println(cdatapOne.toString());
        
    }
    
}