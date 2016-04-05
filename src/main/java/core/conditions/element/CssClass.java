package core.conditions.element;

import core.conditions.CustomElementCondition;
import core.wrappers.LazyEntity;
import org.openqa.selenium.WebElement;

import java.util.Arrays;


public class CssClass extends CustomElementCondition {

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

    public WebElement check(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        WebElement element = (WebElement) lazyEntity.getWrappedEntity();
        String[] classes = element.getAttribute("class").split(" ");
        for (int i = 0; i < classes.length; i++) {
            if (classes[i].equals(cssClass)) {
                return element;
            }
        }
        return null;
    }


}
