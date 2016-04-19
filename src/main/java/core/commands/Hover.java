package core.commands;

import org.openqa.selenium.WebElement;

import static core.ConciseAPI.actions;

public class Hover implements Command<WebElement>  {

    public WebElement execute(WebElement element) {
        actions().moveToElement(element).perform();
        return element;
    }
}
