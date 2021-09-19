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
        if (intData[0] >= MIN_SIZE && intData[1] >= MIN_SIZE && intData[0] <= MAX_SIZE && intData[1] <= MAX_SIZE) {
            if (intData[2] <= intData[0] && intData[2] <= intData[1] && intData[2] >= MIN_SIZE) {
                return intData;
            } else {
                System.out.println("unavailable sequence length");
            }
        } else {
            System.out.println("unavailable field size");
        }
        return null;
    }
}
