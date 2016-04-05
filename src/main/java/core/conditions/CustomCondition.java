package core.conditions;


import core.wrappers.LazyEntity;
import org.openqa.selenium.WebDriverException;

public abstract class CustomCondition<V> implements CustomConditionInterface<V> {

    protected LazyEntity lazyEntity;

    public LazyEntity entity() {
        return lazyEntity;
    }

    protected abstract <V> V check(LazyEntity lazyEntity);

    public <V> V apply(LazyEntity lazyEntity) {
        try {
            return check(lazyEntity);
        } catch (WebDriverException | IndexOutOfBoundsException e) {
            return null;
        }
    }

    public String toString() {
        return getClass().getSimpleName() +
                "\nfor " + identity() + " found by: " + entity() +
                (expected() == "" ? "" : "\nexpected " + expected()) +
                (actual() == "" ? "" : "\nactual " + actual());
    }

}
