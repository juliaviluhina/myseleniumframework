package core.wrappers.element;

import core.conditions.ElementCondition;
import core.exceptions.ElementNotFoundException;
import core.wrappers.LazyCollection;
import org.openqa.selenium.WebElement;

import java.util.List;


public class LazyCollectionFoundByConditionElement extends AbstractLazyElement {

    private ElementCondition condition;
    private LazyCollection parentCollection;

    public LazyCollectionFoundByConditionElement(LazyCollection parentCollection, ElementCondition condition) {
        this.parentCollection = parentCollection;
        this.condition = condition;
    }

    public String toString() {
        return parentCollection.toString() + " find(" + condition.getClass().getSimpleName() + ")";
    }


    public WebElement fetchWrappedEntity() {
        List<WebElement> list = parentCollection.getWrappedEntity();

        for (WebElement element : list) {
            if (condition.check(element)) {
                return element;
            }
        }

        throw new ElementNotFoundException(toString());
    }

}

