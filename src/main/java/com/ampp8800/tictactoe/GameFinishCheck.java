package com.ampp8800.tictactoe;

public class GameFinishCheck {
    public static boolean checkVictory(Symbol.GameElements[][] matrix) {
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

    public static boolean checkDraw(Symbol.GameElements[][] matrix) {
        for (int i = 0; i<matrix[0].length; i++) {
            for (int j = 0; j< matrix.length; j++) {
                if (matrix[j][i] == Symbol.GameElements.SPASE) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean chekLine(Symbol.GameElements[] line) {
        Symbol.GameElements symbol;
        if (!Symbol.GameElements.SPASE.equals(line[0])) {
            symbol = line[0];
        } else {
            return false;
        }
        for (int i = 1; i< line.length; i++) {
            if (symbol != line[i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean chekDiagonal (Symbol.GameElements[][] matrix) {
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
