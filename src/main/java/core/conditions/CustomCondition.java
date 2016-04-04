package core.conditions;


import core.wrappers.LazyEntity;

public abstract class CustomCondition<V> implements CustomConditionInterface<V> {

    protected LazyEntity lazyEntity;

    public LazyEntity entity() {
        return lazyEntity;
    }

    public String toString() {
        return getClass().getSimpleName() +
                "\nfor " + identity() + " found by: " + entity() +
                (expected() == "" ? "" : "\nexpected " + expected()) +
                (actual() == "" ? "" : "\nactual " + actual());
    }
}
