/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thecityofaaron.model;

import thecityofaaron.model.Player;
import java.io.Serializable;
import java.util.ArrayList;



/**
 *
 * @author Tyden R
 */
public class Game implements Serializable {

    
    
    //Variables 
    private double totalTime;
    private int noPeople;
    private Player player;
    private CropData theCrops = null;
    private Map theMap;
    private ArrayList<ListItem> animals;
    private ArrayList<ListItem> tools;
    private ArrayList<ListItem> provisions;
    private boolean done = false;
    





    //Constructor variable
    public Game() {
    }
     
    //Player class methods
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
   //Getters and Setters

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public int getNoPeople() {
        return noPeople;
    }

    public void setNoPeople(int noPeople) {
        this.noPeople = noPeople;
    }
    // the getCrops() method
    // Purpose: get a reference to the crop object
    // Parameters: none
    // Returns: a reference to a crop object
    public CropData getCropData()
    {
        return theCrops;
    }
    
    // the setCrops() method
    // Purpose: store a reference to a crop object
    // Parameters: a reference to a crop object
    // Returns: none    
    public void setCropData(CropData _cropRef)
    {
        theCrops = _cropRef;
    }

    public CropData getTheCrops() {
        return theCrops;
    }

    public void setTheCrops(CropData theCrops) {
        this.theCrops = theCrops;
    }

    public Map getTheMap() {
        return theMap;
    }

    public void setTheMap(Map theMap) {
        this.theMap = theMap;
    }

    public ArrayList<ListItem> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<ListItem> animals) {
        this.animals = animals;
    }

    public ArrayList<ListItem> getTools() {
        return tools;
    }

    public void setTools(ArrayList<ListItem> tools) {
        this.tools = tools;
    }

    public ArrayList<ListItem> getProvisions() {
        return provisions;
    }

    public void setProvisions(ArrayList<ListItem> provisions) {
        this.provisions = provisions;
    }
    
    
    //Hashcode

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.totalTime) ^ (Double.doubleToLongBits(this.totalTime) >>> 32));
        hash = 97 * hash + this.noPeople;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (Double.doubleToLongBits(this.totalTime) != Double.doubleToLongBits(other.totalTime)) {
            return false;
        }
        if (this.noPeople != other.noPeople) {
            return false;
        }
        return true;
    }
    
    
}
