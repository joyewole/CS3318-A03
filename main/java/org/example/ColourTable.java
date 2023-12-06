package org.example;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

    public class ColourTable {

    private final int paletteSize;
    private final Set<Integer> colourPalette;

    public ColourTable(int paletteSize) {
        validatePaletteSize(paletteSize);
        this.paletteSize = paletteSize;
        this.colourPalette = new HashSet<>();
    }

    public void add(int rgbColor) {
        validateRGBValue(rgbColor);
        if (colourPalette.size() >= paletteSize) {
            throw new IllegalStateException("Exceeding capacity");
        }

        if (!colourPalette.add(rgbColor)) {
            throw new DuplicateColorException("Duplicate color");
        }
    }

    public int getSize() {
        return colourPalette.size();
    }

    private void validatePaletteSize(int size) {
        if (size <= 1 || size >= 1025 || (size & (size - 1)) != 0) {
            throw new IllegalArgumentException("Invalid palette size");
        }
    }

    private void validateRGBValue(int rgbColor) {
        if (rgbColor < 0 || rgbColor > 0xFFFFFF) {
            throw new IllegalArgumentException("Invalid RGB value");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ColourTable that = (ColourTable) obj;
        return paletteSize == that.paletteSize && Objects.equals(colourPalette, that.colourPalette);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paletteSize, colourPalette);
    }
}



