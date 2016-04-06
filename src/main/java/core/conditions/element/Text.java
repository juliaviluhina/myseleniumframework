package core.conditions.element;

import core.conditions.ElementCondition;
import org.openqa.selenium.WebElement;

public class Text extends ElementCondition {

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

    public WebElement check() {
        currentText = wrappedEntity.getText();
        if (!checkElement()) {
            return null;
        }
        return wrappedEntity;
    }

    protected boolean checkElement() {
        return currentText.contains(text);
    }

}
