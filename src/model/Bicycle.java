/*
 * TCSS 305 – Fall 2020
 * Assignment 2 – Roadage 
 */
package model;

import java.util.Map;

/**
 * The Bicycle class have Bicycle's information about pass and direction
 * 
 * @author Jaehong Lee Student
 * @version Fall 2020 
 */


public class Bicycle extends AbstractVehicle {
    
    
    //Instance field
    private static final int DEATH_TIME = 35;
    
    private Light myLight;
    

    
    //constructors
    
    /**
     * Constructs a Bicycle object with given x, y coordinates, direction and death time. 
     * 
     * @param theX   The X coordinate of a Bicycle.
     * @param theY   The Y coordinate of a Bicycle.
     * @param theDir The direction of a Bicycle.
     */
    public Bicycle(int theX, int theY, Direction theDir) {
        super(theX, theY, theDir, DEATH_TIME);

        
        // TODO Auto-generated constructor stub
        
    }

    /**
     * Check whether a Bicycle can pass the terrain.
     * 
     * @param theTerrain Bicycle will try to pass the terrain.
     * @param theLight   Bicycle will try to pass the color of the light.
     * @return If Bicycle can pass, return true. If bicycle can pass, return false
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        
        boolean pass = false;
        
        myLight = theLight;
        
        if (theTerrain == Terrain.TRAIL || theTerrain == Terrain.STREET) {
            pass = true;
        } else if (theTerrain == Terrain.LIGHT && theLight == Light.GREEN) {
            pass = true;
        } else if (theTerrain == Terrain.CROSSWALK && theLight == Light.GREEN){
            pass = true;
        }
       
        return pass;
    }
    
    
    /**
     * Check whether a Bicycle can pass the terrain.
     * 
     * @param theTerrain Bicycle will try to pass the terrain.
     * @param theLight   Bicycle will try to pass the color of the light.
     * @return If Bicycle can pass, return true. If Bicycle can pass, return false
     */
    
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        
       Direction direction;
        
        if (theNeighbors.get(getDirection()) == Terrain.TRAIL) {
            
            direction = getDirection();
        
        } else if (theNeighbors.get(getDirection().left()) == Terrain.TRAIL) {
            
            direction = getDirection().left();
        
        } else if (theNeighbors.get(getDirection().right()) == Terrain.TRAIL) {
            
            direction = getDirection().right();
        
        } else if (theNeighbors.get(getDirection()) == Terrain.STREET 
                || theNeighbors.get(getDirection()) == Terrain.LIGHT
                || theNeighbors.get(getDirection()) == Terrain.CROSSWALK) {
            
            direction = getDirection();

        
        } else if (theNeighbors.get(getDirection().left()) == Terrain.STREET
                || theNeighbors.get(getDirection().left()) == Terrain.LIGHT
                || theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK) {
            
            direction = getDirection().left();
        
        } else if (theNeighbors.get(getDirection().right()) == Terrain.STREET
                || theNeighbors.get(getDirection().right()) == Terrain.LIGHT
                || theNeighbors.get(getDirection().right()) == Terrain.CROSSWALK){
            
            direction = getDirection().right();
        
        } else {
            direction = getDirection().reverse();
        }
        
        return direction;

    }
    
}
