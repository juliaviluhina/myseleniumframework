package core.conditions.element;

import core.conditions.CustomElementCondition;
import core.wrappers.LazyEntity;
import org.openqa.selenium.WebElement;

public class Text extends CustomElementCondition {

    protected String currentText;
    protected String text;

    public Text(String text) {
        this.text = text;
    }

    public String actual() {
        return currentText;
    }

    public String expected() {
        return text;
    }

    public WebElement check(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        WebElement element = (WebElement) lazyEntity.getWrappedEntity();
        currentText = element.getText();
        if (!checkElement()) {
            return null;
        }
        return element;
    }

    protected boolean checkElement() {
        return currentText.contains(text);
    }

}
