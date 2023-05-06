package entity;

import static utilities.Rnd.rnd;

public class Cat {
    private String name;
    private int age;
    private int health;
    private int mood;
    private int satiety;
    private int avgLevel;


    public Cat(String name, int age, int startNum, int endNum) {
        this.name = name;
        this.age = age;
        this.health = rnd(endNum) + startNum;
        this.mood = rnd(endNum) + startNum;
        this.satiety = rnd(endNum) + startNum;
        this.avgLevel = (health + mood + satiety) / 3;

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

    public void feed() {
        System.out.printf("Вы кормите кота:%s ,возраст:%s%n", name, age);
        if (age >= 1 && age <= 5) {
            satiety += 7;
            mood += 7;
        } else if (age >= 6 && age <= 10) {
            satiety += 5;
            mood += 5;
        } else {
            satiety += 4;
            mood += 4;
        }
        satiety=Math.min(100,satiety);
        mood=Math.min(100,mood);
        avgLevel = (health + mood + satiety) / 3;
    }

    public void treat() {
        System.out.printf("Вы лечите кота:%s ,возраст:%s%n", name, age);
        if (age >= 1 && age <= 5) {
            health += 7;
            mood -= 3;
            satiety -= 3;
        } else if (age >= 6 && age <= 10) {
            health += 5;
            mood -= 5;
            satiety -= 5;
        } else {
            health += 4;
            mood -= 6;
            satiety -= 6;
        }
        health = Math.min(100, health);
        mood = Math.max(0, mood);
        satiety = Math.max(0, satiety);
        avgLevel = (health + mood + satiety) / 3;
    }

    public void play() {
        System.out.printf("Вы играете с котом:%s ,возраст:%s%n", name, age);
        if (age >= 1 && age <= 5) {
            mood += 7;
            health += 7;
            satiety -= 3;
        } else if (age >= 6 && age <= 10) {
            mood += 5;
            health += 5;
            satiety -= 5;
        } else {
            mood += 4;
            health += 5;
            satiety -= 6;
        }
        mood = Math.min(100, mood);
        health = Math.min(100, health);
        satiety = Math.max(0, satiety);
        avgLevel = (health + mood + satiety) / 3;
    }
    public void nextDay()
    {
        int r1=rnd(4)+(-3);
        int r2=rnd(4)+(-3);
        satiety-=rnd(6)+1;
        mood+=r1;
        health+=r2;

        satiety=Math.max(0,satiety);
        if(r1>=0)
        {
            mood=Math.min(100,mood);
        }
        else
        {
            mood=Math.max(0,mood);
        }
        if(r2>=0)
        {
            health=Math.min(100,health);
        }
        else
        {
            health=Math.max(0,health);
        }
        avgLevel = (health + mood + satiety) / 3;

    }

}
