package aoc2023.model.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static aoc2023.model.day3.Coord2D.coord2D;
import static java.lang.Character.isDigit;

class EngineSchematic {
    private final char[][] engineData;
    private final int xSize;
    private final int ySize;

    private EngineSchematic(char[][] engineData, int xSize, int ySize) {
        this.engineData = engineData;
        this.xSize = xSize;
        this.ySize = ySize;
    }

    List<Coord2D> getStarPositions() {
        List<Coord2D> positions = new ArrayList<>();
        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                if (getCharAt(x, y) == '*')
                    positions.add(coord2D(x, y));
            }
        }

        return positions;
    }

    char getCharAt(int x, int y) {
        return engineData[y][x];
    }

    public int getXSize() {
        return xSize;
    }

    public int getYSize() {
        return ySize;
    }

    static EngineSchematic create(List<String> engineInputData) {
        return new EngineSchematic(
                createEngineData(engineInputData),
                engineInputData.size(),
                engineInputData.get(0).length()
        );
    }

    private static char[][] createEngineData(List<String> engineInputData) {
        char[][] chars = new char[engineInputData.size()][];
        for (int y = 0; y < engineInputData.size(); y++) {
            chars[y] = engineInputData.get(y).toCharArray();
        }
        return chars;
    }

    private boolean hasAdjacentSymbols(int x, int y) {
        return checkSymbolsInDifferentRow(x, y - 1) ||
                checkSymbolsInSameRow(x, y) ||
                checkSymbolsInDifferentRow(x, y + 1);
    }

    private boolean checkSymbolsInDifferentRow(int x, int row) {
        return safeCheckAdjacentSymbol(x - 1, row) || safeCheckAdjacentSymbol(x, row) || safeCheckAdjacentSymbol(x + 1, row);
    }

    private boolean checkSymbolsInSameRow(int x, int row) {
        return safeCheckAdjacentSymbol(x - 1, row) || safeCheckAdjacentSymbol(x + 1, row);
    }

    private boolean safeCheckAdjacentSymbol(int x, int y) {
        if (y >= 0 && y < ySize &&
                x >= 0 && x < xSize)
            return engineData[y][x] != '.' && !isDigit(engineData[y][x]);
        else
            return false;
    }
}
