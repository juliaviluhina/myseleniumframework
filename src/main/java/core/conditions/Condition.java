package core.conditions;


import core.wrappers.LazyEntity;

public interface Condition<V> {

    V apply(LazyEntity lazyEntity);

    String identity();

    String actual();

    String expected();

    LazyEntity entity();

}
