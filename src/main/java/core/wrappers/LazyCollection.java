package core.wrappers;

import core.conditions.CustomCollectionCondition;
import core.conditions.CustomElementCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

import static core.ConciseAPI.getDriver;
import static core.WaitFor.waitFor;

public class LazyCollection implements LazyEntity, Iterable<LazyElement> {

    protected By locator;

    public LazyCollection(By locator) {
        this.locator = locator;
    }

    protected LazyCollection() {
    }

    public String toString() {
        return locator.toString();
    }

    public List<WebElement> getWrappedEntity() {
        return getDriver().findElements(locator);
    }

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
        waitFor(this, conditions);
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
        for (WebElement element:getWrappedEntity())
            list.add(new LazyWrappedWebElement(this, element));
        return list;
    }

    public Iterator<LazyElement> iterator() {
        return getListOfWrappedElements().iterator();
    }

}


