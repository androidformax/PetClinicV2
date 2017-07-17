package ru.petclinic.clients.pets;

public class Dog extends Pet {

    public Dog(String petName) {
        super(petName);
    }

    @Override
    public String getSound() {
        return "Гав";
    }
}
