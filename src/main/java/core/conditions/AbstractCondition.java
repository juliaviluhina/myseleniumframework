package core.conditions;


import core.wrappers.LazyEntity;
import org.openqa.selenium.WebDriverException;

public abstract class AbstractCondition<V> implements Condition<V> {

    protected LazyEntity lazyEntity;
    protected V wrappedEntity;

    public LazyEntity entity() {
        return lazyEntity;
    }

    protected abstract <V> V check();

    private void setLazyEntity(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        wrappedEntity = (V) lazyEntity.getWrappedEntity();
    }

    public <V> V apply(LazyEntity lazyEntity) {
        try {
            setLazyEntity(lazyEntity);
            return check();
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
