package ru.petclinic;

import ru.petclinic.console.MenuItem;
import ru.petclinic.console.MessageHelper;

public class ClinicRunner {
    private final PetClinic petClinic;

    private ClinicRunner() {
        this.petClinic = PetClinic.getInstance();
    }

    public static void main(String[] args) {
        new ClinicRunner().run();
    }

    private void run() {
        while (true) {
            MessageHelper.printMenu();
            processMenuItem(MessageHelper.getUserMenuInput());
        }
    }

    private void processMenuItem(MenuItem item) {
        switch (item) {
            case ADD_CLIENT:
                petClinic.processAddClientMenuItem();
                break;
            case ADD_PET:
                petClinic.processAddPetMenuItem();
                break;
            case REMOVE_CLIENT:
                petClinic.processRemoveClientMenuItem();
                break;
            case REMOVE_PET:
                petClinic.processRemovePetMenuItem();
                break;
            case INFO_CLIENTS_AND_PETS:
                petClinic.processShowAllClientAndPets();
                break;
            case FIND_CLIENT:
                petClinic.processFindClientByPhoneNumber();
                break;
            case CHANGE_CLIENT_NAME:
                petClinic.processChangeClientName();
                break;
            case CHANGE_PET_NAME:
                petClinic.processChangePetName();
                break;
            case EXIT:
                exit();
                break;
        }
    }

    private void exit() {
        MessageHelper.printLine("Всего доброго!");
        System.exit(0);
    }
}
