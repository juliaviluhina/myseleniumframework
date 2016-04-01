package core.wrappers;

import core.conditions.CustomCollectionCondition;
import core.conditions.CustomElementCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static core.ConciseAPI.getDriver;
import static core.ConditionWaiter.waitFor;
import static core.conditions.CustomCollectionConditions.minimumSize;

public class LazyCollection implements LazyEntity {

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
        waitFor(this, minimumSize(index + 1));
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

}


