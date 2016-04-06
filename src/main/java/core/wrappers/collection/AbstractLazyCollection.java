package core.wrappers.collection;

import core.conditions.CollectionCondition;
import core.conditions.ElementCondition;
import core.wrappers.*;
import core.wrappers.element.LazyCollectionFoundByConditionElement;
import core.wrappers.element.LazyCollectionNthElement;
import core.wrappers.element.AbstractLazyElement;
import core.wrappers.element.LazyWrappedWebElement;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import core.WaitFor;


public abstract class AbstractLazyCollection implements LazyEntity, Iterable<AbstractLazyElement> {

    public abstract List<WebElement> getWrappedEntity();

    public LazyCollectionFoundByConditionElement find(ElementCondition condition) {
        return new LazyCollectionFoundByConditionElement(this, condition);
    }

    public LazyFilteredCollection filter(ElementCondition condition) {
        return new LazyFilteredCollection(this, condition);
    }

    public LazyCollectionNthElement get(int index) {
        return new LazyCollectionNthElement(this, index);
    }

    public AbstractLazyCollection should(CollectionCondition... conditions) {
        WaitFor.until(this, conditions);
        return this;
    }

    public AbstractLazyCollection shouldBe(CollectionCondition... conditions) {
        return should(conditions);
    }

    public AbstractLazyCollection shouldHave(CollectionCondition... conditions) {
        return should(conditions);
    }

    public int size() {
        return getWrappedEntity().size();
    }

    public boolean isEmpty() {
        return getWrappedEntity().isEmpty();
    }

    public Iterator<AbstractLazyElement> iterator() {
        List<AbstractLazyElement> list = new ArrayList<>();
        for (WebElement element : getWrappedEntity()) {
            list.add(new LazyWrappedWebElement(this, element));
        }
        return list.iterator();
    }

}


