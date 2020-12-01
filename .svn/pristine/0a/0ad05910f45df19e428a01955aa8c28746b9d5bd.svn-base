/*
 * TCSS 305 - Road Rage
 */
package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import model.Direction;
import model.Light;
import model.Terrain;
import model.Truck;


/**
 * Unit tests for class Truck.
 * 
 * @author JaehongLee (jaehol3@uw.edu)
 * @version Fall 2020
 */



public class TruckTest {

    /**
     * The number of times to repeat a test to have a high probability that all
     * random possibilities have been explored.
     */
    private static final int TRIES_FOR_RANDOMNESS = 50;
    
    /** Test method for Truck constructor. */
    @Test
    public void testTruckConstructor() {
        
        final Truck t = new Truck(6, 14, Direction.WEST);
        
        assertEquals("Truck x coordinate not initialized correctly!", 6, t.getX());
        assertEquals("Truck y coordinate not initialized correctly!", 14, t.getY());
        assertEquals("Truck direction not initialized correctly!",
                     Direction.WEST, t.getDirection());
        assertEquals("Truck death time not initialized correctly!", 0, t.getDeathTime());
        assertTrue("Truck isAlive() fails initially!", t.isAlive());
    }
    
    /** Test method for Truck setters. */
    @Test
    public void testTruckSetters() {
        final Truck t = new Truck(6, 14, Direction.WEST);
        
        t.setX(3);
        assertEquals("Truck setX failed!", 3, t.getX());
        t.setY(15);
        assertEquals("Truck setY failed!", 15, t.getY());
        t.setDirection(Direction.SOUTH);
        assertEquals("Truck setDirection failed!", Direction.SOUTH, t.getDirection());
    }

    
    /**
     * Test method for {@link Truck#canPass(Terrain, Light)}.
     */
    @Test
    public void testCanPass() {
        
        final List<Terrain> validTerrain = new ArrayList<>();
        validTerrain.add(Terrain.STREET);
        validTerrain.add(Terrain.LIGHT);
        validTerrain.add(Terrain.CROSSWALK);
        
        final Truck truck = new Truck(0, 0, Direction.NORTH);
        // test each terrain type as a destination
        for (final Terrain destinationTerrain : Terrain.values()) {
            // try the test under each light condition
            for (final Light currentLightCondition : Light.values()) {
                
                // trucks can pass Street under any light condition
                if (destinationTerrain == Terrain.STREET) {
                    assertTrue("Truck should be able to pass STREET"
                            + ", with light " + currentLightCondition,
                            truck.canPass(destinationTerrain, currentLightCondition));
                    
                } else if (destinationTerrain == Terrain.CROSSWALK) {
                    // trucks can pass CROSSWALK
                    // if the light is GREEN, YELLOW but not RED

                    if (currentLightCondition == Light.RED) {
                        assertFalse("Truck should NOT be able to pass " + destinationTerrain 
                                + ", with light " + currentLightCondition,
                                truck.canPass(destinationTerrain,
                                   currentLightCondition));
                    } else { // light is yellow or green
                        assertTrue("Truck should be able to pass " + destinationTerrain
                                + ", with light " + currentLightCondition,
                                truck.canPass(destinationTerrain,
                                   currentLightCondition));
                   }
                    
                } else if (destinationTerrain == Terrain.LIGHT ) {
                    
                        // trucks can pass CROSSWALK with any traffic light
                        assertTrue("Truck should be able to pass " + destinationTerrain
                                + ", with light " + currentLightCondition,
                                truck.canPass(destinationTerrain,
                                   currentLightCondition));
                   
                } else if (!validTerrain.contains(destinationTerrain)) {
 
                    assertFalse("Truck should NOT be able to pass " + destinationTerrain
                        + ", with light " + currentLightCondition,
                        truck.canPass(destinationTerrain, currentLightCondition));
                }
            }
        }
    }

    /**
     * Test method for {@link Truck#chooseDirection(java.util.Map)}.
     */
    @Test
    public void testChooseDirectionSurroundedByStreet() {
        final Map<Direction, Terrain> neighbors = new HashMap<Direction, Terrain>();
        neighbors.put(Direction.WEST, Terrain.STREET);
        neighbors.put(Direction.NORTH, Terrain.STREET);
        neighbors.put(Direction.EAST, Terrain.STREET);
        neighbors.put(Direction.SOUTH, Terrain.STREET);
        
        boolean seenWest = false;
        boolean seenNorth = false;
        boolean seenEast = false;
        boolean seenSouth = false;
        
        final Truck truck = new Truck(0, 0, Direction.WEST);
        
        for (int count = 0; count < TRIES_FOR_RANDOMNESS; count++) {
            final Direction d = truck.chooseDirection(neighbors);
            
            if (d == Direction.WEST) {
                seenWest = true;
            } else if (d == Direction.NORTH) {
                seenNorth = true;
            } else if (d == Direction.EAST) { // this should NOT be chosen
                seenEast = true;
            } else if (d == Direction.SOUTH) { 
                seenSouth = true;
            }
        }
 
        assertTrue("Truck chooseDirection() fails to select randomly "
                   + "among all possible valid choices!",
                   seenWest && seenNorth && seenSouth);
            
        assertFalse("Truck chooseDirection() reversed direction when not necessary!",
                seenEast);
    }
    
    
    /**
     * Test method for {@link Truck#chooseDirection(java.util.Map)}.
     */
    @Test
    public void testChooseDirectionOnGrassMustReverse() {
        
        for (final Terrain t : Terrain.values()) {
            if (t != Terrain.STREET && t != Terrain.LIGHT && t != Terrain.CROSSWALK) {
                
                final Map<Direction, Terrain> neighbors = new HashMap<Direction, Terrain>();
                neighbors.put(Direction.WEST, t);
                neighbors.put(Direction.NORTH, t);
                neighbors.put(Direction.EAST, Terrain.GRASS);
                neighbors.put(Direction.SOUTH, t);
                
                final Truck truck = new Truck(0, 0, Direction.WEST);
                
                // the truck must reverse and go SOUTH
                assertEquals("truck chooseDirection() failed "
                                + "when reverse was the only valid choice!",
                             Direction.EAST, truck.chooseDirection(neighbors));
            }
                
        }
    }
    
}
