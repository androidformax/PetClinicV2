package ru.petclinic.clients;


import ru.petclinic.clients.pets.Pet;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private final int phoneNumber;
    private String name;
    private List<Pet> pets;

    public Client(String name, int phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.pets = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public void setName(String newName) {
        name = newName;
    }

    public Pet findPet(String namePet) {
        for (Pet pet:pets) {
            if(pet.getName().equals(namePet));
            return pet;
        }
        return null;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public void removePet(Pet pet) {
        pets.remove(pet);
    }

    public List<Pet> getPets() {
        return pets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (phoneNumber != client.phoneNumber) return false;
        return name != null ? name.equals(client.name) : client.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + phoneNumber;
        return result;
    }
 
}
