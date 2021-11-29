package com.company.gb;

public abstract class Animal {
    private final String name;
    private final int  maxDistanceForRun;
    private final int maxDistanceForSwim;
    public static int counter = 0;


    public Animal(String name, int maxDistanceForRun, int maxDistanceForSwim) {
        this.name = name;
        this.maxDistanceForRun = maxDistanceForRun;
        this.maxDistanceForSwim = maxDistanceForSwim;
        counter++;
    }

    public void run(int distanceRun) {
        if (distanceRun > maxDistanceForRun) {
            System.out.println(name + " can't ran this distance" + " " + distanceRun);
        } else if (distanceRun < 0) {
            System.out.println("distance cannot be negative");
        } else {
            System.out.println(name + " " + "ran " + distanceRun + "m ");
        }

    }

    public void swim(int distanceSwim) {
        if (distanceSwim > maxDistanceForRun) {
            System.out.println(name + "can't swim this distance" + " " + distanceSwim);
        } else if (distanceSwim < 0) {
            System.out.println("distance cannot be negative");
        } else if (maxDistanceForSwim == 0) {
            System.out.println(name + " " +  "can't swim");
        } else {
            System.out.println(name + " " + "swam " + distanceSwim + "m ");
        }

    }
}


