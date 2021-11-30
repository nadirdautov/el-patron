package com.company;

public class Plate {
    public int getFood() {
        return food;
    }

    private int food;

    public Plate(int food) {
        this.food = food;
    }
    public void decreaseFood(int n) {
        food -= n;
    }
    void increaseFood() {
        this.food += 500;
        System.out.println("В миску добавили " + food + " грамм корма");
    }
    boolean checkFood(int n) {
        return (food - n) >= 0;
    }
    public void info() {
        System.out.println("plate: " + food);
    }
}