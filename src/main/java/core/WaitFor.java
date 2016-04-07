package core;

import core.conditions.EntityCondition;
import core.wrappers.LazyEntity;
import org.openqa.selenium.TimeoutException;

import static core.ConciseAPI.sleep;


public class WaitFor {

    private LazyEntity lazyEntity;

    public WaitFor(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
    }

    public static <V> V until(LazyEntity lazyEntity, int timeoutMs, EntityCondition<V>... conditions) {
        return new WaitFor(lazyEntity).until(timeoutMs, conditions);
    }

    public static <V> V until(LazyEntity lazyEntity, EntityCondition<V>... conditions) {
        return until(lazyEntity, Configuration.timeout, conditions);
    }

    public static boolean satisfied(LazyEntity lazyEntity, int timeoutMs, EntityCondition... conditions){
        return new WaitFor(lazyEntity).satisfied(timeoutMs, conditions);
    }

    public <V> V until(int timeoutMs, EntityCondition<V>... conditions) {
        V result = null;
        for (EntityCondition<V> condition : conditions) {
            result = until(timeoutMs, condition);
        }
        return result;
    }

    public <V> V until(int timeoutMs, EntityCondition<V> condition) {
        final long startTime = System.currentTimeMillis();
        do {
            V result = condition.apply(lazyEntity);
            if (result == null) {
                sleep(Configuration.pollingIntervalInMillis);
                continue;
            }
            return result;
        } while (System.currentTimeMillis() - startTime < timeoutMs);

        throw new TimeoutException("\nfailed while waiting " + timeoutMs / 1000 + " seconds" + "\nto assert " + condition);
    }

    public boolean satisfied(int timeoutMs, EntityCondition... conditions) {
        try {
            until(timeoutMs, conditions);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
