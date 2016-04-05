package core;

import core.conditions.CustomConditionInterface;
import core.wrappers.LazyEntity;

import static core.ConciseAPI.sleep;


public class WaitFor {

    private LazyEntity lazyEntity;

    public WaitFor(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
    }

    public static <V> V until(LazyEntity lazyEntity, int timeoutMs, CustomConditionInterface<V>... conditions) {
        return new WaitFor(lazyEntity).until(timeoutMs, conditions);
    }

    public static <V> V until(LazyEntity lazyEntity, CustomConditionInterface<V>... conditions) {
        return until(lazyEntity, Configuration.timeout, conditions);
    }


    public <V> V until(int timeoutMs, CustomConditionInterface<V>... conditions) {
        V result = null;
        for (CustomConditionInterface<V> condition : conditions) {
            result = is(timeoutMs, condition);
            if (result == null)
                throw new TimeoutException(condition, timeoutMs);
        }
        return result;
    }

    public <V> V is(int timeoutMs, CustomConditionInterface<V> condition) {
        final long startTime = System.currentTimeMillis();
        do {
            V results = condition.apply(lazyEntity);
            if (results == null) {
                sleep(Configuration.pollingIntervalInMillis);
                continue;
            }
            return results;
        }
        while (System.currentTimeMillis() - startTime < timeoutMs);
        return null;
    }


}
