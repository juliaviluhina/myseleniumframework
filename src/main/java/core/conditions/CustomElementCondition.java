package core.conditions;

import org.openqa.selenium.WebElement;

public abstract class CustomElementCondition extends CustomCondition<WebElement> {

    public String identity() {
        return "element";
    }
}
