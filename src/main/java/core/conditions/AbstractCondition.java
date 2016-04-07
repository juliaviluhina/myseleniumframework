package core.conditions;


import core.wrappers.LazyEntity;
import org.openqa.selenium.WebDriverException;

public abstract class AbstractCondition<V> implements Condition<V> {

    protected LazyEntity lazyEntity;

    public LazyEntity entity() {
        return lazyEntity;
    }

    protected abstract V check(V entity);

    public V apply(LazyEntity lazyEntity) {
        try {
            this.lazyEntity = lazyEntity;
            return check((V) lazyEntity.getWrappedEntity());
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
