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


public class Player implements Serializable { 
    
    //class instance variables
    private String name;
    

    //Constructor method
    public Player() {
    }
    
    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
     @Override
    public String toString() {
        return "Player {" + "name=" + name + '}';
    }
        
  
    }

   