package core.conditions.collection;

import core.conditions.CollectionCondition;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Size extends CollectionCondition {

    protected int listSize;
    protected int expectedSize;

    public Size(int expectedSize) {
        this.expectedSize = expectedSize;
    }

    public String actual() {
        return Integer.toString(listSize);
    }

    public String expected() {
        return Integer.toString(expectedSize);
    }

    protected List<WebElement> check(List<WebElement> elements) {
        listSize = elements.size();
        return checkList() ? elements : null;
    }

    protected boolean checkList() {
        return listSize == expectedSize;
    }
}
