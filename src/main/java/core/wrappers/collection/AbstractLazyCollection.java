package core.wrappers.collection;

import core.conditions.CollectionCondition;
import core.conditions.ElementCondition;
import core.wrappers.*;
import core.wrappers.element.LazyCollectionFoundByConditionElement;
import core.wrappers.element.LazyCollectionNthElement;
import core.wrappers.element.LazyWrappedWebElement;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import core.WaitFor;


public abstract class AbstractLazyCollection implements LazyCollection {

    public LazyElement find(ElementCondition condition) {
        return new LazyCollectionFoundByConditionElement(this, condition);
    }

    public LazyCollection filter(ElementCondition condition) {
        return new LazyFilteredCollection(this, condition);
    }

    public LazyElement get(int index) {
        return new LazyCollectionNthElement(this, index);
    }

    public LazyCollection should(CollectionCondition... conditions) {
        WaitFor.until(this, conditions);
        return this;
    }

    public LazyCollection shouldBe(CollectionCondition... conditions) {
        return should(conditions);
    }

    public LazyCollection shouldHave(CollectionCondition... conditions) {
        return should(conditions);
    }

    public int size() {
        return getWrappedEntity().size();
    }

    public boolean isEmpty() {
        return getWrappedEntity().isEmpty();
    }

    public Iterator<LazyElement> iterator() {
        List<LazyElement> list = new ArrayList<>();
        for (WebElement element : getWrappedEntity()) {
            list.add(new LazyWrappedWebElement(this, element));
        }
        return list.iterator();
    }

    public String[] getTexts() {
        List<String> texts = new ArrayList<>();
        List<WebElement> elements = getWrappedEntity();
        for (WebElement element : elements) {
            texts.add(element.getText());
        }
        return texts.toArray(new String[0]);
    }

}


