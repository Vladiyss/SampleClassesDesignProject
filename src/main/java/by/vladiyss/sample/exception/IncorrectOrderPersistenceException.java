package by.vladiyss.sample.exception;

public class IncorrectOrderPersistenceException extends Exception{

    public IncorrectOrderPersistenceException() { }

    public IncorrectOrderPersistenceException(String message) {
        super(message);
    }

    public IncorrectOrderPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectOrderPersistenceException(Throwable cause) {
        super(cause);
    }
}
