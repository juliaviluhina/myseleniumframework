package core.wrappers.collection;

import core.conditions.CustomCollectionCondition;
import core.conditions.CustomElementCondition;
import core.wrappers.*;
import core.wrappers.element.LazyCollectionElementByCondition;
import core.wrappers.element.LazyCollectionElementByIndex;
import core.wrappers.element.LazyElement;
import core.wrappers.element.LazyWrappedWebElement;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import core.WaitFor;


public abstract class LazyCollection implements LazyEntity, Iterable<LazyElement> {

    public abstract List<WebElement> getWrappedEntity();

    public LazyCollectionElementByCondition find(CustomElementCondition condition) {
        return new LazyCollectionElementByCondition(this, condition);
    }

    public LazyFilteredCollection filter(CustomElementCondition condition) {
        return new LazyFilteredCollection(this, condition);
    }

    public LazyCollectionElementByIndex get(int index) {
        return new LazyCollectionElementByIndex(this, index);
    }

    public LazyCollection should(CustomCollectionCondition... conditions) {
        WaitFor.until(this, conditions);
        return this;
    }

    public LazyCollection shouldBe(CustomCollectionCondition... conditions) {
        return should(conditions);
    }

    public LazyCollection shouldHave(CustomCollectionCondition... conditions) {
        return should(conditions);
    }

    public int size() {
        return getWrappedEntity().size();
    }

    public boolean isEmpty() {
        return getWrappedEntity().isEmpty();
    }

    private List<LazyElement> getListOfWrappedElements() {
        List<LazyElement> list = new ArrayList<>();
        for (WebElement element : getWrappedEntity())
            list.add(new LazyWrappedWebElement(this, element));
        return list;
    }

    public Iterator<LazyElement> iterator() {
        return getListOfWrappedElements().iterator();
    }

}


