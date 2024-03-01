import Classes.*;
import Exception.*;

import java.io.IOException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Model {
    /**
     *
     * @throws IOException ошибка при открытии/закрытии файла с игрушками
     * @throws InvalidAmountValue ошибка ввода количества игрушки
     * @throws InvalidWinningFrequencyValue ошибка ввода вероятности розыгрыша игрушки
     */
    public static void inputAnimal(AnimalRegistry animalRegistry) throws ParseException {

        Scanner cs = new Scanner(System.in);

        int animalType;
        String animalName;
        Date dateOfBirth;
        int weight;
        String commands;

        View.enteringTypeAnimal();
        animalType = cs.nextInt(); cs.nextLine();

        View.enteringNameAnimal();
        animalName = cs.nextLine();

        View.enteringDateOfBirthAnimal();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        dateOfBirth = df.parse(cs.nextLine());

        View.enteringWeightAnimal();
        weight = cs.nextInt(); cs.nextLine();

        View.enteringCommandsAnimal();
        commands = cs.nextLine();

        switch(animalType) {
            case (1): animalRegistry.addAnimalInList(new Cat(animalName, dateOfBirth, weight, commands)); break;
            case (2): animalRegistry.addAnimalInList(new Dog(animalName, dateOfBirth, weight, commands)); break;
            case (3): animalRegistry.addAnimalInList(new Hamster(animalName, dateOfBirth, weight, commands)); break;
            case (4): animalRegistry.addAnimalInList(new Horse(animalName, dateOfBirth, weight, commands)); break;
            case (5): animalRegistry.addAnimalInList(new Donkey(animalName, dateOfBirth, weight, commands)); break;
            case (6): animalRegistry.addAnimalInList(new Camel(animalName, dateOfBirth, weight, commands)); break;
        }
    }

    public static void deleteAnimal(AnimalRegistry animalRegistry) {

        Scanner cs = new Scanner(System.in);
        View.enteringIDAnimal();

        animalRegistry.deleteAnimal(cs.nextInt()-1);
    }

    public static void showAllAnimals(AnimalRegistry animalRegistry) throws IOException {
        String type = "";
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        View.readCountAnimals(animalRegistry.size());
        for (int i = 0; i < animalRegistry.size(); i++) {
            Animal item = animalRegistry.get(i);
            if (item instanceof Cat) { type = "Кот";
            } else if (item instanceof Dog) { type = "Собака";
            } else if (item instanceof Hamster) { type = "Хомяк";
            } else if (item instanceof Horse) { type = "Лошадь";
            } else if (item instanceof Donkey) { type = "Осел";
            } else if (item instanceof Camel) { type = "Верблюд"; }

            System.out.println(i+1 +
                    ". Имя: " + item.getAnimalName() +
                    "; Дата рождения: " + df.format(item.getDateOfBirth()) +
                    "; Вес: " + item.getWeight() +
                    "; Команды: " + item.getCommands() +
                    "; Тип: " + type);
        }
    }
}