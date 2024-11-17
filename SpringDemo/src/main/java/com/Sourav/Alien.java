package com.Sourav;

public class Alien {

    private int age;
    private int salary;
    private Computer computer;

    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    

    public Alien() {
        System.out.println("Inside Alien object");
    }

    // public Alien(int age, int salary, Computer computer) {
    //     this.age = age;
    //     this.salary = salary;
    //     this.computer = computer;
    // }


    public void code() {
        System.out.println("Code");
        computer.Compile();
        System.out.println(this.age);
        System.out.println(this.salary);
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

}
