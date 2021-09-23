package com.ampp8800.tictactoe;

public class GameData {
    private int fieldWidth;
    private int fieldHeight;
    private int victoryLength;
    private Symbol.GameElements[][] matrix;

    public GameData(int[] inputData) {
        this.fieldWidth = inputData[0];
        this.fieldHeight = inputData[1];
        this.victoryLength = inputData[2];
        this.matrix = new Symbol.GameElements[fieldHeight][fieldWidth];
    }

    public void clearMatrix(Symbol.GameElements symbol) {
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][i] = symbol;
            }
        }
    }

    public int getFieldWidth() {
        return fieldWidth;
    }

    public int getFieldHeight() {
        return fieldHeight;
    }

    public int getVictoryLength() {
        return victoryLength;
    }

    public Symbol.GameElements[][] getMatrix() {
        Symbol.GameElements[][] cloneMatrix = new Symbol.GameElements[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, cloneMatrix[i], 0, matrix[i].length);
        }
        return cloneMatrix;
    }

    public boolean setMatrix(int line, int column, Symbol.GameElements symbol) {
        if (matrix[line][column] == Symbol.GameElements.SPASE) {
            matrix[line][column] = symbol;
            return true;
        } else {
            return false;
        }

    }
}
