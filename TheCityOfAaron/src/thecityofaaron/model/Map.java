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
    
    public Map(int _rows, int _cols) {
        rowCount = _rows;
        colCount = _cols;
        
        locations = new Location[_rows][_cols];
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColCount() {
        return colCount;
    }
    
    public Location getLocation(int row, int col) {
        return locations[row][col];
    }
    
    public void setLocation(int row, int col, Location _location) {
        locations[row][col] = _location;
    }
}