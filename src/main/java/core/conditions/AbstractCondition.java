package core.conditions;


import core.wrappers.LazyEntity;
import org.openqa.selenium.WebDriverException;

public abstract class AbstractCondition<T> implements Condition<T> {

    protected LazyEntity lazyEntity;

    public LazyEntity entity() {
        return lazyEntity;
    }

    protected abstract T check(T entity);

    public T apply(LazyEntity lazyEntity) {
        try {
            this.lazyEntity = lazyEntity;
            return check((T) lazyEntity.getWrappedEntity());
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
