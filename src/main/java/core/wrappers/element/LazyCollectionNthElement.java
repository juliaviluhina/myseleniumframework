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

    public WebElement getWrappedEntity() {
        //WaitFor.until(parentCollection, minimumSize(index + 1));
        //return parentCollection.getWrappedEntity().get(index);
        List<WebElement> elements = parentCollection.getWrappedEntity();
        return elements.size() >= (index+1) ? elements.get(index) : null;
    }

}
