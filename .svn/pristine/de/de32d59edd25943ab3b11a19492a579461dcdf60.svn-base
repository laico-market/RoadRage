/*
 * TCSS 305 – Fall 2020
 * Assignment 2 – Roadage 
 */
package model;

import java.util.Map;

/**
 * The Car class have Car information about pass and direction
 * 
 * @author Jaehong Lee Student
 * @version Fall 2020 
 */


public class Car extends AbstractVehicle{
    
    //Instance fields
    private static final int DEATH_TIME = 15;

    /**
     * Constructs a Car object with given x, y coordinates, direction and death time. 
     * 
     * @param theX   The X coordinate of a Car.
     * @param theY   The Y coordinate of a Car.
     * @param theDir The direction of a Car.
     */
    public Car(int theX, int theY, Direction theDir) {
        super(theX, theY, theDir, DEATH_TIME);
        // TODO Auto-generated constructor stub
    }


    
    /**
     * Check whether a Car can pass the terrain.
     * 
     * @param theTerrain Car will try to pass the terrain.
     * @param theLight   Car will try to pass the color of the light.
     * @return If Car can pass, return true. If Car can pass, return false
     */

    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        
        boolean pass = false;
        
        if(theTerrain == Terrain.STREET) {    
            pass = true;   
        } else if(theTerrain == Terrain.LIGHT && theLight == Light.GREEN) {       
            pass = true;
        } else if(theTerrain == Terrain.LIGHT && theLight == Light.YELLOW) {
            pass = true;
        } else if(theTerrain == Terrain.CROSSWALK && theLight == Light.GREEN) {
            pass = true;
        }
        
        return pass;
    }
    
    /**
     *  This method returns the Direction of Car based on the given the neighbor terrain.
     * 
     * @param theNeighbors The map of neighbor terrain.
     * @return the direction the Car will go.
     */
  
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        
        Direction direction;
        
        if (theNeighbors.get(getDirection()) == Terrain.STREET) {
            
            direction = getDirection();
            
        } else if(theNeighbors.get(getDirection()) == Terrain.LIGHT
                || theNeighbors.get(getDirection()) == Terrain.CROSSWALK) {
       
            direction = getDirection();

        } else if (theNeighbors.get(getDirection().left()) == Terrain.LIGHT
                || theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK
                || theNeighbors.get(getDirection().left()) == Terrain.STREET) {
               
            direction = getDirection().left();

        } else if (theNeighbors.get(getDirection().right()) == Terrain.LIGHT
                || theNeighbors.get(getDirection().right()) == Terrain.CROSSWALK
                || theNeighbors.get(getDirection().right()) == Terrain.STREET) {
       
            direction = getDirection().right();

        } else {
            direction = getDirection().reverse();
        }

        return direction;
        
      
    }
    
}
