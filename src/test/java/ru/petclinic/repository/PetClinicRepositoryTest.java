package ru.petclinic.repository;

import org.junit.Before;
import org.junit.Test;
import ru.petclinic.clients.Client;

import static org.junit.Assert.*;

public class PetClinicRepositoryTest {

    private Repository repository = new PetClinicRepository();

    @Before
    public void init() {
        repository = new PetClinicRepository();
    }

    @Test
    public void saveClient() throws Exception {
        Client client = new Client("SomeClient", 127001);
        repository.saveClient(client);
        Client someClient = repository.findClientByPhoneNumber(127001);

        assertNotNull(someClient);
        assertEquals(client, someClient);
    }

    @Test
    public void removeClient() throws Exception {
        Client client = new Client("SomeClient", 127001);
        repository.saveClient(client);
        Client someClient = repository.findClientByPhoneNumber(127001);
        assertNotNull(someClient);
        assertEquals(client, someClient);

        repository.removeClient(client);
        Client nonExistingClient = repository.findClientByPhoneNumber(127001);
        assertNull(nonExistingClient);
    }
}