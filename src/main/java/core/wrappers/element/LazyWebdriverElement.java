package core.wrappers.element;

import org.openqa.selenium.*;

import static core.ConciseAPI.*;

public class LazyWebdriverElement extends AbstractLazyElement {

    protected By locator;

    public LazyWebdriverElement(By locator) {
        this.locator = locator;
    }

    public String toString() {
        return locator.toString();
    }

    public WebElement getWrappedEntity() {
        return getDriver().findElement(locator);
    }

}
