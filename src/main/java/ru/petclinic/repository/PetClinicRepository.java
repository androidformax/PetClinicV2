package ru.petclinic.repository;

import ru.petclinic.clients.Client;
import ru.petclinic.clients.pets.Pet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PetClinicRepository implements Repository {
    private final Map<Integer, Client> clientMap = new HashMap<>();

    @Override
    public void saveClient(Client client) {
        clientMap.put(client.getPhoneNumber(), client);
    }

    @Override
    public void removeClient(Client client) {
        clientMap.remove(client.getPhoneNumber());
    }

    @Override
    public Client findClientByPhoneNumber(int phoneNumber) {
        return clientMap.get(phoneNumber);
    }

    @Override
    public void changeClientName(Client client, String newName) {
        client.setName(newName);
    }

    @Override
    public void changePetName(Client client, String oldPetName, String newPetName) {
        Pet pet = client.findPet(oldPetName);
        pet.setName(newPetName);
    }

    @Override
    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        clients.addAll(clientMap.values());
        return clients;
    }
}
