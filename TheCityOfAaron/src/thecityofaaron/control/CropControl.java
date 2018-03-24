/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thecityofaaron.control;

import thecityofaaron.model.CropData;
import java.util.Random;
import exceptions.CropException;
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
    public static void buyLand(CropData theCrops, int toBuy, int landCost) throws CropException
    {
       // toBuy is not less than zero
       // returns -1 if less than zero
        if(toBuy <0)
        throw new CropException("A negative value was input"); 
        
       //land request cannot be more that wheatInStore
       // less wheatInStore than amount requested, return -1
       int wheat = theCrops.getWheatInStore();
       if(wheat < toBuy * landCost)
       throw new CropException("There is insufficent wheat to buy this much land");
       
       //make sure enough people to tend the land
       // one person per 10 acres
       
       int population = theCrops.getPopulation();
       if(toBuy > population * PEOPLE_PER_ACRE)
       
       throw new CropException("Not enough people to tend that much land"); 
       
       // add the number of purchased acres to acresOwned
       int acres = theCrops.getAcresOwned();

        acres += toBuy;
        // Set new value
        theCrops.setAcresOwned(acres);
     
     //Purchase less whatInStore   
     wheat -= (toBuy * landCost);

     theCrops.setWheatInStore(wheat);  
     
            
    }
//The sellLand method
    //Purpose: To sell land
    //Parameters: the price of land, the number of acres to sell
    // and a reference to a CropData object
    //Returns: the acres to sell must be positive
    //and <= acresOwned
    
    public static void sellLand(int landPrice, int acresToSell, CropData cropData) throws CropException {
    
        //if acresToSell < 0, return -1
        //if acresToSell > acresOwned, return -1
        //acresOwned = acresOwned - acresToSell
        //wheatInStore = wheatInStore + acresToSell * landPrice
        //return acresOwned
        
        //if acresToSell > acresOwned, return -1
        int owned = cropData.getAcresOwned();
        if(acresToSell > owned) {
            throw new CropException("You cannot sell more land then you own");
        }
        
        //acresOwned = acresOwned - acresToSell
        owned -= acresToSell;
        cropData.setAcresOwned(owned);
        
        //wheatInStore = wheatInStore + (acresToBuy * landPrice)
        int wheat = cropData.getWheatInStore();
        wheat -= (acresToSell * landPrice);
        cropData.setWheatInStore(wheat);
    }
    
    public static int setOffering(int offering, CropData cropData) {
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
    
    public static void feedPeople(int wheatToFeed, CropData cropData)throws CropException
    {
        //This method feeds the people
        //Purpose: To feed the people for the current year
        //Parameters: Current Population, wheat in store
        //Returns: People fed
        //Pre-Conditions: The number bushels entered must be positive, number of bushels set aside can't be more
        //than wheat in store. 
        
        //If wheatForPeople < 0, return -1
        if (wheatToFeed < 0) {
            throw new CropException("A negative value was input");
        }
        
        //If wheatForPeople > wheatInStore, return -1
         int wheat = cropData.getWheatInStore();
        if (wheatToFeed > wheat) {
            throw new CropException("There is not enough wheat to feed that many people");
        }
        
        
        
        wheat-= wheat-wheatToFeed;
        cropData.setWheatForPeople(wheat);
        
        //Getting the number of people survived
        cropData.population = wheatToFeed / 20;
        
       
    }
    
    /**
    *
    * @author Joe G
    */
    public static void plantCrop(int acresToPlant, CropData cropData) throws CropException {
        
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
            throw new CropException("A negative value was input");
        //if acresOwned < acresToPlant, return -1
        int owned = cropData.getAcresOwned();
         if(owned < acresToPlant)
            throw new CropException("There is insuficient land to plant crops");
        
        //if  wheatInStore < bushelsToPlant, return -1
        //bushelsToPlant = acresToPlant / 2

        int wheat = cropData.getWheatInStore();
                
        if(wheat < bushels)
            throw new CropException("There is insuficient wheat to plant crops");
                   
        //wheatInStore = wheatinStore - bushelsToPlant       
        wheat-= bushels;
        
        
    }     

    static int setOffering(int offering) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static int MAX_PEOPLE = 7;
    private static int MIN_PEOPLE = 1;
    
    public int newPeople() {
        Random numToCity = new Random();
        int peopleToCity = numToCity.nextInt(MAX_PEOPLE / 100);
        return peopleToCity;
    }

    public int newYear() {
    int year = 1;
    while(year <= 10) {
        year++;
    }
    return year;
    }
    
    


}    



   
    