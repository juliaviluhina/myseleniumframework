package core.conditions.element;

import core.conditions.ElementCondition;
import org.openqa.selenium.WebElement;


public class Present extends ElementCondition {

    private boolean isPresent;

    protected String actual() {
        return isPresent ? "not " : "" + "present";
    }

    protected String expected() {
        return "present";
    }

    protected WebElement check(WebElement element) {
        isPresent = (element != null);
        return element;
    }

}
