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
 * The Human class have Human information about pass and direction
 * 
 * @author Jaehong Lee Student
 * @version Fall 2020 
 */

public class Human extends AbstractVehicle {
    
    
    //Instance fields
    private static final int DEATH_TIME = 45;

    
    /**
     * Constructs a Human object with given x, y coordinates, direction and death time. 
     * 
     * @param theX   The X coordinate of a Human.
     * @param theY   The Y coordinate of a Human.
     * @param theDir The direction of a Human.
     */
    public Human(int theX, int theY, Direction theDir) {
        super(theX, theY, theDir, DEATH_TIME);
        // TODO Auto-generated constructor stub
    }

    
    /**
     * Check whether a Human can pass the terrain.
     * 
     * @param theTerrain Human will try to pass the terrain.
     * @param theLight   Human will try to pass the color of the light.
     * @return If Human can pass, return true. If Human can pass, return false
     */
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        
        boolean pass = false;
        if(theTerrain == Terrain.GRASS) {
            pass = true;
        } else if(theTerrain == Terrain.CROSSWALK && theLight == Light.YELLOW) {
            pass = true;
        }else if(theTerrain == Terrain.CROSSWALK && theLight == Light.RED) {
            pass = true;
        }
        
        return pass;
 
    }
    
    /**
     *  This method returns the Direction of Human based on the given the neighbor terrain.
     * 
     * @param theNeighbors The map of neighbor terrain.
     * @return the direction the Human will go.
     */
    
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        final Random random = new Random();
        final List<Direction> directionList = new ArrayList<>();
        Direction direction;
        
        if (theNeighbors.get(getDirection()) == Terrain.CROSSWALK) {   
            
            return getDirection();
            
        } else if (theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK ) {  
            
            return getDirection().left();
            
        } else if (theNeighbors.get(getDirection().right()) == Terrain.CROSSWALK ) {   
            
            return getDirection().right();
            
        }
      
        if (theNeighbors.get(getDirection()) == Terrain.GRASS) {
          
            directionList.add(getDirection());
        }
        
        if (theNeighbors.get(getDirection().left()) == Terrain.GRASS) {
          
            directionList.add(getDirection().left());
        }
        
        if (theNeighbors.get(getDirection().right()) == Terrain.GRASS) {
          
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
