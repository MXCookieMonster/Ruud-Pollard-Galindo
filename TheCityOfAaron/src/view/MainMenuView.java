/*
 * The MainMenuView class - part of the view layer
 * Object of this class manage the main menu
 * Author: Pollard, Roger
 * Date last modified: February 2018
 */
package view;
import java.util.Scanner;
import thecityofaaron.MainClass;
import thecityofaaron.model.CropData;
import thecityofaaron.model.Player;
import thecityofaaron.model.Game;
import view.HelpMenu;
import view.GameMenuView;


/**
 *
 * @author rogerpollard
 */
public class MainMenuView {
    
    Scanner keyboard = new Scanner(System.in);
    
    private String mainMenu;
    private int max;
    
    public MainMenuView() {
        mainMenu = "\n" +
                "*******************************\n" +
                "CITY OF AARON: MAIN GAME MENU *\n" +
                "*******************************\n" +
                " 1 - Start new game\n" +
                " 2 - Get and start a saved game\n" +
                " 3 - Get help on playing the game\n" +
                " 4 - Save game\n" +
                " 5 - Quit\n";
        
        max = 5;
    }
    
    public void displayMenuView() {
        int menuOption;
        do {
        // Display the menu
        System.out.println(mainMenu);
        
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
            case 1: // if the option is 1, call startNewGame()
                startNewGame();
                break;
            case 2: // if the option is 2, call startExistingGame()
                startSavedGame();
                break;
            case 3: // if the option is 3, call displayHelpMenu()
                displayHelpMenuView();
                break;
            case 4:// if the option is 4, call displaySavegame()
                displaySaveGameView();
                break;
            case 5:// if the option is 5, call display a goodbye message
                System.out.println("Thanks for playing ... goodbye.");
                break;
        }
    }
    
    public void startNewGame() {
        // Create a new Game object.
        Game theGame = new Game();
        
        // Create the CropData object, 
        // initialize it and save a reference to it in the Game
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
        
        
// Save a reference to it in the GameProject class.
        thecityofaaron.MainClass.setTheGame(theGame);
        
        // Display the Banner Page
        System.out.println("\nWelcome to the city of Aaron.\n" + 
                            "You have been summoned here by the High Priest\n" + 
                            "to assume your role as ruler of the city.\n" + 
                            "Your responsibility is to buy and sell land,\n" + 
                            "determine how much wheat to plant each year\n" + 
                            "and how much to set aside to feed your people.\n" + 
                            "In addition, it will be your job to pay an annual\n" + 
                            "tithe on the wheat that is harvested. If you\n" + 
                            "fail to provide enough wheat for the people,\n" + 
                            "people will starve, some people will die,\n" + 
                            "and your workforce will be diminished.\n" + 
                            "Plan carefully. And Oh, there is always\n" + 
                            "a danger of rats eating your wheat.");
        
        // Create a new Player object
        Player thePlayer = new Player();
        
        // Prompt for and get the user's name.
        String name;
        System.out.println("\nPlease type in your first name: ");
        name = keyboard.next();
        
        // Save the user's name in the Player object.
        thePlayer.setName(name);

        // Save a reference to the player object in the Game object.
        theGame.setPlayer(thePlayer);

        // Display a welcome message.
        System.out.println("\nWelcome, " + name + ". Have fun.");

        // Display the Game menu.
        displayGameMenuView();
    }
    
    public void startSavedGame() {
        System.out.println("\nStart save game option selected.");
    }
    
    public void displayHelpMenuView() {
        HelpMenu hmv = new HelpMenu();
        hmv.displayMenuView();
    }
    
    public void displayGameMenuView() {
        GameMenuView gmv = new GameMenuView();
        gmv.displayGameMenuView();
    }
    
    public void displaySaveGameView() {
        System.out.println("\nSave game option selected.");
    }
   
    
    
}
