package core.conditions.element;

import core.conditions.ElementCondition;
import org.openqa.selenium.WebElement;

public class Visible extends ElementCondition {

    private boolean isDisplayed;

    public String actual() {
        return isDisplayed ? "visible" : "invisible";
    }

    public String expected() {
        return "visible";
    }

    public WebElement check(WebElement element) {
        isDisplayed = element.isDisplayed();
        return isDisplayed ? element : null;
    }


}
