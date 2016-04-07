package core.conditions.element;

import core.conditions.ElementCondition;
import org.openqa.selenium.WebElement;

public class Visible extends ElementCondition {

    private boolean isDisplayed;

    protected String actual() {
        return isDisplayed ? "visible" : "invisible";
    }

    protected String expected() {
        return "visible";
    }

    protected WebElement check(WebElement element) {
        isDisplayed = element.isDisplayed();
        return isDisplayed ? element : null;
    }


}
