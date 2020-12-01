/*
 * TCSS 305 - Road Rage
 */
package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import model.Atv;
import model.Car;
import model.Direction;
import model.Human;
import model.Light;
import model.Terrain;


/**
 * Unit tests for class Car.
 * 
 * @author JaehongLee (jaehol3@uw.edu)
 * @version Fall 2020
 */

public class CarTest {
    
    /**
     * The number of times to repeat a test to have a high probability that all
     * random possibilities have been explored.
     */
    private static final int TRIES_FOR_RANDOMNESS = 50;

    /** Test method for Car constructor. */
    @Test
    public void testCarConstructor() {
        
        final Car c = new Car(10, 11, Direction.NORTH);
        
        assertEquals("Human x coordinate not initialized correctly!", 10, c.getX());
        assertEquals("Human y coordinate not initialized correctly!", 11, c.getY());
        assertEquals("Human direction not initialized correctly!",
                     Direction.NORTH, c.getDirection());
        assertEquals("Human death time not initialized correctly!", 15, c.getDeathTime());
        assertTrue("Human isAlive() fails initially!", c.isAlive());
    }

    /** Test method for Car setters. */
    @Test
    public void testCarSetters() {
        
        final Car c = new Car(10, 11, Direction.NORTH);
        
        c.setX(12);
        assertEquals("Human setX failed!", 12, c.getX());
        c.setY(13);
        assertEquals("Human setY failed!", 13, c.getY());
        c.setDirection(Direction.SOUTH);
        assertEquals("Human setDirection failed!", Direction.SOUTH, c.getDirection());
    }
    
    /**
     * Test method for {@link Atv#canPass(Terrain, Light)}.
     */
    @Test
    public void testCanPass() {
        // ATVs can travel on any terrain except walls
        final List<Terrain> validTerrain = new ArrayList<>();
        validTerrain.add(Terrain.STREET);
        validTerrain.add(Terrain.LIGHT);
        validTerrain.add(Terrain.CROSSWALK);
        
        final Car c = new Car(10, 11, Direction.NORTH);
        // test each terrain type as a destination
        for (final Terrain destinationTerrain : Terrain.values()) {
            // try the test under each light condition
            for (final Light currentLightCondition : Light.values()) {
                if (destinationTerrain == Terrain.STREET) {
                    
                    // humans can pass GRASS under any light condition
                    assertTrue("Car should be able to pass GRASS"
                               + ", with light " + currentLightCondition,
                               c.canPass(destinationTerrain, currentLightCondition));
                } else if (destinationTerrain == Terrain.CROSSWALK) {
                    // humans can pass CROSSWALK
                    // if the light is Green but not YELLOW or RED

                    if (currentLightCondition == Light.GREEN) {
                        assertTrue("Car should be able to pass " + destinationTerrain
                                + ", with light " + currentLightCondition, c.canPass(destinationTerrain,
                                   currentLightCondition));
                    } else { // light is yellow or red
                        assertFalse("Car should Not be able to pass " + destinationTerrain
                                + ", with light " + currentLightCondition, c.canPass(destinationTerrain,
                                   currentLightCondition));
                    }
                }  else if (destinationTerrain == Terrain.LIGHT) {
                    // humans can pass CROSSWALK
                    // if the light is Green but not YELLOW or RED

                    if (currentLightCondition == Light.RED) {
                        assertFalse("Car should be Not able to pass " + destinationTerrain
                                + ", with light " + currentLightCondition, c.canPass(destinationTerrain,
                                   currentLightCondition));
                    } else { // light is yellow or red
                        assertTrue("Car should  be able to pass " + destinationTerrain
                                + ", with light " + currentLightCondition, c.canPass(destinationTerrain,
                                   currentLightCondition));
                    }
                } else if (!validTerrain.contains(destinationTerrain)) {
 
                    assertFalse("Car should NOT be able to pass " + destinationTerrain
                        + ", with light " + currentLightCondition,
                        c.canPass(destinationTerrain, currentLightCondition));
                }
            }
        }
        
    }
    
    /**
     * Test method for {@link Car#chooseDirection(java.util.Map)}.
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
        
        final Car car = new Car(10, 11, Direction.NORTH);
        
        for (int count = 0; count < TRIES_FOR_RANDOMNESS; count++) {
            final Direction d = car.chooseDirection(neighbors);
            
            if (d == Direction.WEST) {
                seenWest = true;
            } else if (d == Direction.NORTH) {
                seenNorth = true;
            } else if (d == Direction.EAST) {
                seenEast = true;
            } else if (d == Direction.SOUTH) { // this should NOT be chosen
                seenSouth = true;
            }
        }
 
        assertTrue("Car chooseDirection() fails to select randomly "
                   + "among all possible valid choices!",
                   seenNorth);
            
        assertFalse("Car chooseDirection() reversed direction when not necessary!",
                    seenSouth&& seenWest && seenEast);
    }
    
    /**
     * Test method for {@link Car#chooseDirection(java.util.Map)}.
     */
    @Test
    public void testChooseDirectionOnStreetMustReverse() {
        
        for (final Terrain t : Terrain.values()) {
            if (t != Terrain.STREET && t != Terrain.LIGHT && t != Terrain.CROSSWALK) {
                
                final Map<Direction, Terrain> neighbors = new HashMap<Direction, Terrain>();
                neighbors.put(Direction.WEST, t);
                neighbors.put(Direction.NORTH, t);
                neighbors.put(Direction.EAST, t);
                neighbors.put(Direction.SOUTH, Terrain.STREET);
                
                
                final Car car = new Car(10, 11, Direction.NORTH);
                
                // the Human must reverse and go SOUTH
                assertEquals("Human chooseDirection() failed "
                                + "when reverse was the only valid choice!",
                             Direction.SOUTH, car.chooseDirection(neighbors));
            }
                
        }
    }
 
}
