/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import thecityofaaron.model.*;
import thecityofaaron.control.*;
import java.util.Scanner;
import thecityofaaron.MainClass;
import thecityofaaron.model.CropData;



/**
 *
 * @author Joe G
 */
public class CropView {

 // Create a Scanner object
 private static Scanner keyboard = new Scanner(System.in);   
 
 private static final int ACRES_PER_BUSHEL = 2;
 private static final int PEOPLE_PER_ACRE = 9;    
 
// Get reference to the Game object and the Crops object
 private static Game theGame = MainClass.getTheGame();
 private static CropData theCropData = theGame.getCropData();
   


// The buyLandView method
 // Purpose: interface with the user input for buying land
// Parameters: none
 // Returns: none
 
public static void buyLandView()
 {
     // Get the cost of land for this round.
     int cost = CropControl.calcLandCost();
     // Prompt the user to enter the number of acres to buy
     System.out.format("Land is selling for %d bushels per acre %n", cost);   
     System.out.print("\nHow many acres of land do you wish to buy?");
    //  Get the user’s input and save it.
    int toBuy;
    toBuy = keyboard.nextInt();
    // Call the buyLand( ) method in the control layer to buy the land
    CropControl.buyLand(theCropData, toBuy,cost);
}
// The runCropsView method()
// Purpose: runs the Hamurabi game
// Parameters: none
// Returns: none
public static void runCropsView(){

    // call the buyLandView( ) method
    //buyLandView( );

    // add calls to the other crop view methods
    // as they are written
}

public static void sellLandView() {
        
        //cost of land for the round
        int price = CropControl.calcLandCost();
        
        //enter number of acres user wantes to sell
        System.out.format("Land is selling for %d bushels per acre.%n",price);
        System.out.print("\nHow many acres of land do you wish to sell? "); 
        
        //Users input
        int toSell;
        toSell = keyboard.nextInt();
        
        //Call sellLand method 
        CropControl.sellLand(toSell, price, theCropData);
    }
    public static void feedPeopleView() {
        
        // Ask user "How many bushels...?"
        System.out.println("How many bushes of grain do you want to give to the people?\n");
        
        // User enters value
        int bushelCount = keyboard.nextInt();
        
        // Check value
        // Make sure the city has this much wheat in storage.
        int wheatInStore = theGame.getCropData().getWheatInStore();
        int error = 0;
        do {
            if(bushelCount == -1) {
               error = 1;
               System.out.println("Please enter a positive integer.");
            } else if (bushelCount > wheatInStore) {
                System.out.println("You do not have enough wheat in store.");
            }
        } while (error == 1);
        
        if (error == 0) {
        
            // Subtract this amount from the wheat in storage. Display remaining wheat
            wheatInStore -= bushelCount;
        
            // Update the game state to save how many bushels of wheat you have set aside to feed the people
        }
        
    }
 /**
 *
 * @author Joe G
 */
    public static void plantCropView(){
    
    //enter number acres user wants to plant
     System.out.format("To plant crop it costs %d bushels per acre.%n");
     System.out.print("\nHow many acres do you wish to plant? ");
     //user input
     int toPlant;
     toPlant = keyboard.nextInt();
     // call the PlantCrop method
     CropControl.plantCrop(toPlant, theCropData);
    }
    // the runcCropsView method

    // Purpose: to run all of the cropview methods in order

    // Parameters: none

    // Returns: none

    public static void runCropViews()

    {

        buyLandView();

        sellLandView();

        feedPeopleView();

        plantCropView();

    }

    
}