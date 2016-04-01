package core.wrappers;

import org.openqa.selenium.*;

import static core.ConciseAPI.*;
import static core.ConditionWaiter.waitFor;

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
