package core.conditions.collection;

import core.conditions.CustomCollectionCondition;
import core.wrappers.LazyEntity;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Size extends CustomCollectionCondition {

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

    public List<WebElement> check(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        List<WebElement> results = (List<WebElement>) lazyEntity.getWrappedEntity();
        listSize = results.size();
        return (listSize == expectedSize) ? results : null;
    }


}
