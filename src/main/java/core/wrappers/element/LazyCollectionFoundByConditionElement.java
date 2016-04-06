package core.wrappers.element;

import core.conditions.ElementCondition;
import core.wrappers.collection.AbstractLazyCollection;
import org.openqa.selenium.WebElement;

import java.util.List;


public class LazyCollectionFoundByConditionElement extends AbstractLazyElement {

    private ElementCondition condition;
    private AbstractLazyCollection parentCollection;

    public LazyCollectionFoundByConditionElement(AbstractLazyCollection parentCollection, ElementCondition condition) {
        this.parentCollection = parentCollection;
        this.condition = condition;
    }

    public String toString() {
        return parentCollection.toString() + " find(" + condition + ")";
    }


    public WebElement getWrappedEntity() {
        List<WebElement> list = parentCollection.getWrappedEntity();

        for (WebElement element : list) {
            if (new LazyWrappedWebElement(this, element).is(condition)) {
                return element;
            }
        }

        return null;
    }

}

