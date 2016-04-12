package core.wrappers.element;

import core.wrappers.LazyElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LazyElementInnerElement extends AbstractLazyElement {

    private By innerLocator;
    private LazyElement parentElement;

    public LazyElementInnerElement(LazyElement parentElement, By innerLocator) {
        this.parentElement = parentElement;
        this.innerLocator = innerLocator;
    }

    public String toString() {
        return parentElement.toString() + " find(" + innerLocator + ")";
    }

    public WebElement getWrappedEntity() {
        //WaitFor.until(parentElement, visible());
        return parentElement.getWrappedEntity().findElement(innerLocator);
    }

}
