package core.conditions;


import core.wrappers.LazyEntity;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriverException;

public abstract class AbstractCondition<T> implements Condition<T>, DescribesResult {

    private LazyEntity lazyEntity;

    public abstract boolean check(T entity);

    public T apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        T wrappedEntity = (T) lazyEntity.getWrappedEntity();
        if(!check(wrappedEntity)) {
            throw new NotFoundException(toString());
        }
        return wrappedEntity;
    }

    public String toString() {
        return getClass().getSimpleName() +
                "\nfor " + identity() + " found by: " + lazyEntity +
                (expected() == "" ? "" : "\nexpected " + expected()) +
                (actual() == "" ? "" : "\nactual " + actual());
    }



}
