package core.conditions;


import core.wrappers.LazyEntity;
import org.openqa.selenium.WebDriverException;

public abstract class AbstractCondition<T> implements Condition<T>, DescribesResult {

    private LazyEntity lazyEntity;

    public abstract T check(T entity);

    public T apply(LazyEntity lazyEntity) {
        try {
            this.lazyEntity = lazyEntity;
            T wrappedEntity = (T) lazyEntity.getWrappedEntity();
            if (wrappedEntity == null) {
                return null;
            }
            return check(wrappedEntity);
        } catch (WebDriverException | IndexOutOfBoundsException e) {
            return null;
        }
    }

    public abstract String identity();

    public abstract String actual();

    public abstract String expected();

    public String toString() {
        return getClass().getSimpleName() +
                "\nfor " + identity() + " found by: " + lazyEntity +
                (expected() == "" ? "" : "\nexpected " + expected()) +
                (actual() == "" ? "" : "\nactual " + actual());
    }

}
