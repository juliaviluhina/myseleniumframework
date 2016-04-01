package core.wrappers;

import core.conditions.CustomElementCondition;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static core.ConditionWaiter.applyWithExceptionsCatching;


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
            if (applyWithExceptionsCatching(new LazyWrappedWebElement(this, element), condition) != null)
                resultList.add(element);
        }

        return resultList;
    }
}
