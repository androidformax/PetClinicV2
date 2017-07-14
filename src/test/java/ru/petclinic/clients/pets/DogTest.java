package ru.petclinic.clients.pets;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DogTest {

    private static Dog dog;

    @BeforeClass
    public static void init() {
        dog = new Dog("SomeDog");
    }

    @Test
    public void testName() {
        assertEquals("SomeDog", dog.getName());
    }

    @Test
    public void produceSound() throws Exception {
        assertNotNull(dog.getSound());
    }
}