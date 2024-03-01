public class View {
    public static void menu() {
        System.out.println("\nМеню реестра животных. Выберите действие: \n" +
                "1. Добавить животное. \n" +
                "2. Удалить животное. \n" +
                "3. Выучить новую команду. \n" +
                "4. Посмотреть команды животного. \n" +
                "5. Вывести список животных. \n" +
                "0. Выход. \n");
    }
    public static void noThatNumber() {
        System.out.println("Такого номера в меню нет!");
    }

    public static void enteringTypeAnimal() {
        System.out.println("Введите тип животного от 1-6 (1-кот, 2-собака, 3-хомяк, 4-лошадь, 5-осел, 6-верблюд): ");
    }

    public static void enteringNameAnimal() {
        System.out.println("Ведите имя: ");
    }

    public static void enteringDateOfBirthAnimal() {
        System.out.println("Введите дату рождения в формате MM/dd/yyyy: ");
    }

    public static void enteringWeightAnimal() {
        System.out.println("Введите вес в граммах: ");
    }

    public static void enteringCommandsAnimal() {
        System.out.println("Введите команды животного через запятую: ");
    }

    public static void enteringIDAnimal() {
        System.out.println("Введите идентификатор животного: ");
    }

    public static void readCountAnimals(int size) {
        System.out.println("Всего животных: " + size);
    }

    public static void readCommandsAnimal(String commands) {
        System.out.println("Выбранное животное умеет: " + commands);
    }
}
