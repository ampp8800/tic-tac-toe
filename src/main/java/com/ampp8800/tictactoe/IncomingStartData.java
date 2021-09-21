package com.ampp8800.tictactoe;

public class IncomingStartData {
    final static int MIN_SIZE = 3;
    final static int MAX_SIZE = 10;

    public static int[] settingFieldAndSequence(String string) {
        String strData[] = string.split(" ");
        int[] intData;
        if (strData.length == 3) {
            intData = new int[3];
            for (int i = 0; i < intData.length; i++) {
                intData[i] = Integer.parseInt(strData[i]);
            }
        } else {
            return null;
        }
        if (checkSize(intData)) {
            if (checkVictoryLength(intData)) {
                return intData;
            } else {
                System.out.print("unavailable sequence length 3...10, but not more than the length of the shortest side. ");
            }
        } else {
            System.out.print("unavailable field size c...j 3...10. ");
        }
        return null;
    }

    private static boolean checkSize(int[] size) {
        return size[0] >= MIN_SIZE && size[1] >= MIN_SIZE && size[0] <= MAX_SIZE && size[1] <= MAX_SIZE;
    }

    private static boolean checkVictoryLength(int[] matrix) {
        return matrix[2] <= matrix[0] && matrix[2] <= matrix[1] && matrix[2] >= MIN_SIZE;
    }
}
