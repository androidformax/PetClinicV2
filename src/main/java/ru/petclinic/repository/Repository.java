package ru.petclinic.repository;

import ru.petclinic.clients.Client;

import java.util.List;

public interface Repository {

    void saveClient(Client client);

    void removeClient(Client client);

    void changeClientName(Client Client, String newName);

    void changePetName(Client client, String oldPetName, String newPetName);

    Client findClientByPhoneNumber(int number);

    List<Client> getAllClients();

}
