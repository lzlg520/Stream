package com.lzlg.domain.design.function;

public class PigmentColor {
    private int red;

    private int yellow;

    private int blue;

    public PigmentColor(int red, int yellow, int blue) {
        this.red = red;
        this.yellow = yellow;
        this.blue = blue;
    }

    public PigmentColor mixedWith(PigmentColor other, double ratio) {
        return new PigmentColor(other.getRed() + this.red,
                other.getYellow() + this.yellow, other.getBlue() + this.blue);
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getYellow() {
        return yellow;
    }

    public void setYellow(int yellow) {
        this.yellow = yellow;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }
}
