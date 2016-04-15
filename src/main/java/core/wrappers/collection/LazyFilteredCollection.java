package core.wrappers.collection;

import core.conditions.ElementCondition;
import core.wrappers.LazyCollection;
import core.wrappers.element.LazyWrappedWebElement;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class LazyFilteredCollection extends AbstractLazyCollection {

    private ElementCondition condition;
    private LazyCollection parentCollection;

    public LazyFilteredCollection(LazyCollection parentCollection, ElementCondition condition) {
        this.parentCollection = parentCollection;
        this.condition = condition;
    }

    public String toString() {
        return parentCollection.toString() + " filter(" + condition.getClass().getSimpleName() + ")";
    }

    public List<WebElement> getWrappedEntity() {
        List<WebElement> list = parentCollection.getWrappedEntity();
        List<WebElement> resultList = new ArrayList<WebElement>();

        for (WebElement element : list) {
            if (new LazyWrappedWebElement(this, element).is(condition)) {
                resultList.add(element);
            }
        }

        return resultList;
    }
}
