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
    public static void enterID() {
        System.out.println("\nВведите ID существующей игрушки, для ее удаления: ");
    }
    public static void toyNotFound(String id) {
        System.out.println("Игрушка с идентификатором [" + id + "] не была найдена. Заполните поля для новой игрушки далее.");
    }
    public static void toyFound(String id) {
        System.out.println("Игрушка с идентификатором [" + id + "] была найдена. Измените необходимые поля далее.");
    }
    public static void enteringValue(String type) {
        System.out.println("Введите " + type + ":");
    }
    public static void noThatNumber() {
        System.out.println("Такого номера в меню нет!");
    }
}
