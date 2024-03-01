import Classes.AnimalRegistry;
import Exception.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Controller {
    public static Boolean start(AnimalRegistry animalRegistry) throws IOException, InvalidTypeValue, InvalidDateValue, InvalidWeightValue, InvalidIDValue {
        Scanner cs = new Scanner(System.in);
        View.menu();

        int num = cs.nextInt();

        switch (num) {
            case 1 -> {
                Model.inputAnimal(animalRegistry);
            }
            case 2 -> {
                Model.deleteAnimal(animalRegistry);
            }
            case 3 -> {
                Model.learnCommand(animalRegistry);
            }
            case 4 -> {
                Model.readCommand(animalRegistry);
            }
            case 5 -> {
                Model.showAllAnimals(animalRegistry);
            }
            case 0 -> {
                return false;
            }
            default -> View.noThatNumber();
        }
        return true;
    }
}