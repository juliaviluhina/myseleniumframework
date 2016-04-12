package core.wrappers.element;

import org.openqa.selenium.*;

import static core.ConciseAPI.*;

public class LazyWebDriverElement1 extends AbstractLazyElement {

    private By locator;

    public LazyWebDriverElement1(By locator) {
        this.locator = locator;
    }

    public String toString() {
        return locator.toString();
    }

    public WebElement getWrappedEntity() {
        return getDriver().findElement(locator);
    }

}
