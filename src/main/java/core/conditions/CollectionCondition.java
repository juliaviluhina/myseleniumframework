package core.conditions;

import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class CollectionCondition extends EntityCondition<List<WebElement>> {

    protected String identity() {
        return "elements";
    }


}
