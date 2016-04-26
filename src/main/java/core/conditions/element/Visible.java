package core.conditions.element;

import org.openqa.selenium.WebElement;

public class Visible extends AbstractElementCondition {

    private boolean isDisplayed;

    public String actual() {
        return isDisplayed ? "visible" : "invisible";
    }

    public String expected() {
        return "visible";
    }

    public boolean check(WebElement element) {
        isDisplayed = element.isDisplayed();
        return isDisplayed;
    }


}
