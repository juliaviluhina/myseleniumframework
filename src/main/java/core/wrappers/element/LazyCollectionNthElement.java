package core.wrappers.element;

import core.wrappers.collection.AbstractLazyCollection;
import org.openqa.selenium.WebElement;

import core.WaitFor;

import static core.conditions.CollectionConditions.minimumSize;

public class LazyCollectionNthElement extends AbstractLazyElement {

    private int index;
    private AbstractLazyCollection parentCollection;

    public LazyCollectionNthElement(AbstractLazyCollection parentCollection, int index) {
        this.parentCollection = parentCollection;
        this.index = index;
    }

    public String toString() {
        return parentCollection.toString() + "[" + index + "]";
    }

    public WebElement getWrappedEntity() {
        WaitFor.until(parentCollection, minimumSize(index + 1));
        return parentCollection.getWrappedEntity().get(index);
    }

}
