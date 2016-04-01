package core.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static core.WaitFor.waitFor;
import static core.conditions.CustomElementConditions.visible;

public class LazyCollectionElementByInnerLocator extends LazyElement {

    private By innerLocator;
    private LazyElement parentElement;

    public LazyCollectionElementByInnerLocator(LazyElement parentElement, By innerLocator) {
        this.parentElement = parentElement;
        this.innerLocator = innerLocator;
    }

    public String toString() {
        return parentElement.toString() + " find(" + innerLocator + ")";
    }

    public WebElement getWrappedEntity() {
        waitFor(parentElement, visible());
        return parentElement.getWrappedEntity().findElement(innerLocator);
    }

}
