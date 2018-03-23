/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.util.Locale;
import thecityofaaron.model.*;
import thecityofaaron.control.*;
import java.util.Scanner;
import thecityofaaron.MainClass;
import thecityofaaron.model.CropData;
import exceptions.CropException;



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
     System.out.format("Land is selling for %d bushels per acre.%n", cost);   
    //  Get the user’s input and save it.
    int toBuy;
    boolean paramsNotOkay;
    do {
        paramsNotOkay = false;
        System.out.print("\nHow many acres of land do you wish to buy?");
        toBuy = keyboard.nextInt();
    try {
        CropControl.buyLand(theCropData, toBuy, cost);
    }
    catch(CropException e) {
        System.out.println("I am sorry master, I cannot do this.");
        System.out.println(e.getMessage());
        paramsNotOkay = true;
    }
    } while(paramsNotOkay);
    
    // Call the buyLand( ) method in the control layer to buy the land
   
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
        System.out.println("How many bushels of grain do you want to give to the people?\n");
        
        // User enters value
        int wheatInStore = theCropData.getWheatInStore();
        int bushelCount;
        int remainingWheat;
        do {
            bushelCount = keyboard.nextInt();
            remainingWheat = CropControl.feedPeople(wheatInStore, theCropData);
            if (remainingWheat == -1) {
                System.out.format("Please enter a positive integer less than %d", wheatInStore);
            }
        } while (remainingWheat == -1);
        
        System.out.format("There are %d bushels of wheat in store.", remainingWheat);
        
    }
 /**
 *
 * @author Joe G
 */
    public static void plantCropView(){
    
    System.out.println("You can plant 2 acres with one bushel of wheat");
    //user input
     int toPlant;     
     boolean paramsNotOkay;
     do
     {
        paramsNotOkay = false;    
        System.out.print("\nHow many acres do you wish to plant?");     
        toPlant = keyboard.nextInt();
     // call the PlantCrop method
     try
     {
         CropControl.plantCrop(toPlant, theCropData);
     }
     catch(CropException e)
     {
     int wheat = theCropData.getWheatInStore();
     System.out.println("I am sorry master, I cannot do this.");
     System.out.println(e.getMessage());
     paramsNotOkay = true;
    }
     }while(paramsNotOkay);
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
        
        payOfferingsView();
        
        displayCropReport();
    }
public static void displayCropReport()
{
    
//The year number
    int year = theCropData.getYear();
    System.out.format("The year is %d.%n",year);
//How many people starved
    int starved = theCropData.getNumStarved();
    System.out.format("The number of people who starved is %d.%n", starved);    
//How many people came to the city
    int people = theCropData.getNewPeople();
    System.out.format("The number of new people that came to the city is %d.%n",people);
//The current population
    int population = theCropData.getPopulation();
    System.out.format("The current population is %d.%n",population);
//The number of acres of crop land owned by the city
    int owned = theCropData.getAcresOwned();
    System.out.format("The numbers of acres of crop land owned by the city is %d.%n",owned);
//The number of bushels per acre in this years harvest
    int harvest =theCropData.getHarvest();
    System.out.format("The number of bushels per acre in the years harvest is %d.%n",harvest);
//The number of nushels of wheat paid in offerings
    int offering = theCropData.getOfferingBushels();
    System.out.format("The number of bushels of what paid in offerings are %d,%n",offering);
 //The number of bushels of wheat eaten by rats
    int rats = theCropData.getEatenByRats();
    System.out.format("The number of bushels of wheat eaten by the rats is %d,%n",rats);
//The number of bushels of wheat in store
    int wheat = theCropData.getWheatInStore();
    System.out.format("The number of bushels of what in store are %d.%n",wheat);
   
    
}

    public static void payOfferingsView() {
        System.out.print("What percentage of your harvest do you want to pay in tithes and offerings.");
        
        int offerings;
        
        do {
            offerings = keyboard.nextInt();
            offerings = CropControl.setOffering(offerings, theCropData);
            if (offerings == 1) {
                System.out.print("Please enter an integer between 0 and 100");
            }
        } while(offerings == -1);
        
        theCropData.setOffering(offerings);
       
    }
    
}
