package core.conditions.collection;

import core.conditions.CustomCollectionCondition;
import core.wrappers.LazyEntity;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Size extends CustomCollectionCondition {

    private int listSize;
    protected final int expectedSize;
    private LazyEntity lazyEntity;

    public Size(int expectedSize) {
        this.expectedSize = expectedSize;
    }

    public String toString() {
        return String.format("size(%s)", expectedSize);
    }

    public String getActualValuesDescription() {
        return Integer.toString(listSize);
    }

    public List<WebElement> apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        List<WebElement> results = (List<WebElement>) lazyEntity.getWrappedEntity();
        listSize = results.size();
        return (listSize == expectedSize) ? results : null;
    }


}
