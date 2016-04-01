package core.wrappers.element;

import core.wrappers.element.LazyElement;
import org.openqa.selenium.*;

import static core.ConciseAPI.*;
import static core.WaitFor.waitFor;

public class LazyElementByLocator extends LazyElement {

    protected By locator;

    public LazyElementByLocator(By locator) {
        this.locator = locator;
    }

    public String toString() {
        return locator.toString();
    }

    public WebElement getWrappedEntity() {
        return getDriver().findElement(locator);
    }

}
