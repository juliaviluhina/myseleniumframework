package core;

public class TimeoutConditionWaitingException extends RuntimeException {
    public TimeoutConditionWaitingException(String text) {
        super(text);
    }
}
