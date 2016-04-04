package core;

import core.conditions.CustomConditionInterface;
import core.wrappers.LazyEntity;
import org.openqa.selenium.WebDriverException;

import static core.ConciseAPI.sleep;


public class WaitFor {

    private LazyEntity lazyEntity;

    public WaitFor(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
    }

    public static <V> V waitFor(LazyEntity lazyEntity, int timeoutMs, CustomConditionInterface<V>... conditions) {
        return new WaitFor(lazyEntity).until(timeoutMs, conditions);
    }

    public static <V> V waitFor(LazyEntity lazyEntity, CustomConditionInterface<V>... conditions) {
        return waitFor(lazyEntity, Configuration.timeout, conditions);
    }

    public static <V> V applyWithExceptionsCatching(LazyEntity lazyEntity, CustomConditionInterface<V> condition) {
        return new WaitFor(lazyEntity).applyWithExceptionsCatching(condition);
    }


    public <V> V until(int timeoutMs, CustomConditionInterface<V>... conditions) {
        V result = null;
        for (CustomConditionInterface<V> condition : conditions) {
            result = untilWithoutException(timeoutMs, condition);
            if (result == null)
                throw new TimeoutException(condition, timeoutMs);
        }
        return result;
    }

    public <V> V untilWithoutException(int timeoutMs, CustomConditionInterface<V> condition) {
        final long startTime = System.currentTimeMillis();
        do {
            V results = applyWithExceptionsCatching(condition);
            if (results == null) {
                sleep(Configuration.pollingIntervalInMillis);
                continue;
            }
            return results;
        }
        while (System.currentTimeMillis() - startTime < timeoutMs);
        return null;
    }

    public <V> V applyWithExceptionsCatching(CustomConditionInterface<V> condition) {
        try {
            return condition.apply(lazyEntity);
        } catch (WebDriverException|IndexOutOfBoundsException e) {
            return null;
        }
    }

}
