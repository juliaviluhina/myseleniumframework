package core.conditions.collection;

import core.conditions.CustomCollectionCondition;
import core.wrappers.LazyEntity;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MinimumSize extends CustomCollectionCondition {


    private int listSize;
    protected final int minimumSize;
    private LazyEntity lazyEntity;

    public MinimumSize(int minimumSize) {
        if (minimumSize == 0) {
            throw new IllegalArgumentException("Minimum size of element's list is 0.");
        }
        this.minimumSize = minimumSize;
    }

    public String toString() {
        return String.format("Size(%s)", minimumSize);
    }

    public String getActualValuesDescription() {
        return Integer.toString(listSize);
    }

    public List<WebElement> apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        List<WebElement> results = (List<WebElement>) lazyEntity.getWrappedEntity();
        listSize = results.size();
        return (listSize >= minimumSize) ? results : null;
    }


}
