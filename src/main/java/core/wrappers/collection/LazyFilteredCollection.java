package core.wrappers.collection;

import core.conditions.CustomElementCondition;
import core.wrappers.element.LazyWrappedWebElement;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;




public class LazyFilteredCollection extends LazyCollection {

    private CustomElementCondition condition;
    private LazyCollection parentCollection;

    public LazyFilteredCollection(LazyCollection parentCollection, CustomElementCondition condition) {
        this.parentCollection = parentCollection;
        this.condition = condition;
    }

    public String toString() {
        return parentCollection.toString() + " filter(" + condition + ")";
    }

    public List<WebElement> getWrappedEntity() {
        List<WebElement> list = parentCollection.getWrappedEntity();
        List<WebElement> resultList = new ArrayList<WebElement>();

        for (WebElement element : list) {
            if (condition.apply(new LazyWrappedWebElement(this, element)) != null)
                resultList.add(element);
        }

        return resultList;
    }
}
