package core.conditions;


import core.wrappers.LazyEntity;

public interface EntityCondition<T> {

    T apply(LazyEntity lazyEntity);

}
