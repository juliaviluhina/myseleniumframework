package core.conditions.element;

import core.conditions.ElementCondition;
import org.openqa.selenium.WebElement;


public class Present extends ElementCondition {

    private boolean isPresent;

    public String actual() {
        return isPresent ? "not " : "" + "present";
    }

    public String expected() {
        return "present";
    }

    public WebElement check(WebElement element) {
        isPresent = (element != null);
        return element;
    }

}
