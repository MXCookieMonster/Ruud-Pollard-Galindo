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
public class GameMenuView extends MenuView 
{
    
    Scanner keyboard = new Scanner(System.in);
    
    private String menu;
    private int max;
    
    public GameMenuView() {
        super ("\n " +
                "*******************************\n" +
                "CITY OF AARON: GAME MENU *\n" +
                "*******************************\n" +
                " 1 - View the map\n" +
                " 2 - View/Print a list\n" +
                " 3 - Move to a new location\n" +
                " 4 - Manage the crops\n" +
                " 5 - Return to the main menu\n",
                5);
    }
    
    @Override public void doAction(int option) {
        switch(option) {
            case 1:
                viewMap();
                break;
            case 2:
                displayListMenuView();
                break;
            case 3:
                moveToNewLocation();
                break;
            case 4:
                manageCrops();
                break;
            case 5:
                displayMainMenuView();
                break;
        }
    }
    
    public void viewMap() {
        System.out.println("\nView map option selected.");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("[" + i + "]");
            }
            System.out.print("\n");
        }
    }
    
    public void viewList() {
        ListMenuView lmv = new ListMenuView();
        lmv.displayMenu();
    }
    
    public void moveToNewLocation() {
        System.out.println("\nMove to new location option selected.");
    }
    
    public void manageCrops() {
       // System.out.println("\nManage crops option selected.");
       
       CropView.runCropViews();
    }

    private void displayMainMenuView() {
        MainMenuView mmv = new MainMenuView();
        mmv.displayMenu();
    }

    private void displayListMenuView() {
      ListMenuView lmv = new ListMenuView();
      lmv.displayMenu();
    }
    
}
