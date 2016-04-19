package core.commands;

import org.openqa.selenium.WebElement;

public class IsSelected implements Command<Boolean> {

    public Boolean execute(WebElement element) {
        return element.isSelected();
    }
}
