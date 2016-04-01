package core.wrappers.collection;

import core.wrappers.element.LazyElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static core.WaitFor.waitFor;
import static core.conditions.CustomElementConditions.present;
import static core.conditions.CustomElementConditions.visible;

public class LazyCollectionByInnerLocator extends LazyCollection {

    private LazyElement parentElement;
    private By innerLocator;

    public LazyCollectionByInnerLocator(LazyElement parentElement, By innerLocator) {
        this.parentElement = parentElement;
        this.innerLocator = innerLocator;
    }

    public String toString() {
        return parentElement.toString() + " findAll(" + innerLocator + ")";
    }

    public List<WebElement> getWrappedEntity() {
        waitFor(parentElement, present());
        return parentElement.getWrappedEntity().findElements(innerLocator);
    }

}
