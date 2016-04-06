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

    protected WebElement check() {
        isDisplayed = wrappedEntity.isDisplayed();
        return isDisplayed ? wrappedEntity : null;
    }


}
