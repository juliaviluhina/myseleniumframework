package core.conditions.element;

import core.conditions.CustomElementCondition;
import core.wrappers.LazyEntity;
import org.openqa.selenium.WebElement;


public class ElementPresent extends CustomElementCondition {

    private LazyEntity lazyEntity;

    public String toString() {
        return String.format("present");
    }

    public String getActualValuesDescription() {
        return "";
    }

    public WebElement apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        WebElement element = (WebElement) lazyEntity.getWrappedEntity();
        return element;
    }

}
