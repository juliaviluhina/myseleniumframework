package core.conditions.collection;

import core.conditions.AbstractCondition;
import core.conditions.CollectionCondition;
import org.openqa.selenium.WebElement;

import java.util.List;


public abstract class AbstractCollectionCondition extends AbstractCondition<List<WebElement>> implements CollectionCondition {
    public String identity() {
        return "elements";
    }
}
