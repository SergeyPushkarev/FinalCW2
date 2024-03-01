import Classes.AnimalRegistry;
import Exception.*;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) {
        AnimalRegistry animalRegistry = new AnimalRegistry();
        try {
            animalRegistry.loadAnimals();
        } catch (ParseException e) {
            System.out.println("Дата введена в некорректном формате!");
        }

        boolean flag = true;
        while (flag) {
            try {
                flag = Controller.start(animalRegistry);
            } catch (InvalidTypeValue e) {
                System.out.println("Номер типа животного должен быть от 1 до 6!");
            } catch (InvalidDateValue e) {
                System.out.println("Дата должна быть в формате MM/dd/yyyy!");
            } catch (InvalidWeightValue e) {
                System.out.println("Вес животного должен состоять только из цифр!");
            } catch (InvalidIDValue e) {
                System.out.println("Идентификатор животного должен состоять только из цифр!");
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }
}