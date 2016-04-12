package core.wrappers.collection;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

import static core.ConciseAPI.getDriver;

public class LazyWebDriverCollection extends AbstractLazyCollection {

    private By locator;

    public LazyWebDriverCollection(By locator) {
        this.locator = locator;
    }

    public String toString() {
        return locator.toString();
    }

    public List<WebElement> getWrappedEntity() {
        return getDriver().findElements(locator);
    }

}


