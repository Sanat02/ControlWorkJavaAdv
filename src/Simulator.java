import entity.Cat;
import entity.Printer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Simulator {
    private List<Cat> listOfCats;

    public void run() {
        Scanner in = new Scanner(System.in);
        listOfCats = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            addCat(0,101);
        }
        Printer.print(listOfCats);
        System.out.println();
//        System.out.println("..............Добавление нового кота..............");
//        addCat(0,81);
//        Printer.print(listOfCats);
        printAction();



    }

    private String retrieveName() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя кота:");
        String name = in.nextLine();
        while (name.isEmpty()) {
            System.out.println("Пустое значение!Введите имя кота:");
            name = in.nextLine();
        }
        return name;

    }

    private String retrieveAge() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите возраст кота:");
        String value = in.nextLine();
        while (value.isEmpty()) {
            System.out.println("Пустое знчение!Введите возраст кота:");
            value = in.nextLine();
        }
        boolean isvalid = returnValidNumber(value);
        while (!isvalid) {
            System.out.println("Неправильное значение!Введите заново:");
            value = in.nextLine();
            isvalid = returnValidNumber(value);
        }
        return value;
    }

    private boolean returnValidNumber(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void sortByAvgReversed() {
        listOfCats = listOfCats.stream().sorted(Comparator.comparing(Cat::getAvgLevel).reversed()).collect(Collectors.toList());
    }
    private void addCat(int startNum,int endNum)
    {
        String name = retrieveName();
        int age = Integer.parseInt(retrieveAge());
        while(age>18||age<0)
        {
            System.out.println("Неправильный возраст!");
            age = Integer.parseInt(retrieveAge());
        }
        listOfCats.add(new Cat(name, age,startNum,endNum));
        sortByAvgReversed();
    }
    private void printAction()
    {
        System.out.printf("%s%n1.%s%n2.%s%n3.%s%n4.%s%n","Доступные действия","Кормить кота","Играть с котом","Лечить кота","Добавить кота");
    }
}
