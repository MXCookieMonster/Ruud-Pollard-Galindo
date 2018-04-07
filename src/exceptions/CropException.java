/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Tyden R
 */
public class CropException extends Exception {
    
    //Default Constructor
    //Purpose:Initializes data members to default values
    //Parameters: none
    //Returns: none
    public CropException() {}
    
    //Parameterized Constructors
    //Purpose: Initializes data members to value passed as a parameter
    //Parameters: A string containing the error message
    //Returns: none
    public CropException(String string) {
        super(string);
    }
}
