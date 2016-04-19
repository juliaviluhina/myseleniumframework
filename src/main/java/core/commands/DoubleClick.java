package core.commands;

import org.openqa.selenium.WebElement;

import static core.ConciseAPI.actions;


public class DoubleClick implements Command<WebElement>  {

    public WebElement  execute(WebElement element) {
        actions().doubleClick(element).perform();
        return element;
    }
}
