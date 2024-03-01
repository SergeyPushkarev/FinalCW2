import Classes.AnimalRegistry;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        AnimalRegistry animalRegistry = new AnimalRegistry();
        animalRegistry.loadAnimals();

        boolean flag = true;
        while (flag) {
            try {
                flag = Controller.start(animalRegistry);
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }
}