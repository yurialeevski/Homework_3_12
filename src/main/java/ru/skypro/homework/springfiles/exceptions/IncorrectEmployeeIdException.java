package ru.skypro.homework.springfiles.exceptions;

public class IncorrectEmployeeIdException extends RuntimeException {
    public IncorrectEmployeeIdException(String message) {
    super(message);
    }
}
