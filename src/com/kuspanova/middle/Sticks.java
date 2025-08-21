package com.kuspanova.middle;

public class Sticks {
    private boolean rightPlayPerson;
    private int countSticks;

    public Sticks(boolean rightPlayPerson, int countSticks) {
        this.rightPlayPerson = rightPlayPerson;
        this.countSticks = countSticks;
    }

    public boolean isRightPlayPerson() {
        return rightPlayPerson;
    }

    public void setRightPlayPerson(boolean rightPlayPerson) {
        this.rightPlayPerson = rightPlayPerson;
    }

    public int getCountSticks() {
        return countSticks;
    }

    public void setCountSticks(int countSticks) {
        this.countSticks = countSticks;
    }

    public boolean isVictory(){
        if (countSticks == 1)
            return true;
        else
            return false;
    }

    public int stepComputer(){
        int take = (countSticks - 1) % 4;
        if (take == 0) {
            take = 1; // если нет гарантированного выигрыша — берём 1
        }
        return take;
    }

    public String drawSticks() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < countSticks; i++) {
            sb.append("|");
        }
        return sb.toString();
    }
}
