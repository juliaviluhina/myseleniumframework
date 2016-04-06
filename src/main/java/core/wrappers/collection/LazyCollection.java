package core.wrappers.collection;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

import static core.ConciseAPI.getDriver;

public class LazyCollection extends AbstractLazyCollection {

    protected By locator;

    public LazyCollection(By locator) {
        this.locator = locator;
    }

    public String toString() {
        return locator.toString();
    }

    public List<WebElement> getWrappedEntity() {
        return getDriver().findElements(locator);
    }

}


