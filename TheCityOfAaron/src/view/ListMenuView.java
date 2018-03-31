/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import thecityofaaron.MainClass;
import thecityofaaron.control.GameControl;
import thecityofaaron.model.Player;
import thecityofaaron.model.Game;
import thecityofaaron.model.ListItem;

/**
 *
 * @author Joe G
 */
public class ListMenuView extends MenuView {
 Scanner keyboard = new Scanner(System.in);
    
 private String menu;
 private int max;
 
 private static Game theGame = MainClass.getTheGame();
 private ArrayList<ListItem> animals;
 private ArrayList<ListItem> tools = theGame.getTools();
 private ArrayList<ListItem> provision;

public ListMenuView() {
       super("\n" +
                "************************\n" +
                "CITY OF AARON: LIST MENU\n" +
                "************************\n" +
                " 1 - List/View the animals in the storehouse\n" +
                " 2 - List/View the tools in the storehouse\n" +
                " 3 - List/View the provisions in the storehouse\n" +
                " 4 - List/View the authors of the game\n" +
                " 5 - Print the animals in the storehouse\n" +
                " 6 - Print the tools list\n" +
                " 7 - Print the provisions list\n" +
                " 8 - Return to the main menu\n",
              8);
               
    }

 
@Override public void doAction(int option) {
        switch(option) {
            case 1: // if the option is 1, call displayAnimalList()
                displayAnimalList();
                break;
            case 2: // if the option is 2, call displayToolList()
                displayToolsList();
                break;
            case 3: // if the option is 3, call list of provision()
                displayProvisionList();
                break;
            case 4:// if the option is 4, call displaySavegame()
                System.out.println("The authors of the game are ... \n");
                break;
            case 5://Print the animal list
                printAnimalReport();
                break;
            case 6:
                printToolList();
                break;
            case 7:
                printProvisionList();
                break;
            case 8://Back to main menu
                displayMainMenuView();
                break;
                
        }
    }

    private void displayMainMenuView() {
        MainMenuView mmv = new MainMenuView();
        mmv.displayMenu();
    }
    
    private void displayAnimalList() {
        for (ListItem animal : theGame.getAnimals()) {
            System.out.println(animal.getName() + ": " + animal.getQuantity());
        }
    }

    private void displayToolsList() {
        for (ListItem tools : theGame.getTools()){
            System.out.println(tools.getName() + ": " + tools.getQuantity());
    }
    }
    
    private void displayProvisionList() {
        for (ListItem provisions : theGame.getProvisions()) {
            System.out.println(provisions.getName() + ": " + provisions.getQuantity());
        }
    }

    private void printAnimalReport(){
   
        ListItem.printAnimalList(animals, menu);
    }       

    
    
    private void printToolList() {
        String filePath;
        System.out.println("\n\nEnter the file path where you want to print the list to:");
        keyboard.nextLine();
        filePath = keyboard.nextLine();
        GameControl.ToolsReport(tools, filePath);
    }
    
    private void printProvisionList() {
        String filePath;
        System.out.println("\n\nEnter the file path where you want to print the list to:");
        keyboard.nextLine();
        filePath = keyboard.nextLine();
        GameControl.ProvisionsReport(tools, filePath);
    }

}
