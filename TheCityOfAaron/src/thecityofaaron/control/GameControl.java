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
        
        createCropDataObject();
        createAnimalList();
        createToolList();
        createProvisionList();
        createMap();
        
    }

    // Create the CropData object
        public static void createCropDataObject() {
            CropData theCrops = new CropData();
            
            theCrops.setYear(0);
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
        public static void createAnimalList() {
            ArrayList<ListItem> animals = new ArrayList<>();
            
            animals.add(new ListItem("cows", 12));
            animals.add(new ListItem("horses", 3));
            animals.add(new ListItem("pigs", 7));
            animals.add(new ListItem("goats", 4));
            
            theGame.setAnimals(animals);
        }
        
        // Create the list of tools
        public static void createToolList() {
            ArrayList<ListItem> tools = new ArrayList<>();
            tools.add(new ListItem("hammer",4));
            tools.add(new ListItem("shovel",6));
            tools.add(new ListItem("plow",2));
            tools.add(new ListItem("grubber",3));
            tools.add(new ListItem("hoe",5));
            theGame.setTools(tools);
        }
       
        // Create the list of provisions
        public static void createProvisionList() {
            ArrayList<ListItem> provisions = new ArrayList<>(); 
            
            theGame.setProvisions(provisions);
        }
        
        // Create the Locations and Map object
        public static void createMap() {
            Map theMap = new Map(MAX_ROW, MAX_COL);
            
            String river = "\nYou are on the River. The river is the source" +
                    "\nof life for our city. The river marks the eastern " +
                    "\nboundary of the city-it is the wilderness to the East.";
            
            Location loc = new Location();
            
            loc.setDescription(river);
            loc.setSymbol("~~~");
            
            for(int i = 0; i < MAX_ROW; i++) {
                theMap.setLocation(i, 4, loc);
            }
            
            theGame.setTheMap(theMap);
        }
    
}
