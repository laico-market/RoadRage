/*
 * TCSS 305 – Fall 2020
 * Assignment 2 – Roadage 
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * The Truck class have Truck information about pass and direction
 * 
 * @author Jaehong Lee Student
 * @version Fall 2020 
 */


public class Truck extends AbstractVehicle {
    
    
    //Instance fields
    private static final int DEATH_TIME = 0;
    

    /**
     * Constructs a Truck object with given x, y coordinates, direction and death time. 
     * 
     * @param theX   The X coordinate of a Truck.
     * @param theY   The Y coordinate of a Truck.
     * @param theDir The direction of a Truck.
     */
    public Truck(int theX, int theY, Direction theDir) {
        super(theX, theY, theDir, DEATH_TIME);
        // TODO Auto-generated constructor stub
    }
    
    /**
     * Check whether a Truck can pass the terrain.
     * 
     * @param theTerrain Truck will try to pass the terrain.
     * @param theLight   Truck will try to pass the color of the light.
     * @return If Truck can pass, return true. If Truck can pass, return false
     */

    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        
        boolean pass = false;
           
        if(theTerrain == Terrain.STREET || theTerrain == Terrain.LIGHT) {      
            pass = true;
        } else if(theTerrain == Terrain.CROSSWALK && theLight == Light.YELLOW) {
            pass = true;
        } else if(theTerrain == Terrain.CROSSWALK && theLight == Light.GREEN) {  
            pass = true;
        }
        
        return pass;
    }

    
    /**
     *  This method returns the Direction of Truck based on the given the neighbor terrain.
     * 
     * @param theNeighbors The map of neighbor terrain.
     * @return the direction the Truck will go.
     */
    
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        
        final Random random = new Random();
        final List<Direction> directionList = new ArrayList<>();
        Direction direction;
        
        if (theNeighbors.get(getDirection()) == Terrain.STREET 
                || theNeighbors.get(getDirection()) == Terrain.LIGHT
                || theNeighbors.get(getDirection()) == Terrain.CROSSWALK) {
          
            directionList.add(getDirection());
        }
        
        if (theNeighbors.get(getDirection().left()) == Terrain.STREET 
                || theNeighbors.get(getDirection().left()) == Terrain.LIGHT
                || theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK) {
          
            directionList.add(getDirection().left());
        }
        
        if (theNeighbors.get(getDirection().right()) == Terrain.STREET 
                || theNeighbors.get(getDirection().right()) == Terrain.LIGHT
                || theNeighbors.get(getDirection().right()) == Terrain.CROSSWALK) {
          
            directionList.add(getDirection().right());
        }
        
        if(!directionList.isEmpty()) {  
            direction = directionList.get(random.nextInt(directionList.size()));
        }else {
            direction = getDirection().reverse();
        }
        
        return direction;
    }
    
}