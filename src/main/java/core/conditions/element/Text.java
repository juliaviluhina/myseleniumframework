package core.conditions.element;

import core.conditions.ElementCondition;
import org.openqa.selenium.WebElement;

public class Text extends ElementCondition {

    public String currentText;
    public String text;

    public Text(String text) {
        this.text = text;
    }

    public String actual() {
        return currentText;
    }

    public String expected() {
        return text;
    }

    public boolean check(WebElement element) {
        currentText = element.getText();
        return checkElement();
    }

    protected boolean checkElement() {
        return currentText.contains(text);
    }

}
