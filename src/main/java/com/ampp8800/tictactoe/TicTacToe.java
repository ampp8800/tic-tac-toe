package com.ampp8800.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.String.valueOf;

public class TicTacToe {

    static Symbol.GameElements player = Symbol.GameElements.CROSS;
    static boolean recording;
    static boolean newGame = true;
    static GameData gameData;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        System.out.println("Hey! Let's play?");
        while (true) {
            if (newGame) {
                gameData = startGameData();
            }
            if (!newGame) {
                GameOutput.fieldOutput(gameData.getMatrix());
                System.out.print("player " + valueOf(player.getSymbol()) + " turn: ");
                recording = cellAssignment();
                if (GameFinishCheck.checkVictory(gameData.getMatrix(), gameData.getVictoryLength())) {
                    GameOutput.fieldOutput(gameData.getMatrix());
                    System.out.println("Player " + valueOf(player.getSymbol()) + " win!");
                    System.out.println("one more batch?");
                    if (nextGame()) {
                        newGame = true;
                    } else {
                        break;
                    }
                }
                if (GameFinishCheck.checkDraw(gameData.getMatrix())) {
                    GameOutput.fieldOutput(gameData.getMatrix());
                    System.out.println("Draw!");
                    System.out.println("one more batch?");
                    if (nextGame()) {
                        newGame = true;
                    } else {
                        break;
                    }
                }
                player = nextMove(recording, player);
            }
        }
    }

    public static GameData startGameData() {
        GameData currentData = null;
        System.out.println("Set the size of the field and the length of the winning sequence (X Y n)");
        try {
            currentData = new GameData(IncomingStartData.settingFieldAndSequence(reader.readLine()));
            currentData.clearMatrix(Symbol.GameElements.SPASE);
        } catch (Exception unused) {
        }
        if (currentData == null) {
            System.out.println("Incorrect input");
        } else {
            newGame = false;
        }
        return currentData;
    }

    public static boolean cellAssignment() {
        boolean recordingCell = false;
        try {
            String curritLine = reader.readLine();
            if (curritLine.length() == 2) {
                int column = Integer.parseInt(curritLine.substring(curritLine.length() - 1));
                column--;
                int line = curritLine.charAt(0);
                if (line >= 'a') {
                    line -= 'a';
                } else {
                    line -= 'A';
                }
                recordingCell = gameData.setMatrix(line, column, player);
                if (!recordingCell && (line <= gameData.getFieldWidth() || column <= gameData.getFieldHeight())) {
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
                if (curritLine.length() == 1) {
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
