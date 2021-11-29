package com.company.gb;

public class Cat extends Animal {
    public static int counter = 0;

    public Cat(String name, int maxDistanceForRun, int maxDistanceForSwim) {
        super(name, maxDistanceForRun, 0);
        counter++;
    }
}
