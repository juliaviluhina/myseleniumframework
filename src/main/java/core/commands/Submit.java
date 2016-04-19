package core.commands;

import org.openqa.selenium.WebElement;

public class Submit implements Command<WebElement>  {

    public WebElement execute(WebElement element) {
        element.submit();
        return element;
    }
}
