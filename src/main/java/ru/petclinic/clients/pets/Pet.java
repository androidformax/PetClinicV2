package ru.petclinic.clients.pets;

import ru.petclinic.clients.Client;

public abstract class Pet {
    private String petName;
    private Client owner;

    public Pet(String name) {
        this.petName = name;
    }

    public String getName() {
        return this.petName;
    }

    public void setName(String newName) {
        petName = newName;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public abstract String getSound();

    @Override
    public String toString() {
        return "Pet{" +
                "petName='" + petName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pet pet = (Pet) o;

        return petName != null ? petName.equals(pet.petName) : pet.petName == null;
    }

    @Override
    public int hashCode() {
        return petName != null ? petName.hashCode() : 0;
    }


}
