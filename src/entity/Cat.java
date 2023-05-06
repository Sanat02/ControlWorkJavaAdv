package entity;

import static utilities.Rnd.rnd;

public class Cat {
    private String name;
    private int age;
    private int health;
    private int mood;
    private int satiety;
    private int avgLevel;


    public Cat(String name, int age,int startNum,int endNum) {
        this.name = name;
        this.age = age;
        this.health = rnd(endNum) + startNum;
        this.mood =rnd(endNum) + startNum;
        this.satiety = rnd(endNum) + startNum;
        this.avgLevel=(health+mood+satiety)/3;

    }

    public int getAvgLevel() {
        return avgLevel;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHealth() {
        return health;
    }

    public int getMood() {
        return mood;
    }

    public int getSatiety() {
        return satiety;
    }

}
