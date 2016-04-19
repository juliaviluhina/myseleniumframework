package core.commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FindElement implements Command<WebElement> {
    By locator;

    public FindElement(By locator) {
        this.locator = locator;
    }

    public WebElement execute(WebElement element) {
        return element.findElement(locator);
    }

}
