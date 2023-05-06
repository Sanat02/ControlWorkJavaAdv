import entity.Cat;
import entity.Printer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Simulator {
    private Cat cat;
    private List<Cat> listOfCats;


    public void run() {
        Scanner in = new Scanner(System.in);
        listOfCats = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.println("Введите имя кота:");
            String name = in.nextLine();
            int age = Integer.parseInt(retrieveAge());
            listOfCats.add(new Cat(name, age));
        }

        Printer.print(listOfCats);
        System.out.println();
        var list=sortByAvg();
        Printer.print(list);


    }

    private String retrieveAge() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите возраст кота:");
        String value = in.nextLine();
        boolean isvalid = returnValidNumber(value);
        while (!isvalid) {
            System.out.println("Неправильное значение!Введите заново:");
            value = in.nextLine();
            isvalid = returnValidNumber(value);
        }
        return value;
    }

    public boolean returnValidNumber(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public List<Cat> sortByAvg() {
        var sortedByYearList = listOfCats.stream().sorted(Comparator.comparing(Cat::getAvgLevel)).collect(Collectors.toList());
        return sortedByYearList;
    }
}
