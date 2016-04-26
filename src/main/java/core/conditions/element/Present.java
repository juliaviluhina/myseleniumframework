package core.conditions.element;

import org.openqa.selenium.WebElement;


public class Present extends AbstractElementCondition {

    private boolean isPresent;

    public String actual() {
        return isPresent ? "not " : "" + "present";
    }

    public String expected() {
        return "present";
    }

    public boolean check(WebElement element) {
        isPresent = (element != null);
        return isPresent;
    }

}
