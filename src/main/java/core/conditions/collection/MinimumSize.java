package core.conditions.collection;

import core.conditions.CollectionCondition;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MinimumSize extends CollectionCondition {

    private int listSize;
    protected final int expectedMinimumSize;

    public MinimumSize(int expectedMinimumSize) {
        if (expectedMinimumSize == 0) {
            throw new IllegalArgumentException("Minimum size of element's list is 0.");
        }
        this.expectedMinimumSize = expectedMinimumSize;
    }

    public String actual() {
        return Integer.toString(listSize);
    }

    public String expected() {
        return Integer.toString(expectedMinimumSize);
    }

    protected List<WebElement> check(List<WebElement> elements) {
        listSize = elements.size();
        return (listSize >= expectedMinimumSize) ? elements : null;
    }


}
