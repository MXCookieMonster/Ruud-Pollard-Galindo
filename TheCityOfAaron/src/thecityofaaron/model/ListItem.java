/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thecityofaaron.model;

import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import thecityofaaron.MainClass;
import thecityofaaron.model.*;
import thecityofaaron.control.*;
/**
 *
 * @author Tyden R
 */
public class ListItem implements Serializable {
    
    //List Item variables
    private String name;
    private int quantity;
    private static Game theGame = MainClass.getTheGame();
 private ArrayList<ListItem> animals;
 private ArrayList<ListItem> tools = theGame.getTools();
 private ArrayList<ListItem> provision;
   
    //constructor method
    public ListItem(String _name, int _quantity) {
        name = _name;
        quantity = _quantity;
        
    }
    
    //Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public static void printAnimalList(ArrayList<ListItem> animals, String outputfileLocation){
    try (PrintWriter out = new PrintWriter("C:\\Users\\Josaf\\Documents\\Animal_Report.txt")){    
    
    out.println("\n\n      Animal List    ");
    out.printf("%n%-20s%10s","Descprition","Quantity");
    out.printf("%n%-20s%10s", "-----------","--------");
    
    for (ListItem animal : theGame.getAnimals()) {     
    
       out.printf("%n%-20s%10d", animal.getName()
                                , animal.getQuantity());
    }
    } catch (Exception e){
        System.out.println("Error the list cannot print");
    }          
    }
    
    public static void printToolsList(ArrayList<ListItem> tools, String outputFileLocation) {
        try (PrintWriter out = new PrintWriter("Tools_Report.txt")) {
            out.println("\n\n Tools List");
            out.printf("%n%-20s%10s","Descprition","Quantity");
            out.printf("%n%-20s%10s", "-----------","--------");
            
            for (ListItem tool : theGame.getTools()) {
                out.printf("%n%-20s%10d", tool.getName(), tool.getQuantity());
                
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
    //toString statement 

    @Override
    public String toString() {
        return "ListItem{" + "name=" + name + ", quantity=" + quantity + '}';
    }
    
    
    
    
}
    