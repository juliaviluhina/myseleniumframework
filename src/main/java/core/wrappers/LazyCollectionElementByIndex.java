package core.wrappers;

import org.openqa.selenium.WebElement;

import static core.WaitFor.waitFor;
import static core.conditions.CustomCollectionConditions.minimumSize;

public class LazyCollectionElementByIndex extends LazyElement {

    private int index;
    private LazyCollection parentCollection;

    public LazyCollectionElementByIndex(LazyCollection parentCollection, int index) {
        this.parentCollection = parentCollection;
        this.index = index;
    }

    public String toString() {
        return parentCollection.toString() + "[" + index + "]";
    }

    public WebElement getWrappedEntity() {
        waitFor(parentCollection, minimumSize(index + 1));
        return parentCollection.getWrappedEntity().get(index);
    }

}
