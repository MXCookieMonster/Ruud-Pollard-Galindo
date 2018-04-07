/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thecityofaaron.model;

import java.awt.Point;

/**
 *
 * @author Tyden R
 */
public enum TeamMember {
    
    Tyden("Tyden", "is a Team Member.", new Point(1, 1)),
    Roger("Roger", "is a Team Member.", new Point(0, 1)),
    Josafat("Josafat", "is a Team member.", new Point(1, 2));
    
    //enum variables 
    private String name;
    private String title;
    private Point coordinates;

    //constructor class
    TeamMember(String name, String title, Point coordinates) {
        this.name = name;
        this.title = title;
        this.coordinates = coordinates;
    }
    
    //Getters
    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return "Team Member{" + "name=" + name + ", description=" + title + ", coordinates=" + coordinates + '}';
    }
    
    
    
}
