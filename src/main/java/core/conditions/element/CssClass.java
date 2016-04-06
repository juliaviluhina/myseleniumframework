package core.conditions.element;

import core.conditions.ElementCondition;
import org.openqa.selenium.WebElement;

import java.util.Arrays;


public class CssClass extends ElementCondition {

    protected final String cssClass;
    String[] classes;

    public CssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String actual() {
        return Arrays.toString(classes);
    }

    public String expected() {
        return cssClass;
    }

    protected WebElement check() {
        String[] classes = wrappedEntity.getAttribute("class").split(" ");
        for (int i = 0; i < classes.length; i++) {
            if (classes[i].equals(cssClass)) {
                return wrappedEntity;
            }
        }
        return null;
    }


}
