package ru.petclinic;

import ru.petclinic.service.ConsoleClinicService;
import ru.petclinic.service.IConsoleClinicService;

/**
 * @author Cargeh
 */
public class PetClinic {
    protected static int staticInstanceCounter = 0;
    private static PetClinic instance;
    private final IConsoleClinicService clinicService = new ConsoleClinicService();
    private int instanceCounter = staticInstanceCounter++;

    private PetClinic() {
    }

    public static PetClinic getInstance() {
        if (instance == null) {
            instance = new PetClinic();
        }
        return instance;
    }

    public void processAddClientMenuItem() {
        clinicService.processAddClientMenuItem();
    }

    public void processAddPetMenuItem() {
        clinicService.processAddPetMenuItem();
    }

    public void processRemoveClientMenuItem() {
        clinicService.processRemoveClientMenuItem();
    }

    public void processRemovePetMenuItem() {
        clinicService.processRemovePetMenuItem();
    }

    public void processShowAllClientAndPets() {
        clinicService.processShowAllClientAndPets();
    }

    public void processFindClientByPhoneNumber() {
        clinicService.processFindClientByPhoneNumber();
    }

    public void processChangeClientName() {
        clinicService.processChangeClientName();
    }

    public void processChangePetName() {
        clinicService.processChangePetName();
    }
}

