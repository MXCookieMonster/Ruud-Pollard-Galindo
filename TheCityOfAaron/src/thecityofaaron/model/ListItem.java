/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thecityofaaron.model;

import java.io.Serializable;
/**
 *
 * @author Tyden R
 */
public class ListItem implements Serializable {
    
    //List Item variables
    private String name;
    private int quantity;
    
   
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
    
    //toString statement 

    @Override
    public String toString() {
        return "ListItem{" + "name=" + name + ", quantity=" + quantity + '}';
    }
    
    
    
    
}
    