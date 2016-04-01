package core.conditions.element;

import core.conditions.CustomElementCondition;
import core.wrappers.LazyEntity;
import org.openqa.selenium.WebElement;

public class Text extends CustomElementCondition {

    protected String currentText;
    protected String text;
    protected LazyEntity lazyEntity;

    public Text(String text) {
        this.text = text;
    }

    public String toString() {
        return String.format("Text contains: %s", text);
    }

    public String getActualValuesDescription() {
        return currentText;
    }

    public WebElement apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        WebElement element = (WebElement) lazyEntity.getWrappedEntity();
        currentText = element.getText();
        if (!check()) {
            return null;
        }
        return element;
    }

    protected boolean check() {
        return currentText.contains(text);
    }


}
