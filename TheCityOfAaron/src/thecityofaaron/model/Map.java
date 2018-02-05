/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thecityofaaron.model;

import java.io.Serializable;

/**
 *
 * @author rogerpollard
 */
public class Map implements Serializable {
    
    private int rowCount;
    private int colCount;
    private Location[][] locations;
    
    public Map() {
        
    }
    
}