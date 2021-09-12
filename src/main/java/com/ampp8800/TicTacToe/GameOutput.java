package com.ampp8800.TicTacToe;

public class GameOutput {
    public static void fieldOutput(Symbol.GameElements[][] matrix) {
        System.out.println("-------");
        for (int i = 0; i<matrix[0].length; i++) {
            System.out.print("|");
            for (int j = 0; j< matrix.length; j++) {
                System.out.print(matrix[i][j].getSymbol());
                System.out.print("|");
            }
            System.out.println("\n-------");
        }
    }

}
