package ru.petclinic.clients.pets;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CatTest {
    private static Cat cat;

    @BeforeClass
    public static void init() {
        cat = new Cat("SomeCat");
    }

    @Test
    public void testName() {
        assertEquals("SomeCat", cat.getName());
    }

    @Test
    public void produceSound() throws Exception {
        assertNotNull(cat.getSound());
    }

}