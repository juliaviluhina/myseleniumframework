package core.conditions.collection;

import core.conditions.CollectionCondition;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Size extends CollectionCondition {

    private int listSize;
    protected final int expectedSize;

    public Size(int expectedSize) {
        this.expectedSize = expectedSize;
    }

    public String actual() {
        return Integer.toString(listSize);
    }

    public String expected() {
        return Integer.toString(expectedSize);
    }

    protected List<WebElement> check() {
        listSize = wrappedEntity.size();
        return (listSize == expectedSize) ? wrappedEntity : null;
    }


}
