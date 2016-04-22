package core.commands;

import org.openqa.selenium.WebElement;

public interface Command<TypeOfResult> {
    TypeOfResult execute(WebElement element);
}
