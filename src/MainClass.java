package com.company;

public class MainClass {
    public static int TIME = 0;
    public static void main(String[] args) {
        Cat [] cat = new Cat[5];
        cat [0] = new Cat("Pepsi", 200, 6);
        cat [1] = new Cat("Iriska",100,2);
        cat [2] = new Cat("Murka",100,1);
        cat [3] = new Cat("Pushok",500,6);
        cat [4] = new Cat("Margarita",150,3);
        Plate plate = new Plate(1000);
        do{
            for(Cat i: cat){
                if(i.getSatiety()==0){
                    if(!plate.checkFood(i.getAppetite())){
                        plate.increaseFood();
                    }
                    i.eat(plate);
                    System.out.println("Кот " + i.getName() + " съел " + i.getAppetite() + " граммов корма и проголодается через " + (i.getSatiety()) + " часа(ов)");
                }
                i.setSatiety(i.getSatiety()-1);
            }
            System.out.println("\nС момента начала кормежки прошел(ло) " + TIME + " час(а). В миске осталось " + plate.getFood() + " граммов корма.\n");
            TIME++;


        }while (TIME <= 12);
        /*plate.info();
        cat.eat(plate);
        plate.info();*/
    }
}
