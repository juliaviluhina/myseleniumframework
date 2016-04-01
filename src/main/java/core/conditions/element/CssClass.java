package core.conditions.element;

import core.conditions.CustomElementCondition;
import core.wrappers.LazyEntity;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

/**
 * Created by julia on 3/26/2016.
 */
public class CssClass extends CustomElementCondition {

    protected final String cssClass;
    String[] classes;
    private LazyEntity lazyEntity;

    public CssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String toString() {
        return String.format("cssClass is contained: ", cssClass);
    }

    public String getActualValuesDescription() {
        return Arrays.toString(classes);
    }

    public WebElement apply(LazyEntity lazyEntity) {
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
