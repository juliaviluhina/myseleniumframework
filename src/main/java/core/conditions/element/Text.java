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

    protected WebElement check(WebElement element) {
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
