import entity.Cat;
import entity.Printer;

import java.util.*;
import java.util.stream.Collectors;

public class Simulator {
    private List<Cat> listOfCats;

    public void run() {
        Scanner in = new Scanner(System.in);
        listOfCats = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            addCat(0, 101);
        }
        String continueNextDay = "y";
        while (continueNextDay.equals("y") && !listOfCats.isEmpty()) {
            Printer.print(listOfCats);
            System.out.println();
            int action = 1;
            while (action != 5) {
                action = printAction();
                performAction(action);
                for (int i = 0; i < listOfCats.size(); i++) {
                    if (listOfCats.get(i).getIsAlive() == 1) {
                        System.out.printf("Кот %s умер.%n", listOfCats.get(i).getHealth());
                        listOfCats.remove(i);
                    }
                }

            }
            System.out.println("----------Следующий день----------");
            listOfCats.forEach(o -> o.setIsActed(0));
            listOfCats.forEach(Cat::nextDay);
            System.out.println("Изменились характеристики котов");
            System.out.println();
            sortByAvgReversed();
            Printer.print(listOfCats);
            System.out.println("Введите букву y если хотите продолжить этот день");
            continueNextDay = in.nextLine().toLowerCase(Locale.ROOT);
        }
        System.out.println("-------------------Конец симуляции-------------------");
        if (!listOfCats.isEmpty()) {
            String continueSort = "y";
            System.out.println("Ваш окончательный список:");
            Printer.print(listOfCats);
            while (continueSort.equals("y")) {
                System.out.printf("Сортировать по:%na)%s%nb)%s%nc)%s%nd)%s%ne)%s%nf)%s%n", "имени", "возрасту", "здоровью", "настроению", "сытости", "среднему уровню");
                String option = in.nextLine().toLowerCase(Locale.ROOT);
                while (!option.equals("a") && !option.equals("b") && !option.equals("c") && !option.equals("e") && !option.equals("f")) {
                    System.out.println("Неправильно ввели значение.Введите заново!");
                    option = in.nextLine().toLowerCase(Locale.ROOT);
                }
                makeSort(option);
                System.out.println("Результат сортировки:");
                Printer.print(listOfCats);
                System.out.println("Введите букву y если хотите продолжить этот день");
                continueSort = in.nextLine().toLowerCase(Locale.ROOT);

            }
        } else {
            System.out.println("У вас не осталось котов!");
        }

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
        value = isNumeric(value);
        return value;
    }

    private String isNumeric(String value) {
        Scanner in = new Scanner(System.in);
        while (value.isEmpty()) {
            System.out.println("Пустое знчение!Введите заново");
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

    private void addCat(int startNum, int endNum) {
        String name = retrieveName();
        int age = Integer.parseInt(retrieveAge());
        while (age > 18 || age < 0) {
            System.out.println("Неправильный возраст!");
            age = Integer.parseInt(retrieveAge());
        }
        listOfCats.add(new Cat(name, age, startNum, endNum));
        sortByAvgReversed();
    }

    private int printAction() {
        Scanner in = new Scanner(System.in);
        System.out.printf("%s%n1.%s%n2.%s%n3.%s%n4.%s%n5.%s%n", "Доступные действия", "Кормить кота", "Играть с котом", "Лечить кота", "Добавить кота", "Следующий день");
        String command = in.nextLine();
        command = isNumeric(command);
        int num = Integer.parseInt(command);
        while (num > 5 || num < 1) {
            System.out.println("Неправильный номер действия!");
            command = in.nextLine();
            command = isNumeric(command);
            num = Integer.parseInt(command);
        }

        return num;
    }

    private void performAction(int num) {
        int integerCatNumber = 0;
        if (num != 4 && num != 5) {
            Printer.print(listOfCats);
            Scanner in = new Scanner(System.in);
            System.out.println("Введите номер кота:");
            String catNumber = in.nextLine();
            catNumber = isNumeric(catNumber);
            integerCatNumber = Integer.parseInt(catNumber);
            while (integerCatNumber > listOfCats.size() || integerCatNumber < 1) {
                System.out.println("Неправильный номер кота!");
                catNumber = in.nextLine();
                catNumber = isNumeric(catNumber);
                integerCatNumber = Integer.parseInt(catNumber);
            }
        }

        switch (num) {
            case 1:
                if (listOfCats.get(integerCatNumber - 1).getIsActed() == 1) {
                    System.out.println("Повторение....Характеристики не поменялись");
                    System.out.printf("Вы уже делали действие над котом:%s ,возраст:%s%n", listOfCats.get(integerCatNumber - 1).getName(), listOfCats.get(integerCatNumber - 1).getAge());
                } else {
                    listOfCats.get(integerCatNumber - 1).feed();
                    listOfCats.get(integerCatNumber - 1).setIsActed(1);

                }
                break;
            case 2:
                if (listOfCats.get(integerCatNumber - 1).getIsActed() == 1) {
                    System.out.println("Повторение....Характеристики не поменялись");
                    System.out.printf("Вы уже делали действие над котом:%s ,возраст:%s%n", listOfCats.get(integerCatNumber - 1).getName(), listOfCats.get(integerCatNumber - 1).getAge());
                } else {
                    listOfCats.get(integerCatNumber - 1).play();
                    listOfCats.get(integerCatNumber - 1).setIsActed(1);
                }
                break;
            case 3:
                if (listOfCats.get(integerCatNumber - 1).getIsActed() == 1) {
                    System.out.println("Повторение....Характеристики не поменялись");
                    System.out.printf("Вы уже делали действие над котом:%s ,возраст:%s%n", listOfCats.get(integerCatNumber - 1).getName(), listOfCats.get(integerCatNumber - 1).getAge());

                } else {
                    listOfCats.get(integerCatNumber - 1).treat();
                    listOfCats.get(integerCatNumber - 1).setIsActed(1);
                }
                break;
            case 4:
                System.out.println("----------Добавление нового кота----------");
                addCat(20, 81);
                System.out.println("Вы добавили нового кота!");
                break;
        }
        sortByAvgReversed();
    }

    private void sortByName() {
        listOfCats = listOfCats.stream().sorted(Comparator.comparing(Cat::getName)).toList();
    }

    private void sortByAge() {
        listOfCats = listOfCats.stream().sorted(Comparator.comparing(Cat::getAge)).toList();
    }

    private void sortByMood() {
        listOfCats = listOfCats.stream().sorted(Comparator.comparing(Cat::getMood)).toList();
    }

    private void sortBySatiety() {
        listOfCats = listOfCats.stream().sorted(Comparator.comparing(Cat::getSatiety)).toList();
    }

    private void sortByAvgLevel() {
        listOfCats = listOfCats.stream().sorted(Comparator.comparing(Cat::getAvgLevel)).toList();
    }

    private void sortByHealth() {
        listOfCats = listOfCats.stream().sorted(Comparator.comparing(Cat::getHealth)).toList();
    }

    private void makeSort(String option) {
        switch (option) {
            case "a":
                sortByName();
                break;
            case "b":
                sortByAge();
                break;
            case "c":
                sortByHealth();
                break;
            case "d":
                sortByMood();
                break;
            case "e":
                sortBySatiety();
                break;
            case "f":
                sortByAvgLevel();
                break;
            default:
                System.out.println("Sorting error!");
                break;
        }
    }
}
