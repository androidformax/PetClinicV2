package ru.petclinic.service;

import ru.petclinic.clients.Client;
import ru.petclinic.clients.pets.Cat;
import ru.petclinic.clients.pets.Dog;
import ru.petclinic.clients.pets.Pet;
import ru.petclinic.console.MessageHelper;
import ru.petclinic.repository.PetClinicRepository;
import ru.petclinic.repository.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class ConsoleClinicService implements IConsoleClinicService {

    private Repository clinicRepository;

    public ConsoleClinicService() {
        clinicRepository = new PetClinicRepository();
    }

    @Override
    public void processAddClientMenuItem() {
        MessageHelper.printLine("Введите имя клиента: ");
        String nameClient = MessageHelper.getUserInput();

        MessageHelper.printLine("Введите номер телефона клиента: ");
        int phoneNumber = MessageHelper.getUserNumbersInput();

        Client client = new Client(nameClient, phoneNumber);
        addClient(client);
    }

    @Override
    public void addClient(Client client) {
        clinicRepository.saveClient(client);
    }

    @Override
    public void processAddPetMenuItem() {
        MessageHelper.printLine("Введите телефон клиента, для добавления питомца: ");
        int phoneClientToAddPet = MessageHelper.getUserNumbersInput();
        Client findedClient = clinicRepository.findClientByPhoneNumber(phoneClientToAddPet);

        MessageHelper.printLine("Введите имя питомца: ");
        String namePet = MessageHelper.getUserInput();

        MessageHelper.printLine("Введите тип питомца 1 - Собака, 2 - Кошка: ");
        switch (MessageHelper.getUserNumbersInput()) {
            case 1:
                Dog dog = new Dog(namePet);
                dog.setOwner(findedClient);
                findedClient.addPet(dog);
                break;
            case 2:
                Cat cat = new Cat(namePet);
                cat.setOwner(findedClient);
                findedClient.addPet(cat);
                break;
        }
    }

    @Override
    public void processRemoveClientMenuItem() {
        MessageHelper.printLine("Введите телефон клиента, для удаления: ");
        int phoneClientToRemove = MessageHelper.getUserNumbersInput();

        Client client = getClientByPhoneNumber(phoneClientToRemove);
        removeClient(client);
    }

    @Override
    public Client getClientByPhoneNumber(int phoneNumber) {
        return clinicRepository.findClientByPhoneNumber(phoneNumber);
    }

    @Override
    public void removeClient(Client client) {
        clinicRepository.removeClient(client);
    }

    @Override
    public void processRemovePetMenuItem() {
        MessageHelper.printLine("Введите телефон клиента, для удаления животного: ");
        int phoneClientToRemove = MessageHelper.getUserNumbersInput();

        MessageHelper.printLine("Введите имя животного: ");
        String nameOfPetToRemove = MessageHelper.getUserInput();
        Pet foundPet = null;
        Client client = clinicRepository.findClientByPhoneNumber(phoneClientToRemove);
        if (client != null) {
            for (Pet pet : client.getPets()) {
                if (pet.getName().equals(nameOfPetToRemove)) {
                    foundPet = pet;
                    break;
                }
            }
            if (foundPet != null) {
                client.removePet(foundPet);
                MessageHelper.printLine("Животное удалено.");
            } else if (foundPet == null) {
                MessageHelper.printLine("Вы ввели неверные данные, повторите операцию.");
            }
        }

    }

    @Override
    public void processShowAllClientAndPets() {
        MessageHelper.printLine("Клиенты клиники: ");
        List<Client> findedClients = getAllClients();
        for (Client client : findedClients) {
            MessageHelper.printLine("====================================");
            MessageHelper.printLine(
                    "Клиент: " + client.getName() + "; " +
                            "Номер телефона: " + client.getPhoneNumber() + "; " +
                            "Животные клиента: " + getStringWithPets(client.getPets()));
            MessageHelper.printLine("====================================");
        }
    }

    @Override
    public List<Client> getAllClients() {
        return clinicRepository.getAllClients();
    }

    public String getStringWithPets(List<Pet> pets) {
        return pets.stream().map(Pet::getName).collect(Collectors.joining(", "));
    }

    void setClinicRepository(Repository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    @Override
    public void processFindClientByPhoneNumber() {
        MessageHelper.printLine("Введите телефон клиента: ");
        int phoneClient = MessageHelper.getUserNumbersInput();
        MessageHelper.printLine("Клиент " + phoneClient + " найден: ");
        Client findedClient = clinicRepository.findClientByPhoneNumber(phoneClient);
        MessageHelper.printLine(
                "Клиент: " + findedClient.getName() + "; " +
                        "Номер телефона: " + findedClient.getPhoneNumber() + "; " +
                        "Животные клиента: " + getStringWithPets(findedClient.getPets()));
        MessageHelper.printLine("====================================");
    }

    @Override
    public void processChangeClientName() {
        MessageHelper.printLine("Введите телефон клиента, для изменения его имени: ");
        int phoneClientToChangeName = MessageHelper.getUserNumbersInput();

        MessageHelper.printLine("Введите новое имя клиента: ");
        String newClientName = MessageHelper.getUserInput();
        Client findedClient = clinicRepository.findClientByPhoneNumber(phoneClientToChangeName);
        if (findedClient != null) {
            findedClient.setName(newClientName);

            MessageHelper.printLine("Имя изменено на " + newClientName);
        } else {
            MessageHelper.printLine("Введены не верные данные, попробуйте еще раз.");
        }
    }

    @Override
    public void processChangePetName() {
        MessageHelper.printLine("Введите телефон клиента, для поиска его животного: ");
        int phoneClientToChangePetName = MessageHelper.getUserNumbersInput();

        MessageHelper.printLine("Введите старое имя животного для изменения: ");
        String oldPetName = MessageHelper.getUserInput();

        MessageHelper.printLine("Введите новое имя животного для изменения: ");
        String newPetName = MessageHelper.getUserInput();
        Client findedClient = clinicRepository.findClientByPhoneNumber(phoneClientToChangePetName);

        if (findedClient != null) {
            clinicRepository.changePetName(findedClient, oldPetName, newPetName);
            MessageHelper.printLine("Имя изменено на " + newPetName);
        } else {
            MessageHelper.printLine("Введены не верные данные, попробуйте еще раз.");
        }
    }
}


