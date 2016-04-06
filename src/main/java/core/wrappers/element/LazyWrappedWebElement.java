package core.wrappers.element;

import core.wrappers.LazyEntity;
import org.openqa.selenium.WebElement;

public class LazyWrappedWebElement extends AbstractLazyElement {

    WebElement element;
    LazyEntity parentEntity;

    public LazyWrappedWebElement(LazyEntity parentEntity, WebElement element) {
        this.parentEntity = parentEntity;
        this.element = element;
    }

    public WebElement getWrappedEntity() {
        return element;
    }

    public String toString() {
        return "WebElement " + element.toString() + " from " + parentEntity;
    }
}
