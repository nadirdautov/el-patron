package com.company.gb;

public class Dog extends Animal {

    public static int counter = 0;

    public Dog(String name, int maxDistanceForRun, int maxDistanceForSwim) {
        super(name, 500, 10);
        counter++;
    }
}