package ru.petclinic.console;

import java.io.*;
import java.util.Optional;

/**
 * Помощник считывания с консоли. Нам не нужен этот класс в качестве объекта,
 * поэтому все методы должны быть статичными.
 * <p>
 * Все операции ввода / выввода должны проходить через этот класс.
 */
public class MessageHelper {

    protected static final String fullMenu;
    private static final MenuItem[] menuItems;

    private static PrintStream printStream;
    private static InputStream inputStream;
    private static BufferedReader br;

    static {
        menuItems = MenuItem.values();
        fullMenu = initializeMenuBuilderWithEnumValues();
        printStream = System.out;
        inputStream = System.in;
        br = new BufferedReader(new InputStreamReader(inputStream));
    }

    private MessageHelper() throws IllegalAccessException {
        throw new IllegalAccessException("Cannot instantiate MessageHelper");
    }

    private static String initializeMenuBuilderWithEnumValues() {
        StringBuilder menuBuilder = new StringBuilder();

        for (int index = 1; index < menuItems.length; index++) {
            MenuItem item = menuItems[index];
            appendToBuilderWith(menuBuilder, index, item.toString());
        }
        menuBuilder.append("------------------").append(System.lineSeparator());
        appendToBuilderWith(menuBuilder, 0, menuItems[0].toString());

        return menuBuilder.toString();
    }

    private static void appendToBuilderWith(StringBuilder builder, int index, String value) {
        builder.append(index).append(". ").append(value).append(System.lineSeparator());
    }

    public static void printMenu() {
        printLine("\n------ Меню ------");
        printLine(fullMenu);
    }

    public static void printLine(String line) {
        printStream.println(line);
    }

    public static MenuItem getUserMenuInput() {
        MessageHelper.printLine("Пожалуйста, выберите один из пунктов меню: ");

        int userInput = getUserNumbersInput();
        if (userInput < 0 || userInput > menuItems.length) {
            return getUserMenuInput();
        }
        printLine("");
        return menuItems[userInput];
    }

    public static int getUserNumbersInput() {
        try {
            return Integer.parseInt(getUserInput());
        } catch (NumberFormatException e) {
            MessageHelper.printLine("Ошибка при распознании введенного числа. Попробуйте еще раз:");
            return getUserNumbersInput();
        }
    }

    public static String getUserInput() {
        Optional<String> userInput = getUserInputOrNull();
        return userInput.orElseGet(MessageHelper::getUserInput);
    }

    private static Optional<String> getUserInputOrNull() {
        try {
            String line = br.readLine();
            return Optional.ofNullable(line);
        } catch (IOException e) {
            return Optional.empty();
        }
    }
}