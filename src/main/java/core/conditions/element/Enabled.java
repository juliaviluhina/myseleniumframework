package core.conditions.element;

import org.openqa.selenium.WebElement;


public class Enabled extends AbstractElementCondition {

    private boolean isEnabled;

    public String actual() {
        return isEnabled ? "enabled" : "disabled";
    }

    public String expected() {
        return "enabled";
    }

    public boolean check(WebElement element) {
        isEnabled = element.isEnabled();
        return isEnabled;
    }


}

