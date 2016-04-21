package core.conditions;


import core.wrappers.LazyEntity;

public interface Condition<T> extends Matcher<T> {

    T apply(LazyEntity lazyEntity);

}
