package core.commands;

import core.wrappers.LazyElement;
import org.openqa.selenium.WebElement;

public class IsDisplayed implements Command<Boolean> {

    public Boolean execute(WebElement element) {
        return element.isDisplayed();
    }
}
