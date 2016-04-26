package core.conditions.element;

import core.conditions.AbstractCondition;
import core.conditions.ElementCondition;
import org.openqa.selenium.WebElement;

public abstract class AbstractElementCondition extends AbstractCondition<WebElement> implements ElementCondition {
    public String identity() {
        return "element";
    }
}
