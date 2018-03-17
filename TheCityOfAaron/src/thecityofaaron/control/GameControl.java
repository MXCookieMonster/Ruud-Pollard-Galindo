/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thecityofaaron.control;


import java.util.ArrayList;
import thecityofaaron.MainClass;
import thecityofaaron.model.*;
/**
 *
 * @author Tyden R
 */
public class GameControl {
    
    private static final int MAX_ROW = 5;
    private static final int MAX_COL = 5;
    
    private static Game theGame;
    
    public static void createNewGame(String pName) {
        // Create the game object. Save it in the main driver file
        theGame = new Game();
        MainClass.setTheGame(theGame);
        
        // Create the player object. Save it in the game object
        Player thePlayer = new Player();
        thePlayer.setName(pName);
        theGame.setPlayer(thePlayer);
        
        // Create the CropData object
        public static void createCropDataObject() {
            CropData theCrops = new CropData();
            
            theCrops.setYears(0);
            theCrops.setPopulation(100);
            theCrops.setNewPeople(5);
            theCrops.setCropYield(3);
            theCrops.setNumberWhoDied(0);
            theCrops.setOffering(10);
            theCrops.setWheatInStore(2700);
            theCrops.setAcresOwned(1000);
            theCrops.setAcresPlanted(1000);
            theCrops.setHarvest(3000);
            theCrops.setOfferingBushels(300);
            theCrops.setAcresPlanted(1000);
            
            theGame.setCropData(theCrops);
        }
        
        // Create the list of animals
        // Create the list of tools
        // Create the list of provisions
        
        // Create the Locations and Map object
    }

}
