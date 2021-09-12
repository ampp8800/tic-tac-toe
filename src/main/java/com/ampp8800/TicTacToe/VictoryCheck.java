package com.ampp8800.TicTacToe;

public class VictoryCheck {
    public static boolean checkGame(Symbol.GameElements[][] matrix) {
        for (int i = 0; i<matrix[0].length; i++) {
            if (chekLine(matrix[i])) {
                return true;
            }
            Symbol.GameElements[] column = new Symbol.GameElements[matrix.length];
            for (int j = 0; j<matrix.length; j++) {
                column[j] = matrix[j][i];
            }
            if (chekLine(column)) {
                return true;
            }
        }
        if (chekDiagonal(matrix)) {
            return true;
        }
        for (int i = 0; i<matrix.length; i++) {
            Symbol.GameElements temporaryValue = matrix[i][i];
            matrix[i][i] = matrix[i][(matrix.length - i) - 1];
            matrix[i][(matrix.length - i) - 1] = temporaryValue;
        }
        if (chekDiagonal(matrix)) {
            return true;
        }
        return false;
    }

    public static boolean chekLine(Symbol.GameElements[] massiv) {
        Symbol.GameElements symbol;
        if (!Symbol.GameElements.SPASE.equals(massiv[0])) {
            symbol = massiv[0];
        } else {
            return false;
        }
        for (int i = 1; i< massiv.length; i++) {
            if (symbol != massiv[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean chekDiagonal (Symbol.GameElements[][] matrix) {
        Symbol.GameElements symbol;
        if (matrix[0][0] != Symbol.GameElements.SPASE) {
            symbol = matrix[0][0];
        } else {
            return false;
        }
        for (int i = 0; i<matrix.length; i++) {
            if (symbol != matrix[i][i]) {
                return false;
            }
        }
        return true;
    }

}
