package core.wrappers.collection;

import core.wrappers.element.LazyElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import core.WaitFor;

import static core.conditions.CustomElementConditions.present;

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
        WaitFor.until(parentElement, present());
        return parentElement.getWrappedEntity().findElements(innerLocator);
    }

}
