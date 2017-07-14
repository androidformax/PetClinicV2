package ru.petclinic.clients;

import org.junit.BeforeClass;
import org.junit.Test;
import ru.petclinic.clients.pets.Cat;
import ru.petclinic.clients.pets.Dog;
import ru.petclinic.clients.pets.Pet;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;

public class ClientTest {

    private static Client client;

    private static String clientName = "ClientName";
    private static int clientPhoneNumber = 127001;
    private static Pet dog = new Dog("dogPet1");
    private static Cat cat = new Cat("catPet1");

    @BeforeClass
    public static void init() {
        client = new Client(clientName, clientPhoneNumber);
        client.addPet(dog);
        client.addPet(cat);
    }

    @Test
    public void getName() throws Exception {
        String name = client.getName();
        assertNotNull(name);
        assertEquals(clientName, name);
    }

    @Test
    public void getPhoneNumber() throws Exception {
        int phoneNumber = client.getPhoneNumber();
        assertNotNull(phoneNumber);
        assertEquals(clientPhoneNumber, phoneNumber);
    }

    @Test
    public void getPets() throws Exception {
        List<Pet> pets = client.getPets();
        assertTrue(pets.size() > 0);
        assertThat(pets, hasItems(dog, cat));
    }

    @Test
    public void addPet() throws Exception {
        int petsSize = client.getPets().size();
        client.addPet(new Dog("SomeDog"));
        int newPetsSize = client.getPets().size();

        assertTrue(petsSize > 0);
        assertTrue(newPetsSize > petsSize);
        assertEquals(petsSize, newPetsSize - 1);
    }

    @Test
    public void removePet() throws Exception {
        int petsSize = client.getPets().size();
        client.removePet(cat);
        int newPetsSize = client.getPets().size();

        assertTrue(petsSize > 0);
        assertTrue(newPetsSize < petsSize);
        assertThat(client.getPets(), hasItems(dog));
    }

    @Test
    public void testEqualsAndHashCode() {
        Client client1 = new Client("SomeClient1", 127005);
        Client client2 = new Client("CLIENT", 127001);
        Client client3 = new Client("CLIENT", 127001);

        assertFalse(client1.equals(client3));
        assertFalse(client1.hashCode() == client3.hashCode());

        assertTrue(client2.equals(client3));
        assertTrue(client2.hashCode() == client3.hashCode());
    }
}