package com.ampp8800.TicTacToe;

public class DrawCheck {
    public static boolean checkGame(Symbol.GameElements[][] matrix) {
        for (int i = 0; i<matrix[0].length; i++) {
            for (int j = 0; j< matrix.length; j++) {
                if (matrix[j][i] == Symbol.GameElements.SPASE) {
                    return false;
                }
            }
        }
        return true;
    }
}
