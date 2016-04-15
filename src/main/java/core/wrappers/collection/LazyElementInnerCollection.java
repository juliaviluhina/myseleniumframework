package core.wrappers.collection;

import core.wrappers.LazyElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LazyElementInnerCollection extends AbstractLazyCollection {

    private LazyElement parentElement;
    private By innerLocator;

    public LazyElementInnerCollection(LazyElement parentElement, By innerLocator) {
        this.parentElement = parentElement;
        this.innerLocator = innerLocator;
    }

    public String toString() {
        return parentElement.toString() + " findAll(" + innerLocator + ")";
    }

    public List<WebElement> getWrappedEntity() {
        return parentElement.getWrappedEntity() == null ? null : parentElement.getWrappedEntity().findElements(innerLocator);
    }

}
