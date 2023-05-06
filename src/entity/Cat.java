package entity;

import static utilities.Rnd.rnd;

public class Cat {
    private String name;
    private int age;
    private int health;
    private int mood;
    private int satiety;
    private int avgLevel;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        this.health = rnd(101) + 0;
        this.mood =rnd(101) + 0;
        this.satiety = rnd(101) + 0;
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
