package ru.petclinic.service;

import org.junit.Before;
import org.junit.Test;
import ru.petclinic.clients.Client;
import ru.petclinic.clients.pets.Dog;
import ru.petclinic.clients.pets.Pet;
import ru.petclinic.repository.PetClinicRepository;

import static org.mockito.Mockito.*;

public class ClinicServiceTest {

    private static Client client = new Client("SomeClient", 127001);
    private static Pet pet = new Dog("SomePet");

    private ConsoleClinicService service;
    private PetClinicRepository repository;

    @Before
    public void init() {
        service = new ConsoleClinicService();
        repository = mock(PetClinicRepository.class);
        service.setClinicRepository(repository);
    }

    @Test
    public void addClient() throws Exception {
        service.addClient(client);
        verify(repository, times(1)).saveClient(client);
    }

    @Test
    public void getClientByName() throws Exception {
        service.getClientByPhoneNumber(127001);
        verify(repository, times(1)).findClientByPhoneNumber(127001);
    }

    @Test
    public void getAllClients() throws Exception {
        service.getAllClients();
        verify(repository, times(1)).getAllClients();
    }
}