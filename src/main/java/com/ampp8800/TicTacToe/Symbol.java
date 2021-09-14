package com.ampp8800.TicTacToe;

public class Symbol {
    private static final char CROSS = 'X';
    private static final char ZERO = 'O';
    private static final char SPASE = ' ';
    private static final char[] YES = new char[] {'y', 'Y'};
    private static final char[] NO = new char[] {'n', 'N'};


    enum GameElements {
        CROSS(Symbol.CROSS),
        ZERO(Symbol.ZERO),
        SPASE(Symbol.SPASE),
        YES(Symbol.YES),
        NO(Symbol.NO);

        private char[] symbol;

        GameElements(char... symbol) {
            this.symbol = symbol;
        }

        public char[] getSymbol() {
            return symbol;
        }

        public static GameElements getFromChar(char charGameElements) {
            for (GameElements gameElements : GameElements.values()) {
                char[] charSymbols = gameElements.getSymbol();
                for (char charSymbol : charSymbols) {
                    if (charSymbol == charGameElements) {
                        return gameElements;
                    }
                }
            }
            return null;
        }

    }

}
