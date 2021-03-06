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
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
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
            provisions.add(new ListItem("Bandages", 5));
            provisions.add(new ListItem("Coat", 1));
            provisions.add(new ListItem("Water Bottles", 10));
            
            theGame.setProvisions(provisions);
        }
        
      public static void createMap() {
            Map theMap = new Map(MAX_ROW, MAX_COL);
            
            String river = "\nYou are on the River. The river is the source" +
                    "\nof life for our city. The river marks the eastern " +
                    "\nboundary of the city-it is the wilderness to the East.";
            
            Location locRiver = new Location();
            
            locRiver.setDescription(river);
            locRiver.setSymbol("| ~~~ ");
            theMap.setLocation(2, 0, locRiver);
            theMap.setLocation(2, 1, locRiver);
            theMap.setLocation(2, 2, locRiver);
            theMap.setLocation(2, 3, locRiver);
            theMap.setLocation(2, 4, locRiver);
            
            
            String woodland = "The village where the village people live.";
            
            Location locVillage = new Location();
            
            locVillage.setDescription(woodland);
            locVillage.setSymbol("| oOo ");
            theMap.setLocation(1, 0, locVillage);
            theMap.setLocation(1, 1, locVillage);
            theMap.setLocation(1, 2, locVillage);
            theMap.setLocation(1, 3, locVillage);
            theMap.setLocation(1, 4, locVillage);
            
            String mountain = "These are the mountains where minerals are mined.";
            
            Location locMountain = new Location();
            
            locMountain.setDescription(mountain);
            locMountain.setSymbol("| ^^^ ");
            theMap.setLocation(0, 0, locMountain);
            theMap.setLocation(0, 1, locMountain);
            theMap.setLocation(0, 2, locMountain);
            theMap.setLocation(0, 3, locMountain);
            theMap.setLocation(0, 4, locMountain);
            
            String desert = "Where the wheat is cultivated and harvested.";
            
            Location locDesert = new Location();
            
            locDesert.setDescription(desert);
            locDesert.setSymbol("| !!! ");
            theMap.setLocation(3, 0, locDesert);
            theMap.setLocation(3, 1, locDesert);
            theMap.setLocation(3, 2, locDesert);
            theMap.setLocation(3, 3, locDesert);
            theMap.setLocation(3, 4, locDesert);
            theMap.setLocation(4, 0, locDesert);
            theMap.setLocation(4, 1, locDesert);
            theMap.setLocation(4, 2, locDesert);
            theMap.setLocation(4, 3, locDesert);
            theMap.setLocation(4, 4, locDesert);
            
            
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
    public static void SaveGame(String outputLocation, Game theGame) {
        
        try(FileOutputStream fops = new FileOutputStream(outputLocation))
        {
            ObjectOutputStream output = new ObjectOutputStream(fops);
            output.writeObject(theGame);
        }
        catch(Exception e)
        {
        System.out.println("\nThere was an error saving the game file");
        }    
    }
    static String readFirstLineFromFile(String path) throws Exception
    { 
         try (BufferedReader br = new BufferedReader(new FileReader(path)))
        { 
         return br.readLine();
      }
    
    }
    public static void ToolsReport(ArrayList<ListItem> tools, String outputLocation) {
        try (PrintWriter out = new PrintWriter(outputLocation)) {
            out.println("\n\nTools List");
            out.printf("%n%-20s%10s%10s","Descprition","Quantity");
            out.printf("%n-20s%10s%10s", "-----------","--------");
            
            for (ListItem item: tools ){
                out.printf("%n%-20%7d%13.2f", item.getName(), item.getQuantity());
            }
        } catch (Exception e) {
            System.out.println("Error in list printing");
        }
    }
    
    public static void ProvisionsReport(ArrayList<ListItem> provisions, String outputLocation) {
        try (PrintWriter out = new PrintWriter(outputLocation)) {
            out.println("\n\nProvisions List");
            out.printf("%n%-20s%10s%10s","Description","Quantity");
            out.printf("%n-20s%10s%10s", "-----------","----------");
            
            for (ListItem item: provisions ){
                out.printf("%n%-20%7d%13.2f", item.getName(), item.getQuantity());    
            }
        } catch (Exception e) {
            System.out.println("Error, the list cannot print");
        }
    }
}
