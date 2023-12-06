package aoc2023.data.exception;

public class DataLoadingException extends RuntimeException {
    public DataLoadingException(String message, Throwable cause) {
        super(message, cause);
    }
}
