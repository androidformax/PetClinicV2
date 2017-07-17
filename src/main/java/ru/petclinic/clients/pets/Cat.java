package ru.petclinic.clients.pets;

public class Cat extends Pet {

    public Cat(String petName) {
        super(petName);
    }

    @Override
    public String getSound() {
        return "Мяу!";
    }
}
