/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thecityofaaron.control;


import java.util.ArrayList;
import thecityofaaron.MainClass;
import thecityofaaron.model.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.ObjectInputStream;
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
        
        public static void createMap() {
            Map theMap = new Map(MAX_ROW, MAX_COL);
            
            String river = "\nYou are on the River. The river is the source" +
                    "\nof life for our city. The river marks the eastern " +
                    "\nboundary of the city-it is the wilderness to the East.";
            
            Location locRiver = new Location();
            
            locRiver.setDescription(river);
            locRiver.setSymbol("~~~");
            
            for(int i = 0; i < MAX_ROW; i++) {
                theMap.setLocation(i, 4, locRiver);
            }
            
            String woodland = "This is a woodland";
            
            Location locWoodland = new Location();
            
            locWoodland.setDescription(woodland);
            locWoodland.setSymbol("TTT");
            theMap.setLocation(3, 0, locWoodland);
            theMap.setLocation(2, 0, locWoodland);
            theMap.setLocation(2, 1, locWoodland);
            theMap.setLocation(1, 1, locWoodland);
            
            String mountain = "This is a mountain";
            
            Location locMountain = new Location();
            
            locMountain.setDescription(mountain);
            locMountain.setSymbol("^^^");
            theMap.setLocation(0, 0, locMountain);
            theMap.setLocation(0, 1, locMountain);
            theMap.setLocation(1, 0, locMountain);
            
            String desert = "This is a desert";
            
            Location locDesert = new Location();
            
            locDesert.setDescription(desert);
            locDesert.setSymbol("___");
            theMap.setLocation(4, 0, locDesert);
            theMap.setLocation(3, 1, locDesert);
            theMap.setLocation(4, 1, locDesert);
            theMap.setLocation(0, 2, locDesert);
            theMap.setLocation(1, 2, locDesert);
            theMap.setLocation(2, 2, locDesert);
            theMap.setLocation(3, 2, locDesert);
            theMap.setLocation(4, 2, locDesert);
            theMap.setLocation(0, 3, locDesert);
            theMap.setLocation(1, 3, locDesert);
            theMap.setLocation(2, 3, locDesert);
            theMap.setLocation(3, 3, locDesert);
            theMap.setLocation(4, 3, locDesert);
            
            theGame.setTheMap(theMap);
        }

    public static void getSavedGame(String filePath) {
        
        Game theGame = null;
        try(FileInputStream fips = new FileInputStream(filePath))
        {
            ObjectInputStream input = new ObjectInputStream(fips);
            theGame=(Game) input.readObject();
        }
        catch(Exception e)
        {
        System.out.println("\nThere was an error reading the saved game file");
        }    
    }
static String readFirstLineFromFile(String path) throws IOException
{ 
     try (BufferedReader br = new BufferedReader(new FileReader(path)))
    { 
         return br.readLine();
      }
}

   
}
