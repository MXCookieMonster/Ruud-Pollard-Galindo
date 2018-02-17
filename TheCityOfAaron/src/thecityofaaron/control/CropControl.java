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

