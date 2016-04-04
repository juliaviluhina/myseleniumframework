package core;

import core.conditions.CustomConditionInterface;
import core.wrappers.LazyEntity;

public class TimeoutException extends RuntimeException {
    private CustomConditionInterface condition;
    private int timeoutMs;

    public TimeoutException(CustomConditionInterface condition, int timeoutMs) {
        super();
        this.condition = condition;
        this.timeoutMs = timeoutMs;
    }


    public String toString() {
        return "\nfailed while waiting " + timeoutMs / 1000 + " seconds" +
                "\nto assert " + condition;
    }
}
