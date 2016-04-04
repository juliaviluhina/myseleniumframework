package core.conditions.collection;

import core.conditions.CustomCollectionCondition;
import core.wrappers.LazyEntity;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MinimumSize extends CustomCollectionCondition {

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

    public List<WebElement> apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        List<WebElement> results = (List<WebElement>) lazyEntity.getWrappedEntity();
        listSize = results.size();
        return (listSize >= expectedMinimumSize) ? results : null;
    }


}
