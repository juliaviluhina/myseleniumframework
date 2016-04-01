package core.wrappers;

import core.conditions.CustomElementCondition;
import org.openqa.selenium.WebElement;

import java.util.List;

import static core.WaitFor.applyWithExceptionsCatching;


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
            if (applyWithExceptionsCatching(new LazyWrappedWebElement(this, element), condition) != null)
                return element;
        }

        return null;
    }

}

