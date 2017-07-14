package ru.petclinic.service;

import ru.petclinic.clients.Client;

import java.util.List;

public interface IClinicService {
    void addClient(Client client);

    void removeClient(Client client);

    Client getClientByPhoneNumber(int phoneNumber);

    List<Client> getAllClients();

}
