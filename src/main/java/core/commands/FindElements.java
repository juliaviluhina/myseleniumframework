package core.commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindElements implements Command<List<WebElement>> {
    By locator;

    public FindElements(By locator) {
        this.locator = locator;
    }

    public List<WebElement> execute(WebElement element) {
        return element.findElements(locator);
    }

}
