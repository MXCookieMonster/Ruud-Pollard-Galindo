/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.util.Scanner;
/**
 *
 * @author Joe G
 */
public class ListMenuView extends MenuView {
 Scanner keyboard = new Scanner(System.in);
    
 private String menu;
 private int max;   

public ListMenuView() {
       super("\n" +
                "************************\n" +
                "CITY OF AARON: LIST MENU\n" +
                "************************\n" +
                " 1 - List/View the animals in the storehouse\n" +
                " 2 - List/View the tools in the storehouse\n" +
                " 3 - List/View the provisions in the storehouse\n" +
                " 4 - List/View the authors of the game\n" +
                " 5 - Return to the main menu\n",
              5);
    }

 
@Override public void doAction(int option) {
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
                System.out.println(menu);
                break;
        }
    }
}