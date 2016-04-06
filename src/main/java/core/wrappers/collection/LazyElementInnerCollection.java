package core.wrappers.collection;

import core.wrappers.element.AbstractLazyElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import core.WaitFor;

import static core.conditions.ElementConditions.present;

public class LazyElementInnerCollection extends AbstractLazyCollection {

    private AbstractLazyElement parentElement;
    private By innerLocator;

    public LazyElementInnerCollection(AbstractLazyElement parentElement, By innerLocator) {
        this.parentElement = parentElement;
        this.innerLocator = innerLocator;
    }

    public String toString() {
        return parentElement.toString() + " findAll(" + innerLocator + ")";
    }

    public List<WebElement> getWrappedEntity() {
        WaitFor.until(parentElement, present());
        return parentElement.getWrappedEntity().findElements(innerLocator);
    }

}
