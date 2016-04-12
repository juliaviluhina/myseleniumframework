package core.wrappers.element;

import org.openqa.selenium.*;

import static core.ConciseAPI.*;

public class LazyWebDriverElement extends AbstractLazyElement {

    private By locator;

    public LazyWebDriverElement(By locator) {
        this.locator = locator;
    }

    public String toString() {
        return locator.toString();
    }

    public WebElement getWrappedEntity() {
        return getDriver().findElement(locator);
    }

}
