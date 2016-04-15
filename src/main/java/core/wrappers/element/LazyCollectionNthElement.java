package core.wrappers.element;

import core.wrappers.LazyCollection;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LazyCollectionNthElement extends AbstractLazyElement {

    private int index;
    private LazyCollection parentCollection;

    public LazyCollectionNthElement(LazyCollection parentCollection, int index) {
        this.parentCollection = parentCollection;
        this.index = index;
    }

    public String toString() {
        return parentCollection.toString() + "[" + index + "]";
    }

    public WebElement fetchWrappedEntity() {
        return parentCollection.getWrappedEntity().get(index);
    }

}
