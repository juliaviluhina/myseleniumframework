package core.commands;

import org.openqa.selenium.WebElement;

public class IsEnabled implements Command<Boolean> {

    public Boolean execute(WebElement element) {
        return element.isEnabled();
    }
}
