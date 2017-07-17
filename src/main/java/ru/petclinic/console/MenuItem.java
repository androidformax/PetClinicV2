package ru.petclinic.console;

public enum MenuItem {

    EXIT("Выйти из приложения."),
    ADD_CLIENT("Добавить клиента."),
    ADD_PET("Добавить питомца."),
    FIND_CLIENT("Найти клиента по номеру телефона."),
    REMOVE_CLIENT("Удалить клиента."),
    REMOVE_PET("Удалить питомца."),
    CHANGE_CLIENT_NAME("Изменить имя клиента."),
    CHANGE_PET_NAME("Изменить имя питомца."),
    INFO_CLIENTS_AND_PETS("Отобразить список клиентов и их питомцев.");

    private String item;

    MenuItem(String item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return item;
    }
}
