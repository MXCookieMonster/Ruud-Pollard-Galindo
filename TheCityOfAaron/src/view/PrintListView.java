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
 * @author Joe G
 */
public class PrintListView {
 Scanner keyboard = new Scanner(System.in);
    
    private String listView;
    private int max;   

public PrintListView() {
        listView = "\n 1 - List/View the animals in the storehouse\n" +
                " 2 - List/View the tools in the storehouse\n" +
                " 3 - List/View the provisions in the storehouse\n" +
                " 4 - List/View the authors of the game\n" +
                " 5 - Return to the main menu\n";
        
        max = 5;
    }

 public void displayPrintListView() {
        
        int menuOption;
        do {
        // Display the menu
        System.out.println(listView);
        
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
                System.out.println("The animals in the Storehouse are..");
                break;
            case 2: // if the option is 2, call startExistingGame()
                System.out.println("The tools in the storehouse are ... \n");
                break;
            case 3: // if the option is 3, call displayHelpMenu()
                System.out.println("The provisions in the storehouse are ... \n");
                break;
            case 4:// if the option is 4, call displaySavegame()
                System.out.println("The authors of the game are ... \n");
                break;
            case 6://Back to main menu
                System.out.println("Go Back to menu");
                break;
        }
    }
}