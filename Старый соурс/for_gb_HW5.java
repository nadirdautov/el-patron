package com.company.gb;

public class for_gb_HW5 {
    public static void main(String[] args) {
        employees [] comEmp = new employees[5];
            comEmp[0] = new employees("Nadir","Songwriter","djpvl01777@mailbox.ru","7771122",14000,23);
            comEmp[1] = new employees("Madi","MovieMaker","madi@mailbox.ru","7771400",70000,23);
            comEmp[2] = new employees("Gabie","HomeWorker","gabiewebcam@mailbox.ru","7770261",1000,54);
            comEmp[3] = new employees("Ilya","HomeWorker","little@mailbox.ru","7777182",20000,74);
            comEmp[4] = new employees("Mark","GrinderPencil", "juk@mailbox.com", "892312317",3000,21);
            for(int i = 0; i<comEmp.length;i++)
                if (comEmp[i].getAge() > 40) {
                    System.out.println(comEmp[i]);
                }
    }
}
