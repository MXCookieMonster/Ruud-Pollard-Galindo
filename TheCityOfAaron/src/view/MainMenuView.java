/*
 * The MainMenuView class - part of the view layer
 * Object of this class manage the main menu
 * Author: Pollard, Roger
 * Date last modified: February 2018
 */
package view;
import java.util.Scanner;
import thecityofaaron.MainClass;
import thecityofaaron.control.GameControl;
import thecityofaaron.model.CropData;
import thecityofaaron.model.Player;
import thecityofaaron.model.Game;
import view.HelpMenu;


/**
 *
 * @author rogerpollard
 */
public class MainMenuView extends MenuView {
    
    Scanner keyboard = new Scanner(System.in);
    
    private String menu;
    private int max;
    
    public MainMenuView() {
             super("\n" +
                "*******************************\n" +
                "CITY OF AARON: MAIN GAME MENU *\n" +
                "*******************************\n" +
                " 1 - Start new game\n" +
                " 2 - Get and start a saved game\n" +
                " 3 - Get help on playing the game\n" +
                " 4 - Save game\n" +
                " 5 - Quit\n",
                5);
    }
    
    @Override public void doAction(int option) {
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
                exitGame();
                break;
        }
    }
    
    public void startNewGame() {
        // Create a new Game object.
        Game theGame = new Game();
        
        // Create the CropData object, 
        // initialize it and save a reference to it in the Game
        
        
        
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
        //Player thePlayer = new Player();
        
        // Prompt for and get the user's name.
        String name;
        System.out.println("\nPlease type in your first name: ");
        name = keyboard.next();
        
        
        // Save the user's name in the Player object.
        //thePlayer.setName(name);

        // Save a reference to the player object in the Game object.
        //theGame.setPlayer(thePlayer);

        // Display a welcome message.
        System.out.println("\nWelcome, " + name + ". Have fun.");

        thecityofaaron.control.GameControl.createNewGame(name);
        
        // Display the Game menu.
        GameMenuView gmv = new GameMenuView();
        gmv.displayMenu();
        
    
    }
    
    public void startSavedGame() {
        System.out.println("\nStart save game option selected.");
    }
    
    public void displayHelpMenuView() {
      HelpMenu hm = new HelpMenu();
      hm.displayMenu();
    }
    
    public void displaySaveGameView() {
        System.out.println("\nSave game option selected.");
    }

    private void displayGameMenuView() {
        GameMenuView gmv = new GameMenuView();
        gmv.displayMenu();
    }

    private void exitGame() {
        System.out.println("Thanks for playing ... goodbye.");
    }
   
    
    
}
