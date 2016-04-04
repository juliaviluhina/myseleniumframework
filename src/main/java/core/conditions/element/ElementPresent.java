package core.conditions.element;

import core.conditions.CustomElementCondition;
import core.wrappers.LazyEntity;
import org.openqa.selenium.WebElement;


public class ElementPresent extends CustomElementCondition {

    public String actual() {
        return "";
    }

    public String expected() {
        return "present";
    }

    public WebElement apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        WebElement element = (WebElement) lazyEntity.getWrappedEntity();
        return element;
    }

}
