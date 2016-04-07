package core.conditions;


import core.wrappers.LazyEntity;
import org.openqa.selenium.WebDriverException;

public abstract class EntityCondition<T> implements Condition<T> {

    protected LazyEntity lazyEntity;

    protected abstract T check(T entity);

    public T apply(LazyEntity lazyEntity) {
        try {
            this.lazyEntity = lazyEntity;
            return check((T) lazyEntity.getWrappedEntity());
        } catch (WebDriverException | IndexOutOfBoundsException e) {
            return null;
        }
    }

    protected abstract String identity();

    protected abstract String actual();

    protected abstract String expected();

    public String toString() {
        return getClass().getSimpleName() +
                "\nfor " + identity() + " found by: " + lazyEntity +
                (expected() == "" ? "" : "\nexpected " + expected()) +
                (actual() == "" ? "" : "\nactual " + actual());
    }

}
