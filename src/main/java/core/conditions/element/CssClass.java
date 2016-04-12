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

    public WebElement check(WebElement element) {
        String[] classes = element.getAttribute("class").split(" ");
        for (int i = 0; i < classes.length; i++) {
            if (classes[i].equals(cssClass)) {
                return element;
            }
        }
        return null;
    }

}
