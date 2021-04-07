package by.vladiyss.sample.exception;

public class IncorrectOrderItemsPersistenceException extends Exception{

    public IncorrectOrderItemsPersistenceException() { }

    public IncorrectOrderItemsPersistenceException(String message) {
        super(message);
    }

    public IncorrectOrderItemsPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectOrderItemsPersistenceException(Throwable cause) {
        super(cause);
    }
}
