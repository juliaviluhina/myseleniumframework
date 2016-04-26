package core.conditions.element;

import org.openqa.selenium.WebElement;

public class Text extends AbstractElementCondition {

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

    public boolean checkElement() {
        return currentText.contains(text);
    }

}
