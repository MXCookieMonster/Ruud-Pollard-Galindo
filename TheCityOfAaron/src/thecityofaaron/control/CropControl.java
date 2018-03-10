/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thecityofaaron.control;

import thecityofaaron.model.CropData;
import java.util.Random;
/**
 *
 * @author Tyden R
 */
public class CropControl {
    
    //Constants
    private static final int LAND_BASE = 17;
    private static final int LAND_RANGE = 10;
    private static final int PEOPLE_PER_ACRE = 10;
    //random number generator
    private static Random random = new Random();
    
    //calcLandCost() method
    //Purpose: Calculate a random land cost between 17 and 26 bushels
    //Parameters: none
    //Returns: land cost
    
    public static int calcLandCost() {
        int landPrice = random.nextInt(LAND_RANGE) + LAND_BASE;
        return landPrice;
    }
    /**
    *
    * @author Joe G
    */
    //Credit: Bro DeBry MiniAaron
    //buyLand method
    //Purpose: Buy land - adds to acres owned
    //Parameters: The game object and the number of acres to buy
    //Pre-conditions: 0 < tobuy and wheatInStore. wheatInStore > buy * landPrice
    //Returns: amount of wheatInStore after buying the land
    public static int buyLand(CropData theCrops, int toBuy, int landCost)
    {
       // toBuy is not less than zero
       // returns -1 if less than zero
        if(toBuy <0)
        return -1; 
        
       //land request cannot be more that wheatInStore
       // less wheatInStore than amount requested, return -1
       int wheat = theCrops.getWheatInStore();
       if(wheat < toBuy * landCost)
       return -1;
       
       //make sure enough people to tend the land
       // one person per 10 acres
       
       int population = theCrops.getPopulation();
       if(toBuy > population * PEOPLE_PER_ACRE)
       
    return -1; 
       
       // add the number of purchased acres to acresOwned
       int acres = theCrops.getAcresOwned();

        acres += toBuy;
        // Set new value
        theCrops.setAcresOwned(acres);
     
     //Purchase less whatInStore   
     wheat -= (toBuy * landCost);

     theCrops.setWheatInStore(wheat);  
     
     return acres;
        
    }
//The sellLand method
    //Purpose: To sell land
    //Parameters: the price of land, the number of acres to sell
    // and a reference to a CropData object
    //Returns: the acres to sell must be positive
    //and <= acresOwned
    
    public static int sellLand(int landPrice, int acresToSell, CropData cropData) {
    
        //if acresToSell < 0, return -1
        //if acresToSell > acresOwned, return -1
        //acresOwned = acresOwned - acresToSell
        //wheatInStore = wheatInStore + acresToSell * landPrice
        //return acresOwned
        
        //if acresToSell > acresOwned, return -1
        int owned = cropData.getAcresOwned();
        if(acresToSell > owned) {
            return -1;
        }
        
        //acresOwned = acresOwned - acresToSell
        owned -= acresToSell;
        cropData.setAcresOwned(owned);
        
        //wheatInStore = wheatInStore + (acresToBuy * landPrice)
        int wheat = cropData.getWheatInStore();
        wheat -= (acresToSell * landPrice);
        cropData.setWheatInStore(wheat);
        
        //return acresOwned
        return owned;
        
    }
    
    public static int setOffering(int offering) {
        // The setOffering method
        // Purpose: indicate what percentage of the harvest is to be paid as an offering
        // Parameters: percentage indicated by user input
        // Returns: the percentage indicated by user input
        // Pre-conditions: the percentage must be greater than or equal to 0
        // and must be less than or equal to 100
        
        //If offering < 0, return -1
        if (offering < 0) {
            return -1;
        }
        //If offering > 100, return -1
        else if (offering > 100) {
            return -1;
        }
        //Return offering
        else {
            return offering;
        }
    }
    
    public static int feedPeople(int currentPopulation, int wheatForPeople, int wheatInStore){
        //This method feeds the people
        //Purpose: To feed the people for the current year
        //Parameters: Current Population, wheat in store
        //Returns: People fed
        //Pre-Conditions: The number bushels entered must be positive, number of bushels set aside can't be more
        //than wheat in store. 
        
        //If wheatForPeople < 0, return -1
        if (wheatForPeople < 0) {
            return -1;
        }
        
        //If wheatForPeople > wheatInStore, return -1
        if (wheatForPeople > wheatInStore) {
            return -1;
        }
        
        //Getting the number of people survived
        currentPopulation = wheatForPeople / 20;
        
        //Returns the Population
        return currentPopulation;
    }
    
    /**
    *
    * @author Joe G
    */
    public static int plantCrop(int acresToPlant, CropData cropData) {
        
        //The plant the crop method
        //Purpose: Plant the crop for next year
        //Parameters: number of acres owned, amount of wheat in store, cost to plant
        //Pre-conditions: The acres planted must be positive, The numbers of acres 
        //owned must be more than the number of acres planted, the cost of bushels to plant must be 
        //less than the bushels of wheat in store.
        //Returns: wheat in store after planting crop

        
        
        //bushelsToPlant = acresToPlant / 2
        int bushels = acresToPlant /2;
        //If acresToPlant < 0, return -1
        if(acresToPlant < 0)
            return -1;
        //if acresOwned < acresToPlant, return -1
        int owned = cropData.getAcresOwned();
         if(owned < acresToPlant)
            return -1;
        
        //if  wheatInStore < bushelsToPlant, return -1
        //bushelsToPlant = acresToPlant / 2

        int wheat = cropData.getWheatInStore();
                
        if(wheat < bushels)
            return -1;
                   
        //wheatInStore = wheatinStore - bushelsToPlant       
        wheat-= bushels;
        
        
        //return wheat after bushels spent
        return wheat;
    }     
}    


   
    