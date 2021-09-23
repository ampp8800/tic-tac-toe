package com.ampp8800.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.String.valueOf;

public class TicTacToe {

    static Symbol.GameElements player = Symbol.GameElements.CROSS;
    static boolean isMoveSuccessfullyCompleted;
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
                isMoveSuccessfullyCompleted = cellAssignment();
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
                player = nextMove(isMoveSuccessfullyCompleted, player);
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
        boolean cellEntry = false;
        try {
            String curritLine = reader.readLine();
            if (curritLine != null) {
                int columns = Integer.parseInt(curritLine.substring(1));
                columns--;
                int lines = curritLine.charAt(0);
                if (lines >= 'a') {
                    lines -= 'a';
                } else {
                    lines -= 'A';
                }
                if (columns <= (gameData.getFieldWidth() - 1) && lines <= (gameData.getFieldHeight() - 1)) {
                    cellEntry = gameData.setMatrix(lines, columns, player);
                    if (!cellEntry) {
                        System.out.println("The selected cell is busy");
                    }
                } else {
                    System.out.print("Incorrect input. Cell out of bounds ");
                    System.out.println("a..." + (char) (gameData.getFieldHeight() - 1 + 'a') + " 1..." + gameData.getFieldWidth());
                }
            }
        } catch (NumberFormatException | IOException e) {
            System.out.print("Incorrect input. Allowable values ");
            System.out.println("a..." + (char) (gameData.getFieldHeight() - 1 + 'a') + " 1..." + gameData.getFieldWidth());
        }
        return cellEntry;
    }

    public static Symbol.GameElements nextMove(boolean isNewSymbolRecorded, Symbol.GameElements nextPlayer) {
        if (isNewSymbolRecorded) {
            if (nextPlayer == Symbol.GameElements.CROSS) {
                nextPlayer = Symbol.GameElements.ZERO;
            } else {
                nextPlayer = Symbol.GameElements.CROSS;
            }
        }
        return nextPlayer;
    }

    public static boolean nextGame() {
        while (true) {
            try {
                Symbol.GameElements inputData = null;
                String currentLine = reader.readLine();
                if (currentLine != null) {
                    if (currentLine.length() == 1) {
                        inputData = Symbol.GameElements.getFromChar(currentLine.charAt(0));
                    }
                    if (inputData == Symbol.GameElements.YES) {
                        return true;
                    } else if (inputData == Symbol.GameElements.NO) {
                        return false;
                    } else {
                        System.out.println("Incorrect input");
                    }
                }
            } catch (IOException e) {
                System.out.println("Incorrect input");
            }
        }
    }
}
