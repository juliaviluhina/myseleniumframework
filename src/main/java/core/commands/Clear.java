package core.commands;

import org.openqa.selenium.WebElement;

public class Clear implements Command<WebElement> {
    public WebElement execute(WebElement element) {
        element.clear();
        return element;
    }
}
