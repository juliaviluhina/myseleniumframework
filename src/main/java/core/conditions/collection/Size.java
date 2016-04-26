package core.conditions.collection;

import org.openqa.selenium.WebElement;

import java.util.List;

public class Size extends AbstractCollectionCondition {

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

    public boolean check(List<WebElement> elements) {
        listSize = elements.size();
        return checkList();
    }

    public boolean checkList() {
        return listSize == expectedSize;
    }
}
