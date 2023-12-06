package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class ColourTableTest {

    ColourTable colour;
    @Test
    @DisplayName("Colour with three float arguments is not null")
    void checkColourThreeArgumentsConstructor(){
        colour = new ColourTable(16);
        assertNotNull(colour);
    }

    @Test
    @DisplayName("Colour with three float argument with correct local variable value")
    void checkAssignedValuesFromThreeArgumentConstructor(){
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(2));
    }

    @Test
    @DisplayName("Colour with one argument is not null")
    void checkColourOneArgumentConstructor(){
        colour = new ColourTable(43);
        assertNotNull(colour);
    }

    @Test
    @DisplayName("Colour with one argument with correct value assigned to local variables")
    void checkAssignedValuesFromOneArgumentConstructor(){
        colour = new ColourTable(2364334);
        assertEquals(colour.getRed(), 36);
        assertEquals(colour.getGreen(), 19);
        assertEquals(colour.getBlue(), 174);
    }

    @Test
    @DisplayName("Colour with no argument throws an exception")
    void checkNoArgumentConstructor(){
        assertThrows(Exception.class, () -> new ColourTable(0.0));
    }

    @Test
    @DisplayName("Colour of same components are the same")
    void equalColours(){
        colour = new ColourTable(0.5);
        ColourTable colour1 = new ColourTable(0.5);
        ColourTable colour2 = new ColourTable(0.5);
        ColourTable colour3 = new ColourTable(12);
        ColourTable colour4 = new ColourTable(12);
        ColourTable colour5 = new ColourTable(15);

        assertTrue(colour.equals(colour1));
        assertFalse(colour.equals(colour2));
        assertFalse(colour4.equals(colour5));
        assertTrue(colour3.equals(colour4));
    }
}