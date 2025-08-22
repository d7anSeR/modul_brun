package com.kuspanova.hard;

import java.util.List;

public class CardDesk {
    private String[] cardDesk;

    public CardDesk(String[] cardDesk) {
        this.cardDesk = cardDesk;
    }

    public String getCard() {
        String card = cardDesk[0];
        for (int i = 0; i + 1 < cardDesk.length; i++) {
            cardDesk[i] = cardDesk[i + 1];
        }
        return card;
    }

    public int sumCards(List<String> cards) {
        int sum = 0;
        for (String elem : cards) {
            if (elem.equals("туз")) {
                sum += 11;
            } else if (elem.equals("дама") || elem.equals("валет") || elem.equals("король")) {
                sum += 10;
            } else {
                sum += 1;
            }
        }
        return sum;
    }

    public int closestToNumber(int x, int y) {
        int distX = 21 - x;
        int distY = 21 - y;

        if (distX < distY) return x;
        else if (distY < distX) return y;
        else return Math.max(x, y);
    }
}