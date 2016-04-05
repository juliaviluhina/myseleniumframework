package core.wrappers.element;

import org.openqa.selenium.*;

import static core.ConciseAPI.*;

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
