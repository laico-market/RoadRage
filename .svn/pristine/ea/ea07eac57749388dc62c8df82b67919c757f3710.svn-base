package model;

import java.util.Map;

public abstract class AbstractVehicle implements Vehicle {
    
    //Instance fields
    
    private int myX;
    private int myY;
    private Direction myDirection;
    
    private int myDeathTime;
    
    private boolean myAlive;
    
    private final int myInitialX;
    private final int myInitialY;
    private final Direction myInitialDirection;
    
    private int myPoke;

    
    // constructor
    /**
     *  Constructs a vehicle with the provided x,y coordinates, direction and deathTime
     *  
     * @param theX  The X coordinate of a vehicle.
     * @param theY  The Y coordinate of a vehicle.
     * @param theDir The Direction of a vehicle to travel.
     * @param theDeathTime The death time of a vehicle.
     */
    protected AbstractVehicle(final int theX, final int theY, final Direction theDir, final int theDeathTime) {
        this.myX = theX;
        this.myY = theY;
        this.myDirection = theDir;

        
        this.myDeathTime = theDeathTime;
        this.myInitialX = theX;
        this.myInitialY = theY;
        this.myInitialDirection = myDirection;
        this.myAlive = true;
        this.myPoke = 0;
    }

    /**
     * the method shows whether two vehicle collide and each vehicle is alive.
     * 
     * @param theOther other vehicle
     */

    @Override
    public void collide(Vehicle theOther) {
        // TODO Auto-generated method stub
            
        if ((isAlive() && theOther.isAlive()) && (getDeathTime() > theOther.getDeathTime())) {
            myAlive = false;
        
        } else if ((isAlive() && theOther.isAlive()) && (myDeathTime <= theOther.getDeathTime())) {
            myAlive = true;
        
        }
    }

    /**
     * this method return how long the vehicle stays dead for moves.
     * 
     * @return the vehicle dead time
     */
    
    @Override
    public int getDeathTime() {
        // TODO Auto-generated method stub
        return myDeathTime;
    }

    /**
     * this method return image name of vehicle
     * 
     * @return the name of the file
     */
    @Override
    public String getImageFileName() {
        // TODO Auto-generated method stub
        final StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName().toLowerCase());
        
        if(isAlive()) {
            sb.append(".gif");
        } else {
            sb.append("_dead.gif");
        }
        
        return sb.toString();
    }
    
    /**
     * the method return direction
     * 
     * @return the direction of the vehicle
     */
    
    @Override
    public Direction getDirection() {
        // TODO Auto-generated method stub
        return myDirection;
    }

    
    /**
     * the method return vehicle' x coordinate
     * 
     * @return the x coordinate
     */
    
    @Override
    public int getX() {
        // TODO Auto-generated method stub
        return myX;
    }

    /**
     * the method return vehicle' y coordinate
     * 
     * @return the y coordinate
     */
    @Override
    public int getY() {
        // TODO Auto-generated method stub
        return myY;
    }

    /**
     * the method return whether vehicle is alive
     * 
     * @return true if the vehicle is alive
     */
    @Override
    public boolean isAlive() {
        // TODO Auto-generated method stub
        return myAlive;
    }

    /**
     * the method count of the time of death and update live status
     */
    @Override
    public void poke() {
        // TODO Auto-generated method stub

        
        if(!isAlive()) {
            if(myPoke == myDeathTime) {
                myAlive = true;
                myPoke = 0;
                setDirection(Direction.random());
            }else {
                myPoke++;
            }
        }
    }

    /**
     * the method reset the vehicle's x position and direction
     */
    @Override
    public void reset() {
        // TODO Auto-generated method stub
        setX(myInitialX);
        setY(myInitialY);
        setDirection(myInitialDirection);
        this.myAlive = true;
    }

    /**
     * The method sets this vehicle's direction
     * 
     * @param theY The new y-coordinate.
     */
    @Override
    public void setDirection(Direction theDir) {
        // TODO Auto-generated method stub
        this.myDirection = theDir;
    }

    /**
     * The method sets this vehicle's x-coordinate 
     * 
     * @param theY The new x-coordinate.
     */
    @Override
    public void setX(int theX) {
        // TODO Auto-generated method stub
        this.myX = theX;
    }

    /**
     * The method sets this vehicle's y-coordinate
     * 
     * @param theY The new y-coordinate.
     */
    @Override
    public void setY(int theY) {
        // TODO Auto-generated method stub
        this.myY = theY;

    }
    
    /** {@inheritDoc} */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [myDeathTime: " +  myDeathTime + "]");
        sb.append(" [Pokes: " + myPoke + "]");  
        return sb.toString();
    }
    
    /**
     * Check whether a object can pass the terrain.
     * 
     * @param theTerrain object will try to pass the terrain.
     * @param theLight   object will try to pass the color of the light.
     * @return If object can pass, return true. If object can pass, return false
     */

    public abstract boolean canPass(final Terrain theTerrain, final Light theLight);
    
    
    /**
     *  This method returns the Direction of object based on the given the neighbor terrain.
     * 
     * @param theNeighbors The map of neighbor terrain.
     * @return the direction the object will go.
     */
    
    public abstract Direction chooseDirection(final Map<Direction, Terrain> theNeighbors);


}
