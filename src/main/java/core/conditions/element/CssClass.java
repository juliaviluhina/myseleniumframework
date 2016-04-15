package core.conditions.element;

import core.conditions.ElementCondition;
import org.openqa.selenium.WebElement;

import java.util.Arrays;


public class CssClass extends ElementCondition {

    public final String cssClass;
    public String[] classes;

    public CssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String actual() {
        return Arrays.toString(classes);
    }

    public String expected() {
        return cssClass;
    }

    public boolean check(WebElement element) {
        boolean found = false;
        String[] classes = element.getAttribute("class").split(" ");
        for (int i = 0; i < classes.length; i++) {
            found = classes[i].equals(cssClass);
            if (found) {
                break;
            }
        }
        return found;
    }

}
