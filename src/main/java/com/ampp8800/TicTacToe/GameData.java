package com.ampp8800.TicTacToe;

public class GameData {
    private Symbol.GameElements[][] matrix = new Symbol.GameElements[3][3];

    public void clearMatrix(Symbol.GameElements symbol) {
        for (int i = 0; i<matrix[0].length; i++) {
            for (int j = 0; j< matrix.length; j++) {
                matrix[i][j] = symbol;
            }
        }
    }

    public Symbol.GameElements[][] getMatrix() {
        Symbol.GameElements[][] cloneMatrix = new Symbol.GameElements[matrix.length][matrix[0].length];
        for (int i = 0; i< matrix.length; i++) {
            System.arraycopy(matrix[i], 0, cloneMatrix[i], 0, matrix[i].length);
        }
        return  cloneMatrix;
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
