package com.lzlg.domain.design.function;

import java.util.function.Predicate;

public class Paint {
    private double volume;

    private int red;

    private int yellow;

    private int blue;

    public Paint(double volume, int red, int yellow, int blue) {
        this.volume = volume;
        this.red = red;
        this.yellow = yellow;
        this.blue = blue;
    }

    public void mixIn(Paint other) {
        volume = volume + other.getVolume();
        // do other thing
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
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
