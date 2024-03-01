package Classes;

import java.util.Date;

public abstract class Animal {
    String animalName;
    Date dateOfBirth;
    Integer weight;
    String commands;

    public Animal(String animalName, Date dateOfBirth, Integer weight, String commands) {
        this.animalName = animalName;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.commands = commands;
    }

    public String getAnimalName() {
        return animalName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Integer getWeight() {
        return weight;
    }

    public String getCommands() {
        return commands;
    }

    public void learnCommand(String command) {
        if (!this.commands.isEmpty()) {
            this.commands = this.commands + ", ";
        }
        this.commands = this.commands + command;
    }
}