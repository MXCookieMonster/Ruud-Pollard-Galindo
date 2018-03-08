/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;
/**
 * MainView class - Super Class for view layer
 * @author Tyden R
 */
public abstract class MenuView implements ViewInterface {
    //the data members common to all menu views
    protected final static Scanner keyboard = new Scanner(System.in);
    protected String menu; //This holds the menu String
    protected int max; // this int holds the max input value
    
    //MenuView Constructor 
    //Purpose: Initialize the view object with the menu string
    //Parameters: the menu string and the max value
    //returns none
    public MenuView(String menu, int max){
        menu = _menu;
        max = _max;
    }
    
    //The displayMenu method
    //Purpose: display the menu, gets the user's input and does action
    //Parameters: none
    //returns: none
    @Override public void displayMenu() {
        //execute this loop as long as the selected option is not max
        int menuOption = 0;
        do {
            //display menu
            System.out.println(menu);
            
            //get user's selection
            menuOption = getMenuOption();
            
            //perform the selected action
            doAction(menuOption);
        }
        while (menuOption != max);
        }
    
    //The getUserInput method
    //Puropse: gets user input, makes sure it is within range
    //Parameters: none
    //Returns: the user input, between 1 and maxValue
    @Override public int getMenuOption() {
        int inputValue = 0;
        do {
        System.out.format("\nPlease enter an option(1 - %d):", max);
        inputValue = keyboard.nextInt();
        if(inputValue < 1 || inputValue > max);
        {
        System.out.format("\nError: input must be between 1 and %d", max);
        }
        } while(inputValue < 1 || inputValue > max);
        return inputValue;
        }
}


