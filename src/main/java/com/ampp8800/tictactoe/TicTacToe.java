package com.ampp8800.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.String.valueOf;

public class TicTacToe {

    static Symbol.GameElements player = Symbol.GameElements.CROSS;
    static boolean recording;
    static GameData gameData = new GameData();
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        gameData.clearMatrix(Symbol.GameElements.SPASE);
        System.out.println("Hey! Let's play?");
        while (true) {
            GameOutput.fieldOutput(gameData.getMatrix());
            System.out.print("player " + valueOf(player.getSymbol()) + " turn: ");
            recording = cellAssignment();
            if (GameFinishCheck.checkVictory(gameData.getMatrix())) {
                GameOutput.fieldOutput(gameData.getMatrix());
                System.out.println("Player " + valueOf(player.getSymbol()) + " win!");
                System.out.println("one more batch?");
                if (nextGame()) {
                    gameData.clearMatrix(Symbol.GameElements.SPASE);
                } else {
                    break;
                }
            }
            if (GameFinishCheck.checkDraw(gameData.getMatrix())) {
                GameOutput.fieldOutput(gameData.getMatrix());
                System.out.println("Draw!");
                System.out.println("one more batch?");
                if (nextGame()) {
                    gameData.clearMatrix(Symbol.GameElements.SPASE);
                } else {
                    break;
                }
            }
            player = nextMove(recording, player);
        }
    }


    public static boolean cellAssignment() {
        boolean recordingCell = false;
        try {
            String curritLine = reader.readLine();
            if (curritLine.length() == 2) {
                int column = Integer.parseInt(curritLine.substring(curritLine.length() - 1));
                column--;
                int line = curritLine.charAt(0);
                if (line >= 'a'){
                    line -= 'a';
                } else {
                    line -= 'A';
                }
                recordingCell = gameData.setMatrix(line, column, player);
                if (!recordingCell && (line<=GameData.FIELD_SIZE || column<=GameData.FIELD_SIZE)) {
                    System.out.println("The selected cell is busy");
                }
            } else {
                System.out.println("Incorrect input");
            }
        } catch (Exception e) {
            System.out.println("Incorrect input");
        }
        return recordingCell;
    }

    public static Symbol.GameElements nextMove(boolean recordingCell, Symbol.GameElements player) {
        if (recordingCell) {
            if (player == Symbol.GameElements.CROSS) {
                player = Symbol.GameElements.ZERO;
            } else {
                player = Symbol.GameElements.CROSS;
            }
        }
        return player;
    }

    public static boolean nextGame() {
        while (true) {
            try {
                Symbol.GameElements inputData = null;
                String curritLine = reader.readLine();
                if (curritLine.length() == 1){
                    inputData = Symbol.GameElements.getFromChar(curritLine.charAt(0));
                }
                if (inputData == Symbol.GameElements.YES) {
                    return true;
                } else if (inputData == Symbol.GameElements.NO) {
                    return false;
                } else {
                    System.out.println("Incorrect input");
                }
            } catch (Exception e) {
                System.out.println("Incorrect input");
            }
        }
    }
}
