package core.conditions.collection;

import core.conditions.CollectionCondition;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Size extends CollectionCondition {

    public int listSize;
    public int expectedSize;

    public Size(int expectedSize) {
        this.expectedSize = expectedSize;
    }

    public String actual() {
        return Integer.toString(listSize);
    }

    public String expected() {
        return Integer.toString(expectedSize);
    }

    public List<WebElement> check(List<WebElement> elements) {
        listSize = elements.size();
        return checkList() ? elements : null;
    }

    public boolean checkList() {
        return listSize == expectedSize;
    }
}
