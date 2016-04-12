package core.conditions;

import core.conditions.AbstractCondition;
import org.openqa.selenium.WebElement;

public abstract class ElementCondition extends AbstractCondition<WebElement> {

    public String identity() {
        return "element";
    }
}
