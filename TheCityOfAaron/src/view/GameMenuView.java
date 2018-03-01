/*
 * The MainMenuView class - part of the view layer
 * Object of this class manage the main menu
 * Author: Pollard, Roger
 * Date last modified: February 2018
 */
package view;
import java.util.Scanner;
import thecityofaaron.MainClass;
import thecityofaaron.model.Player;
import thecityofaaron.model.Game;

/**
 *
 * @author rogerpollard
 */
public class GameMenuView {
    
    Scanner keyboard = new Scanner(System.in);
    
    private String gameMenu;
    private int max;
    
    public void gameMenuView() {
        gameMenu = "\n 1 - View the map\n" +
                " 2 - View/Print a list\n" +
                " 3 - Move to a new location\n" +
                " 4 - Manage the crops\n" +
                " 5 - Return to the main menu\n";
        
        max = 5;
    }
    
    public void displayGameMenuView() {
        int menuOption;
        do {
        // Display the menu
        System.out.println(gameMenu);
        
        // Prompt the user and get user's input
        menuOption = getMenuOption();
        
        // Perform the desired action
        doAction(menuOption);
        
        // Determine and display the next view
        } while (menuOption != max);
    }
    
    public int getMenuOption() {
        // declare a variable to hold user's input
        int userInput;
        
        // begin loop
        do {
            // get user input from the keyboard
            userInput = keyboard.nextInt();
            
            // if it is not a valid value, output an error message
            if (userInput < 1 || userInput > max) {
                System.out.println("\noption must be between 1 and " + max);
            }
            // loop back to the top if input was not valid
        } while (userInput < 1 || userInput > max);
        
        //return the value input by the user
        return userInput;
    }
    
    public void doAction(int option) {
        switch(option) {
            case 1:
                viewMap();
                break;
            case 2:
                viewList();
                break;
            case 3:
                moveToNewLocation();
                break;
            case 4:
                manageCrops();
                break;
            case 5:
                displayMenuView();
                break;
        }
    }
    
    public void viewMap() {
        System.out.println("\nView map option selected.");
    }
    
    public void viewList() {
        System.out.println("\nView list option selected.");
    }
    
    public void moveToNewLocation() {
        System.out.println("\nMove to new location option selected.");
    }
    
    public void manageCrops() {
        System.out.println("\nManage crops option selected.");
    }
    
}
