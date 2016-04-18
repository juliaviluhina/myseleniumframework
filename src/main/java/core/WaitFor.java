package core;

import core.conditions.Condition;
import core.wrappers.LazyEntity;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;

public class WaitFor {

    private LazyEntity lazyEntity;

    public WaitFor(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
    }

    public static <T> T until(LazyEntity lazyEntity, int timeoutMs, Condition<T>... conditions) {
        return new WaitFor(lazyEntity).until(timeoutMs, conditions);
    }

    public static <T> T until(LazyEntity lazyEntity, Condition<T>... conditions) {
        return until(lazyEntity, Configuration.timeout, conditions);
    }

    public static boolean satisfied(LazyEntity lazyEntity, int timeoutMs, Condition... conditions) {
        return new WaitFor(lazyEntity).satisfied(timeoutMs, conditions);
    }

    public <T> T until(int timeoutMs, Condition<T>... conditions) {
        if (conditions.length == 0) {
            throw new IllegalArgumentException("Conditions are not given");
        }
        T result = null;
        for (Condition<T> condition : conditions) {
            result = until(timeoutMs, condition);
        }
        return result;
    }

    public <T> T until(int timeoutMs, Condition<T> condition) {
        final long startTime = System.currentTimeMillis();
        Throwable lastError;
        do {
            try {
                return condition.apply(lazyEntity);
            } catch (WebDriverException e) {
                lastError = e;
            }
            sleep(Configuration.pollingInterval);
        } while (System.currentTimeMillis() - startTime < timeoutMs);

        throw new TimeoutException("\nfailed while waiting " + timeoutMs / 1000 + " seconds" +
                "\nto assert " + condition, lastError);
    }

    public boolean satisfied(int timeoutMs, Condition... conditions) {
        try {
            until(timeoutMs, conditions);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    private void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
