import Classes.*;
import Exception.*;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Model {
    private static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
    private static Boolean onlyNumbersInLine(String string) throws CustomInvalidValue {
        for(int i = 0; i < string.length(); i++) {
            if(!Character.isDigit(string.charAt(i))) {
                throw new CustomInvalidValue("Введены запрещенные символы (должны быть только цифры)");
            }
        }
        return true;
    }

    /**
     *
     * @throws IOException ошибка при открытии/закрытии файла с игрушками
     * @throws InvalidAmountValue ошибка ввода количества игрушки
     * @throws InvalidWinningFrequencyValue ошибка ввода вероятности розыгрыша игрушки
     */
    public static void inputAnimal(AnimalRegistry animalRegistry) throws IOException, InvalidAmountValue, InvalidWinningFrequencyValue, ParseException {

        Scanner cs = new Scanner(System.in);

        int animalType;
        String animalName;
        Date dateOfBirth;
        int weight;
        String commands;

        View.enteringValue("тип животного от 1-6 (1-кот, 2-собака, 3-хомяк, 4-лошадь, 5-осел, 6-верблюд)");
        animalType = cs.nextInt(); cs.nextLine();

        View.enteringValue("имя");
        animalName = cs.nextLine();

        View.enteringValue("дату рождения в формате MM/dd/yyyy");
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        dateOfBirth = df.parse(cs.nextLine());

        View.enteringValue("вес в граммах");
        weight = cs.nextInt(); cs.nextLine();

        View.enteringValue("команды животного через запятую:");
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
    public static void recordWonToy(String keyWinner, String dir, Map<String, String> toyValue) throws IOException {
        final String fileName = "ToysForDelivery.Json";

        String fileInString = readFile(dir + fileName, StandardCharsets.UTF_8);

        /*JSONObject jsonObject = (JSONObject) JSONValue.parseWithException(fileInString);
        JSONObject foundToy = (JSONObject) jsonObject.get(keyWinner);

        if (foundToy == null) {
            foundToy = new JSONObject();
            foundToy.put("name", toyValue.get("name"));
            foundToy.put("amount", "1");
            foundToy.put("winningFrequency", toyValue.get("winningFrequency"));
        } else {
            String oldAmount = foundToy.get("amount").toString();

            foundToy.put("amount", String.valueOf(Integer.parseInt(oldAmount)+1));
        }
        jsonObject.put(keyWinner, foundToy);
        */

        try(FileWriter writer = new FileWriter(dir + fileName, false))
        {
            //writer.write(jsonObject.toString());
        } catch (IOException e) {
            throw new IOException();
        }
    }
    public static void writeDownSubtractionOfToy(String keyWinner, String dir, String fileName) throws IOException {
        String fileInString = readFile(dir + fileName, StandardCharsets.UTF_8);

        /*
        JSONObject jsonObject = (JSONObject) JSONValue.parseWithException(fileInString);
        JSONObject foundToy = (JSONObject) jsonObject.get(keyWinner);

        String oldAmount = foundToy.get("amount").toString();

        foundToy.put("amount", String.valueOf(Integer.parseInt(oldAmount)-1));
        jsonObject.put(keyWinner, foundToy);
        */

        try(FileWriter writer = new FileWriter(dir + fileName, false))
        {
            //writer.write(jsonObject.toString());
        } catch (IOException e) {
            throw new IOException();
        }
    }
    public static void playToy() throws IOException {
        final String dir = System.getProperty("user.dir") + "\\src\\main\\java\\";
        final String fileName = "Toys.Json";
        //Gson gson = new Gson();

        String fileInString = readFile(dir + fileName, StandardCharsets.UTF_8);

        /*Type type = new TypeToken<Map<String, Map<String, String>>>(){}.getType();
        Map<String, Map<String, String>> mapToys = gson.fromJson(fileInString, type);

        Map<String, Integer> mapToysLimit = new LinkedHashMap<>();
        int prevTopLimit = 0;

        for (var entry : mapToys.entrySet()) {
            if (prevTopLimit == 0) {
                mapToysLimit.put(entry.getKey(), Integer.parseInt(entry.getValue().get("winningFrequency")));
            } else {
                mapToysLimit.put(entry.getKey(), prevTopLimit + Integer.parseInt(entry.getValue().get("winningFrequency")));
            }

            prevTopLimit = mapToysLimit.get(entry.getKey());
        }

        String keyWinner = "";
        Random random = new Random();
        int randomInt = random.nextInt(0, prevTopLimit);

        for (var entry : mapToysLimit.entrySet()) {
           if (randomInt < entry.getValue()) {
               keyWinner = entry.getKey();
               break;
           }
        }

        View.youWonAToy(mapToys.get(keyWinner).get("name"));
        recordWonToy(keyWinner, dir, mapToys.get(keyWinner));
        writeDownSubtractionOfToy(keyWinner, dir, fileName);*/
    }
    public static void showAllAnimals(AnimalRegistry animalRegistry) throws IOException {
        String type = "";
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        System.out.println("Всего животных: " + animalRegistry.size());
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