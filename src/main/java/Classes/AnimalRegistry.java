package Classes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class AnimalRegistry {
    ArrayList<Animal> animalList;

    public AnimalRegistry(ArrayList<Animal> animalList) {
        this.animalList = animalList;
    }

    public AnimalRegistry() {
        this.animalList = new ArrayList<>();
    }

    public void addAnimalInList(Animal animal) {
        this.animalList.add(animal);
    }

    public int size() {
        return animalList.size();
    }

    public Animal get(int i) {
        return animalList.get(i);
    }

    public void loadAnimals() throws ParseException {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        this.animalList.add(new Cat("Stalker", df.parse("05/05/2021"), 1500, "Ко мне"));
        this.animalList.add(new Dog("Yaromila", df.parse("05/05/2018"), 3700, "Ко мне, Сидеть, Лежать"));
        this.animalList.add(new Hamster("Begun", df.parse("12/10/2019"), 300, "Бег, Стойка"));
        this.animalList.add(new Horse("Europa", df.parse("10/25/2019"), 500000, "Хоп, Шагом"));
        this.animalList.add(new Camel("Falkor", df.parse("06/15/2016"), 350000, "Стой, Вперед"));
    }
}
