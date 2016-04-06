package core.conditions.element;

import core.conditions.ElementCondition;
import org.openqa.selenium.WebElement;


public class Present extends ElementCondition {
    private WebElement element;

    public String actual() {
        return (element == null) ? "not " : "" + "present";
    }

    public String expected() {
        return "present";
    }

    protected WebElement check() {
        return wrappedEntity;
    }

}
