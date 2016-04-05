package core.wrappers.element;

import core.conditions.CustomElementCondition;
import core.wrappers.collection.LazyCollection;
import org.openqa.selenium.WebElement;

import java.util.List;


public class LazyCollectionElementByCondition extends LazyElement {

    private CustomElementCondition condition;
    private LazyCollection parentCollection;

    public LazyCollectionElementByCondition(LazyCollection parentCollection, CustomElementCondition condition) {
        this.parentCollection = parentCollection;
        this.condition = condition;
    }

    public String toString() {
        return parentCollection.toString() + " find(" + condition + ")";
    }


    public WebElement getWrappedEntity() {
        List<WebElement> list = parentCollection.getWrappedEntity();

        for (WebElement element : list) {
            if (condition.apply(new LazyWrappedWebElement(this, element)) != null)
                return element;
        }

        return null;
    }

}

