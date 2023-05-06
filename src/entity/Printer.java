package entity;

import java.util.List;

public final class Printer {

    private static final void printHeader() {
        System.out.println(String.format("%1$10.10s |%1$10.10s | %1$-10.10s | %1$-10.10s | %1$-10.10s | %1$-10.10s | %1$-10.10s |", "--------------"));
        System.out.println(String.format("%10.10s |%10.10s | %-10.10s | %-10.10s | %-10.10s | %-10.10s | %-10.10s |", "#", "имя", "возраст", "здоровье", "настроение", "сытость", "ср.уровень"));
        System.out.println(String.format("%1$10.10s |%1$10.10s | %1$-10.10s | %1$-10.10s | %1$-10.10s | %1$-10.10s | %1$-10.10s |", "--------------"));
    }

    private static final void printCat(Cat cat, int num) {
        System.out.println(String.format("%10.10s |%10.10s | %-10.10s | %-10.10s | %-10.10s | %-10.10s | %-10.10s |", num, cat.getName(), cat.getAge(),
                cat.getHealth(), cat.getMood(), cat.getSatiety(), cat.getAvgLevel()));

    }

    public static final void print(List<Cat> cats) {
        int num = 1;
        printHeader();
        for (int i = 0; i < cats.size(); i++) {
            printCat(cats.get(i), num);
            num++;
        }
        System.out.println(String.format("%1$10.10s |%1$10.10s | %1$-10.10s | %1$-10.10s | %1$-10.10s | %1$-10.10s | %1$-10.10s |", "--------------"));
        System.out.println();
    }
}

