package core.commands;

import core.wrappers.LazyElement;
import org.openqa.selenium.WebElement;

public class SetValue implements Command<WebElement>  {

    private String text;

    public SetValue(String text) {
        this.text = text;
    }

    public WebElement execute(WebElement element) {
        element.clear();
        element.sendKeys(text);
        return element;
    }
}