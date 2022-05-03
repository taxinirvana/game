package ru.netology;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException() {
        super("Игрок не зарегистрирован");
    }
}


