package ru.petclinic.service;

/**
 * Created by andro on 05.07.2017.
 */
public interface IConsoleClinicService extends IClinicService {
    void processAddClientMenuItem();

    void processAddPetMenuItem();

    void processRemoveClientMenuItem();

    void processRemovePetMenuItem();

    void processShowAllClientAndPets();

    void processFindClientByPhoneNumber();

    void processChangeClientName();

    void processChangePetName();
}
