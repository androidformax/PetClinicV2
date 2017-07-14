package ru.petclinic.console;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MessageHelperTest {

    private ByteArrayOutputStream outputStream;
    private ByteArrayInputStream inputStream;

    @Before
    public void init() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        inputStream = new ByteArrayInputStream(new byte[10000]);
        System.setIn(System.in);
    }

    @Test(expected = IllegalAccessException.class)
    public void checkConstructorInitialization() throws Exception {
        Class.forName("ru.petclinic.console.MessageHelper").newInstance();
    }

    @Test
    public void printLine() throws Exception {
        String line = "SomeLine" + System.lineSeparator();
        MessageHelper.printLine("SomeLine");
        assertEquals(line, outputStream.toString());
    }

    @Ignore
    @Test
    public void testPrintMenu() {
        MessageHelper.printMenu();

        String menuFromConsole = outputStream.toString();
        String actualMenu = MessageHelper.fullMenu + System.lineSeparator();
        assertEquals(actualMenu, menuFromConsole);
    }
}