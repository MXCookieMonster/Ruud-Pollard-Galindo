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
import thecityofaaron.model.Location;

/**
 *
 * @author rogerpollard
 */
public class GameMenuView extends MenuView 
{
    
    Scanner keyboard = new Scanner(System.in);
    
    private String menu;
    private int max;
    private static Game theGame = MainClass.getTheGame();
    
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
        
        System.out.println("\n***  MAP  ***");
        System.out.println("   1     2     3     4     5");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (theGame.getTheMap().getLocation(i, j) == null) {
                    System.out.print("[ ]");
                } else {
                    System.out.print(theGame.getTheMap().getLocation(i, j).getSymbol());
                }
            }
            System.out.print("\n");
        }
           System.out.println("\nKey:"
                    + "\nMountains = ^^^"
                    + "\nVillage = oOo"
                    + "\nRiver = ~~~"
                    + "\nWheat Fields = !!!");
        
        //System.out.print(theGame.getTheMap().getLocation(i, j).getSymbol())
    }
    
    public void viewList() {
        ListMenuView lmv = new ListMenuView();
        lmv.displayMenu();
    }
    
    public void moveToNewLocation() {
        int xCoord;
        int yCoord;
        do {
            System.out.print("\nEnter the x coordinate (0-4): ");
            xCoord = keyboard.nextInt();
            if (xCoord > 4 || xCoord < 0) {
                System.out.print("\nThat number is not between 0 and 4.");
            }
        } while(xCoord > 4 || xCoord < 0);
        do {
            System.out.print("\nEnter the y coordinate: ");
            yCoord = keyboard.nextInt();
            if (yCoord > 4 || yCoord < 0) {
                System.out.print("\nThat number is not between 0 and 4.");
            }
        } while (yCoord > 4 || yCoord < 0);
        Location location = theGame.getTheMap().getLocation(xCoord, yCoord);
        String locationDescription = theGame.getTheMap().getLocation(xCoord, yCoord).getDescription();
        theGame.getTheMap().setLocation(xCoord, yCoord, location);
        System.out.println(locationDescription);
        
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
