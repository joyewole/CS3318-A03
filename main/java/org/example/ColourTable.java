package org.example;

import java.util.HashSet;
import java.util.Set;

public class ColourTable {

    private final int paletteSize;
    private final Set<Integer> colourPalette;

    public ColourTable(int paletteSize) {
        if (!isValidPaletteSize(paletteSize)) {
            throw new IllegalArgumentException("Invalid palette size");
        }

        this.paletteSize = paletteSize;
        this.colourPalette = new HashSet<>();
    }

    public void add(int rgbColor) {
        if (!isValidRGBValue(rgbColor) || colourPalette.size() >= paletteSize) {
            throw new IllegalStateException("Invalid RGB value or exceeding capacity");
        }

        if (!colourPalette.add(rgbColor)) {
            throw new IllegalStateException("Duplicate color");
        }
    }

    public int getSize() {
        return colourPalette.size();
    }

    private boolean isValidPaletteSize(int size) {
        return size > 1 && size < 1025 && (size & (size - 1)) == 0; // Check if it's a power of two
    }

    private boolean isValidRGBValue(int rgbColor) {
        // Implement your validation logic for 24-bit RGB values
        return rgbColor >= 0 && rgbColor <= 0xFFFFFF; // Placeholder for demonstration
    }
}
