/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thecityofaaron;

import thecityofaaron.model.ListItem;
import thecityofaaron.model.Game;
import thecityofaaron.model.Player;
import thecityofaaron.model.TeamMember;
import thecityofaaron.model.Location;
import thecityofaaron.model.CropData;
import view.MainMenuView;
import view.GameMenuView;

/**
 *
 * @author Tyden R
 */
public class MainClass {
    
    private static Game theGame = null;

    public static Game getTheGame() {
        return theGame;
    }

    //variable for keeping a reference to the Game object
    public static void setTheGame(Game theGame) {
        MainClass.theGame = theGame;
    }
    
    //Main
    public static void main(String[] args) {
        
        MainMenuView mmv = new MainMenuView();
        mmv.displayMenu();
        
    }
    
}