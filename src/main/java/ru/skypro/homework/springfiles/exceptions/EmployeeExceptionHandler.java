package ru.skypro.homework.springfiles.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.sql.SQLException;
@RestControllerAdvice
public class EmployeeExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<?> handleIOException(IOException ioException) {
        // Возвращает статус 404 (Not Found) при возникновении IOException.
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<?> handleSQLException(SQLException sqlException) {
        // Возвращает статус 500 (Internal Server Error)
        // при возникновении SQLException.
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler
    public ResponseEntity<?> handleException(Exception exception) {
        // Возвращает статус 403 (Forbidden) при возникновении Exception.
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler
    public ResponseEntity<?> handleException(IncorrectEmployeeIdException idException) {
        // Возвращает статус 404 (NOT_FOUND) при возникновении IncorrectEmployeeException.
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
/*#######################################################################
@RestControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handleIOException(IOException ioException) {
        String message = "Введен некорректный ID";
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleSQLException(SQLException sqlException) {
        String message = "Во время выполнения запроса произошла ошибка на сервере";
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleException(Exception exception) {
        String message = "URL неверный или такого действия нет в веб-приложении";
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
}
 ########################################################################*/