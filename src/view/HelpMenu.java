/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;
import view.MainMenuView;
/**
 *
 * @author Tyden R
 */
public class HelpMenu extends MenuView {
    
    Scanner keyboard = new Scanner(System.in);
    
    private String helpMenu;
    private int max;
    
    public HelpMenu() {
           super ("\n" +
                   "************************\n" +
                   "CITY OF AARON: HELP MENU\n" +
                   "************************\n" +
                   " 1 - Goals of the Game \n"  +
                   " 2 - Where the City of Aaron is located \n" +
                   " 3 - How to view the Map \n" +
                   " 4 - How to move locations \n" +
                   " 5 - How to display list of animals, tools, and provisions in Storehouse \n" +
                   " 6 - Back to Main Menu",
                   6);
    }
    
    public void doAction(int option) {
        switch(option) {
            case 1: // if the option is 1, call startNewGame()
                System.out.println("The goals of the game are ...");
                break;
            case 2: // if the option is 2, call startExistingGame()
                System.out.println("The city of Aaron is located in ... \n");
                break;
            case 3: // if the option is 3, call displayHelpMenu()
                System.out.println("You view the map by ... \n");
                break;
            case 4:// if the option is 4, call displaySavegame()
                System.out.println("You move locations by ... \n");
                break;
            case 5:// if the option is 5, call display a goodbye message
                System.out.println("List of animals: \n"
                                    + "List of tools: \n"
                                    + "Provisions: \n");
                break;
            case 6://Back to main menu
                System.out.println("Go Back to menu");
                break;
        }
    }
    
}
