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
        if (isFieldSizeValid(intData)) {
            if (isVictoryLength(intData)) {
                return intData;
            } else {
                System.out.print("unavailable sequence length " + MIN_SIZE + "..." + MAX_SIZE + " (but not more than the length of the shortest side).");
            }
        } else {
            System.out.print("unavailable field size " + MIN_SIZE + "..." + MAX_SIZE + " " + MIN_SIZE + "..." + MAX_SIZE );
        }
        return null;
    }

    private static boolean isFieldSizeValid(int[] size) {
        return size[0] >= MIN_SIZE && size[1] >= MIN_SIZE && size[0] <= MAX_SIZE && size[1] <= MAX_SIZE;
    }

    private static boolean isVictoryLength(int[] matrix) {
        return matrix[2] <= matrix[0] && matrix[2] <= matrix[1] && matrix[2] >= MIN_SIZE;
    }
}
