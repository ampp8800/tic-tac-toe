package com.ampp8800.TicTacToe;

import static java.lang.String.valueOf;

public class GameOutput {
    public static void fieldOutput(Symbol.GameElements[][] matrix) {
        System.out.print("  ");
        for (int i = 1; i<matrix.length+1; i++){
            System.out.print(" " + i);
        }
        System.out.println();
        dottedLine(matrix[0]);
        for (int i = 0; i<matrix[0].length; i++) {
            System.out.print((char)('a'+i) + " |");
            for (int j = 0; j<matrix.length; j++) {
                System.out.print(" " + valueOf(matrix[i][j].getSymbol()));
                System.out.print(" |");
            }
            System.out.println();
            dottedLine(matrix[0]);
        }
    }

    private static void dottedLine(Symbol.GameElements[] line) {
        System.out.print("  ");
        for (int i = 0; i<line.length; i++){
            System.out.print("----");
        }
        System.out.print("-");
        System.out.println();
    }

}
