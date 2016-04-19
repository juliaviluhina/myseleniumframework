package core.commands;

import org.openqa.selenium.WebElement;

public class Click implements Command<WebElement>  {

    public WebElement execute(WebElement element) {
        element.click();
        return element;
    }
}