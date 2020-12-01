/*
 * TCSS 305 – Fall 2020
 * Assignment 2 – Roadage 
 */
package model;

import java.util.Map;

/**
 * The Taxi class have Taxi information about pass and direction
 * 
 * @author Jaehong Lee Student
 * @version Fall 2020 
 */

public class Taxi extends AbstractVehicle{
    
    //Instance fields
    private static final int DEATH_TIME = 15;
    
    private int myClock;
    
    /**
     * Constructs a Taxi object with given x, y coordinates, direction and death time. 
     * 
     * @param theX   The X coordinate of a Taxi.
     * @param theY   The Y coordinate of a Taxi.
     * @param theDir The direction of a Taxi.
     */

    public Taxi(int theX, int theY, Direction theDir) {
        super(theX, theY, theDir, DEATH_TIME);
        // TODO Auto-generated constructor stub
        myClock = 0;
    }
    

    /**
     * Check whether a Taxi can pass the terrain.
     * 
     * @param theTerrain Taxi will try to pass the terrain.
     * @param theLight   Taxi will try to pass the color of the light.
     * @return If Taxi can pass, return true. If Taxi can pass, return false
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
            myClock = 0;
        } else if(theTerrain == Terrain.CROSSWALK && theLight == Light.YELLOW) {
            pass = true;
            myClock = 0;
        } else if(theTerrain == Terrain.CROSSWALK && theLight == Light.RED && myClock >= 3){
            pass = true;
            myClock = 0;
        } else if(theTerrain == Terrain.CROSSWALK && theLight == Light.RED && myClock < 3) {
            myClock++;
        }

        return pass;

    }
    
    
    /**
     *  This method returns the Direction of Taxi based on the given the neighbor terrain.
     * 
     * @param theNeighbors The map of neighbor terrain.
     * @return the direction the Taxi will go.
     */
    
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        Direction direction;
        
        if (theNeighbors.get(getDirection()) == Terrain.STREET 
                || theNeighbors.get(getDirection()) == Terrain.LIGHT
                || theNeighbors.get(getDirection()) == Terrain.CROSSWALK) {
            
            direction = getDirection();

        } else if (theNeighbors.get(getDirection().left()) == Terrain.STREET 
                || theNeighbors.get(getDirection().left()) == Terrain.LIGHT
                || theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK) {
                    
            direction = getDirection().left();

        } else if (theNeighbors.get(getDirection().right()) == Terrain.STREET 
                || theNeighbors.get(getDirection().right()) == Terrain.LIGHT
                || theNeighbors.get(getDirection().right()) == Terrain.CROSSWALK) {
            
            direction = getDirection().right();

        } else {
            direction = getDirection().reverse();
        }

        return direction;
      
    }
    
}
