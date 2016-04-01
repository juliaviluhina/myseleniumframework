package core;

import core.conditions.CustomCollectionCondition;
import core.conditions.CustomCondition;
import core.wrappers.LazyEntity;
import org.openqa.selenium.WebDriverException;

import static core.ConciseAPI.sleep;


public class ConditionWaiter {

    private LazyEntity lazyEntity;

    public ConditionWaiter(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
    }

    public static <V> V waitFor(LazyEntity lazyEntity, int timeoutMs, CustomCondition<V>... conditions) {
        return new ConditionWaiter(lazyEntity).waitFor(timeoutMs, conditions);
    }

    public static <V> V waitFor(LazyEntity lazyEntity, CustomCondition<V>... conditions) {
        return waitFor(lazyEntity, Configuration.timeout, conditions);
    }

    public static <V> V applyWithExceptionsCatching(LazyEntity lazyEntity, CustomCondition<V> condition) {
        return new ConditionWaiter(lazyEntity).applyWithExceptionsCatching(condition);
    }


    public <V> V waitFor(int timeoutMs, CustomCondition<V>... conditions) {
        V result = null;
        for (CustomCondition<V> condition : conditions) {
            result = waitForWithoutException(timeoutMs, condition);
            if (result == null)
                throw new TimeoutConditionWaitingException(getDescriptionException(condition, lazyEntity));
        }
        return result;
    }

    public <V> V waitForWithoutException(int timeoutMs, CustomCondition<V> condition) {
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

    public <V> V applyWithExceptionsCatching(CustomCondition<V> condition) {
        try {
            return condition.apply(lazyEntity);
        } catch (WebDriverException e) {
            return null;
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    private String getDescriptionException(CustomCondition condition, LazyEntity lazyEntity) {
        return "\nFor " + ((condition instanceof CustomCollectionCondition) ? "elements" : "element") +
                " located by " + lazyEntity + "\n" +
                condition.toString() +
                (condition.getActualValuesDescription() == "" ? "" : "\nwhile actual is: " + condition.getActualValuesDescription());
    }

}
