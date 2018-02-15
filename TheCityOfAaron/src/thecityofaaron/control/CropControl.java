/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thecityofaaron.control;

import thecityofaaron.model.CropData;

/**
 *
 * @author Tyden R
 */
public class CropControl {
    
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
    
}    

