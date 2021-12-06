package com.company.gb;

class employees {
    public String name;
    public String position;
    public String email;
    public String phone;
    public int salary;
    public int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public employees(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    @Override
    public String toString(){
        return(name+ "\n- "
                +position+ "\n- "
                +email+ "\n- "
                +phone+ "\n- "
                +salary+ "\n- "
                +age);
    }
}

