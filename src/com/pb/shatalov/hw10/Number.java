package com.pb.shatalov.hw10;

public abstract class Number {

    protected int value;
    protected float value2;

    protected Number(int value) {
        this.value = value;
    }

    public int get() {
        return value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
