package core.conditions;

import org.openqa.selenium.WebElement;

public abstract class ElementCondition extends EntityCondition<WebElement> {

    protected String identity() {
        return "element";
    }
}
