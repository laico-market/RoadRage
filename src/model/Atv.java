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
 * The Atv class have Atv's information about pass and direction
 * 
 * @author Jaehong Lee Student
 * @version Fall 2020 
 */



public class Atv extends AbstractVehicle{
    
    //Instance fields
    private static final int DEATH_TIME = 25;
    

    //constructors
    
    /**
     * Constructs a Atv object with given x, y coordinates, direction and death time. 
     * 
     * @param theX   The X coordinate of a Atv.
     * @param theY   The Y coordinate of a Atv.
     * @param theDir The direction of a Atv.
     */
    public Atv(int theX, int theY, Direction theDir) {
        super(theX, theY, theDir, DEATH_TIME);
        // TODO Auto-generated constructor stub
      
    }
    
    
    /**
     * Check whether a Atv can pass the terrain.
     * 
     * @param theTerrain Atv will try to pass the terrain.
     * @param theLight   Atv will try to pass the color of the light.
     * @return If Atv can pass, return true. If Atv can pass, return false
     */

    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        
        boolean pass = false;
        if(theTerrain != Terrain.WALL) {    
            pass = true;
        }
        return pass;
        
    }
    
    
    /**
     *  This method returns the Direction of Atv based on the given the neighbor terrain.
     * 
     * @param theNeighbors The map of neighbor terrain.
     * @return the direction the Atv will go.
     */
    
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        
        final Random random = new Random();
        final List<Direction> directionList = new ArrayList<>();
        Direction direction;
        
        if (theNeighbors.get(getDirection()) != Terrain.WALL) {
            directionList.add(getDirection());
        }
        if (theNeighbors.get(getDirection().left()) != Terrain.WALL) {
            directionList.add(getDirection().left());
        }
        
        if (theNeighbors.get(getDirection().right()) != Terrain.WALL) {
            directionList.add(getDirection().right());
        }
            
        direction = directionList.get(random.nextInt(directionList.size()));
        
        return direction;
      
    }

}
