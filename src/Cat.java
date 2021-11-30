package com.company;

class Cat {
    private String name;
    private int appetite;
    private int satietyTime;
    private int satiety;

    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    public Cat(String name, int appetite, int satietyTime) {
        this.name = name;
        this.appetite = appetite;
        this.satietyTime = satietyTime;
        this.satiety = 0;
    }
    void eat(Plate p) {
        p.decreaseFood(appetite);
        satiety += satietyTime;
    }

    public void setSatietyTime(int satietyTime) {
        this.satietyTime = satietyTime;
    }

    String getName() {
        return name;
    }

    int getAppetite() {
        return appetite;
    }

    int getSatietyTime() {
        return satietyTime;
    }

    int getSatiety() {
        return satiety;
    }


}