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
    @DisplayName("Invalid palette size throws IllegalArgumentException")
    void checkInvalidPaletteSizeConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(2));
    }

    @Test
    @DisplayName("Colour with valid palette size is not null")
    void checkColourConstructorWithValidPaletteSize() {
        colour = new ColourTable(8);
        assertNotNull(colour);
    }

    @Test
    @DisplayName("Palette size zero throws IllegalArgumentException")
    void checkPaletteSizeZeroConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(0));
    }

    @Test
    @DisplayName("Palette size exceeding limit throws IllegalArgumentException")
    void checkPaletteSizeExceedLimitConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(1025));
    }

    @Test
    @DisplayName("Adding color to ColourTable with valid palette size does not throw an exception")
    void addColorToValidPaletteSize() {
        colour = new ColourTable(4);
        assertDoesNotThrow(() -> colour.add(0xFF0000));
        assertEquals(1, colour.getSize());
    }

    @Test
    @DisplayName("Adding color to ColourTable exceeding capacity throws IllegalStateException")
    void addColorExceedingCapacity() {
        colour = new ColourTable(2);
        assertDoesNotThrow(() -> colour.add(0xFF0000));
        assertDoesNotThrow(() -> colour.add(0x00FF00));
        assertThrows(IllegalStateException.class, () -> colour.add(0x0000FF));
    }

    @Test
    @DisplayName("Adding invalid RGB color throws IllegalArgumentException")
    void addInvalidRGBColor() {
        colour = new ColourTable(4);
        assertThrows(IllegalArgumentException.class, () -> colour.add(-1));
    }

    @Test
    @DisplayName("Adding duplicate color throws DuplicateColorException")
    void addDuplicateColor() {
        colour = new ColourTable(4);
        assertDoesNotThrow(() -> colour.add(0xFF0000));
        assertThrows(DuplicateColorException.class, () -> colour.add(0xFF0000));
    }

    @Test
    @DisplayName("Colors with the same components are equal")
    void equalColours() {
        colour = new ColourTable(16);
        ColourTable colour1 = new ColourTable(24);
        ColourTable colour2 = new ColourTable(8);
        ColourTable colour3 = new ColourTable(12);
        ColourTable colour4 = new ColourTable(12);
        ColourTable colour5 = new ColourTable(16);

        assertEquals(colour, colour1);
        assertNotEquals(colour, colour2);
        assertNotEquals(colour4, colour5);
        assertEquals(colour3, colour4);
    }
}