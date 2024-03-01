import Classes.AnimalRegistry;
import Exception.*;

import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        AnimalRegistry animalRegistry = new AnimalRegistry();
        animalRegistry.loadAnimals();

        boolean flag = true;
        while (flag) {
            try {
                flag = Controller.start(animalRegistry);
            } catch (InvalidWinningFrequencyValue e) {
                System.out.println("При вводе вероятности розыгрыша введены не только цифры!");
            } catch (IOException e) {
                System.out.println("Ошибка при открытии JSON файла с игрушками1");
            } catch (InvalidAmountValue e) {
                System.out.println("При вводе количества введены не только цифры!");
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }
}