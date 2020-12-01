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
import model.Direction;
import model.Light;
import model.Terrain;

/**
 * Unit tests for class Atv.
 * 
 * @author JaehongLee (jaehol3@uw.edu)
 * @version Fall 2020
 */


public class AtvTest {
    
    /**
     * The number of times to repeat a test to have a high probability that all
     * random possibilities have been explored.
     */
    private static final int TRIES_FOR_RANDOMNESS = 50;

    /** Test method for Atv constructor. */

    @Test
    public void testAtvConstructor() {
        
        final Atv atv = new Atv(6, 14, Direction.WEST);
        
        assertEquals("Atv x coordinate not initialized correctly!", 6, atv.getX());
        assertEquals("Atv y coordinate not initialized correctly!", 14, atv.getY());
        assertEquals("Atv direction not initialized correctly!",
                     Direction.WEST, atv.getDirection());
        assertEquals("Atv death time not initialized correctly!", 25, atv.getDeathTime());
        assertTrue("Atv isAlive() fails initially!", atv.isAlive());
    }
    
    /** Test method for Truck setters. */
    @Test
    public void testAtvSetters() {
        
        final Atv atv = new Atv(6, 14, Direction.WEST);
        
        atv.setX(3);
        assertEquals("Atv setX failed!", 3, atv.getX());
        atv.setY(15);
        assertEquals("Atv setY failed!", 15, atv.getY());
        atv.setDirection(Direction.SOUTH);
        assertEquals("Atv setDirection failed!", Direction.SOUTH, atv.getDirection());
    }

    /**
     * Test method for {@link Atv#canPass(Terrain, Light)}.
     */
    @Test
    public void testCanPass() {
        // ATVs can travel on any terrain except walls
        final List<Terrain> validTerrain = new ArrayList<>();
        validTerrain.add(Terrain.GRASS);
        validTerrain.add(Terrain.STREET);
        validTerrain.add(Terrain.LIGHT);
        validTerrain.add(Terrain.TRAIL);
        validTerrain.add(Terrain.CROSSWALK);

        
        final Atv atv = new Atv(0, 0, Direction.NORTH);
        for (final Terrain destinationTerrain : Terrain.values()) {
            
            for (final Light currentLightCondition : Light.values()) {
                if (destinationTerrain == Terrain.STREET) {
                    assertTrue("Atv should be able to pass STREET"
                            + ", with light " + currentLightCondition,
                            atv.canPass(destinationTerrain, currentLightCondition));
                    
                }else if (destinationTerrain == Terrain.CROSSWALK) {
                    // Atvs can pass CROSSWALK with any traffic light

                        assertTrue("Atv should be able to pass " + destinationTerrain
                                + ", with light " + currentLightCondition,
                                atv.canPass(destinationTerrain,
                                   currentLightCondition));
                }else if (destinationTerrain == Terrain.LIGHT) {
                    // Atvs can pass CROSSWALK with any traffic light

                    assertTrue("Atv should be able to pass " + destinationTerrain
                            + ", with light " + currentLightCondition,
                            atv.canPass(destinationTerrain,
                               currentLightCondition));
                }else if (destinationTerrain == Terrain.GRASS) {
                    // Atvs can pass CROSSWALK with any traffic light

                    assertTrue("Atv should be able to pass " + destinationTerrain
                            + ", with light " + currentLightCondition,
                            atv.canPass(destinationTerrain,
                               currentLightCondition));
                }else if (destinationTerrain == Terrain.TRAIL) {
                    // Atvs can pass CROSSWALK with any traffic light

                    assertTrue("Atv should be able to pass " + destinationTerrain
                            + ", with light " + currentLightCondition,
                            atv.canPass(destinationTerrain,
                               currentLightCondition));
                }else if (!validTerrain.contains(destinationTerrain)) {
 
                    assertFalse("Truck should NOT be able to pass " + destinationTerrain
                        + ", with light " + currentLightCondition,
                        atv.canPass(destinationTerrain, currentLightCondition));
                }
            } 
        }
    }
    
    
    
    /**
     * Test method for {@link Atv#chooseDirection(java.util.Map)}.
     */
    @Test
    public void testChooseDirectionSurroundedByTrail() {
        final Map<Direction, Terrain> neighbors = new HashMap<Direction, Terrain>();
        neighbors.put(Direction.WEST, Terrain.TRAIL);
        neighbors.put(Direction.NORTH, Terrain.TRAIL);
        neighbors.put(Direction.EAST, Terrain.TRAIL);
        neighbors.put(Direction.SOUTH, Terrain.TRAIL);
        
        boolean seenWest = false;
        boolean seenNorth = false;
        boolean seenEast = false;
        boolean seenSouth = false;
        
        final Atv atv = new Atv(0, 0, Direction.WEST);
   
        
        for (int count = 0; count < TRIES_FOR_RANDOMNESS; count++) {
            final Direction d = atv.chooseDirection(neighbors);
            
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
 
        assertTrue("Atv chooseDirection() fails to select randomly "
                   + "among all possible valid choices!",
                   seenWest && seenNorth && seenSouth);
            
        assertFalse("Atv chooseDirection() reversed direction when not necessary!",
                seenEast);
    }
    

    /**
     * Test method for {@link Truck#chooseDirection(java.util.Map)}.
     */ 
    @Test(expected = IllegalArgumentException.class)
    public void testReverseDirection() {
        // ATV’s never reverse direction (they never need to).
        for (final Terrain t : Terrain.values()) {
            if (t == Terrain.WALL) {
                
                final Map<Direction, Terrain> neighbors = new HashMap<Direction, Terrain>();
                neighbors.put(Direction.WEST, t);
                neighbors.put(Direction.NORTH, t);
                neighbors.put(Direction.EAST, Terrain.STREET);
                neighbors.put(Direction.SOUTH, t);
                
                final Atv atv = new Atv(6, 14, Direction.WEST);
                
                // ATV’s never reverse direction (they never need to).
                assertEquals("Atv chooseDirection() failed "
                                + "when reverse was the only valid choice!",
                             Direction.EAST, atv.chooseDirection(neighbors));
            }
                
        }
    }

}
