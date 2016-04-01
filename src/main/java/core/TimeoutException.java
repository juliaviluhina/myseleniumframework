package core;

public class TimeoutException extends RuntimeException {
    public TimeoutException(String text) {
        super(text);
    }
}
